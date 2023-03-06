package com.example.planification_et_de_suivi_d_.projet.Controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.planification_et_de_suivi_d_.projet.Models.EntityNotFoundException;
import com.example.planification_et_de_suivi_d_.projet.Models.Membre;
import com.example.planification_et_de_suivi_d_.projet.Models.Projet;
import com.example.planification_et_de_suivi_d_.projet.Models.Tache;
import com.example.planification_et_de_suivi_d_.projet.Service.Membre_Service;
import com.example.planification_et_de_suivi_d_.projet.Service.Tache_Service;

		
	
		@RestController
		@RequestMapping("/api/v1")
		public class Membre_Controllers{
			
		
		@Autowired
		Membre_Service Membre_Services;
		
		@Autowired
		Tache_Service tache_service;
			
		@PostMapping("/Membre")
		@ResponseBody
		Membre Ajouter_Memb(Membre membre) {
				return Membre_Services.Ajouter_Membre(membre);
		}
		@DeleteMapping("/Membre/Delete/{Id}")

		void Delete_Memb(@PathVariable Long Id) {
			
			if(! Membre_Services.exist(Id))
				throw new EntityNotFoundException("le code de Membre n'exist pas");
			Membre_Services.DeleteMembre(Id);
		}
		@DeleteMapping("/Membre/Delete")
		void Delete_Membre(Membre Membre) {
				
			Membre_Services.DeleteMembre(Membre);
			
		}
		
		@GetMapping("/Membre")
		public List<Membre> Afficher_les_Membre()
		{
			
			List <Membre> list= Membre_Services.Get_All_Membre();
			return list;
			
		}
		
		@GetMapping("/Membre/{Id}")
		@ResponseBody
		public Optional<Membre> AfficherParId(@PathVariable Long Id)
		{
			if(! Membre_Services.exist(Id))
				throw new EntityNotFoundException("le code de Membre n'exist pas");
			Optional<Membre> m=Membre_Services.Get_By_Id(Id);
			return m;
		}
		
		
		@ResponseBody
		@Modifying
		@PutMapping(value = "/Membre/Modifier/{Id}", consumes = {"application/json"})
		public ResponseEntity<?> Modifie_Membre (@RequestBody Membre m ,@PathVariable Long Id)
		{
			
			if (Membre_Services.exists(Id))   
			{
			
			
				Membre membre = Membre_Services.Get_By_Id(Id).get();
				membre.setId(m.getId());
				membre.setNom(m.getNom());
				membre.setPrenom(m.getPrenom());
				membre.setEmail(m.getEmail());
				membre.setPoste(m.getPoste());
				return ResponseEntity.ok().body(membre);
				
			}
			else
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new EntityNotFoundException("le code "+Id+"n'exist pas"));
		
			}
		
		
		
		@PutMapping("/Membre/Modifier/{id}/{Id}")
		@ResponseBody
		public ResponseEntity<?> Modifie_Membre (@PathVariable (name = "id") Long id,@PathVariable (name = "Id") Long id_tache,@RequestBody Tache tache)
		{
			
			if (Membre_Services.exists(id)) 
			{
				Membre m= Membre_Services.Get_By_Id(id).get();			
				List<Tache> t= m.getTaches();
				for (Tache i : t)
				{
					if (i.getId()== id_tache)
					{
						i.setDuree(tache.getDuree());
						i=tache;
						
					}
					m.setTaches(t);
					tache_service.Ajouter_Tache(i);

				}
				return ResponseEntity.ok().body(m);

			}

			/*	List<Tache> t = tache_service.Afficher_Tache();
				
				for (Tache i :t )
				{
					if (i.getId()== id_tache)
						i=tache;
					tache_service.Ajouter_Tache(tache)
					
				}
				*/
			
				
				//Liste des taches 
				//foreach : t<- membre
				
				
		
			else
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new EntityNotFoundException("le code "+id+"n'exist pas"));
		
	
		}
		
		@PutMapping(value = "/Membre/Ajouter_Tache/{Id}/{Id_tache}")
		public ResponseEntity<?> Ajouter_Tache_Membre(@PathVariable Long Id,@PathVariable Long Id_tache) {
			
			if ((Membre_Services.exists(Id)) ||(tache_service.exists(Id_tache)))
			{
				
				Membre m =Membre_Services.Get_By_Id(Id).get();
				Tache tache = tache_service.Get_BY_Id(Id_tache).get();
				tache.setMembres(m);
				tache_service.Ajouter_Tache(tache);
				return ResponseEntity.ok().body(tache);
			}
			else 
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new EntityNotFoundException("le code "+Id+"n'exist pas"));

			}

			
		}
		

	
		
