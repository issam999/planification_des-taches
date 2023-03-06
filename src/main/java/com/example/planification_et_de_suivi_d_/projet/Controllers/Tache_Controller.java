package com.example.planification_et_de_suivi_d_.projet.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.planification_et_de_suivi_d_.projet.Models.EntityNotFoundException;
import com.example.planification_et_de_suivi_d_.projet.Models.Membre;
import com.example.planification_et_de_suivi_d_.projet.Models.Tache;
import com.example.planification_et_de_suivi_d_.projet.Service.Tache_Service;


@RestController
public class Tache_Controller {

	@Autowired
	Tache_Service Tache_service; 
	
	@PostMapping("/Tache/Ajouter")
	@ResponseBody
	public Tache Ajouter_Projet(@RequestBody Tache tache)
	{
		
		return Tache_service.Ajouter_Tache(tache);
	}

	
	
	
	
	@GetMapping("/Taches/Afficher")
	@ResponseBody
	public List<Tache> Afficher()
	{
		return  Tache_service.Afficher_Tache();
	}
	@GetMapping("/Taches/Afficher/{Id}")
	@ResponseBody
	public Optional<Tache> Afficher_by_id(@PathVariable Long Id)
	{
			return  Tache_service.Get_BY_Id(Id);
	}
	
	
	@DeleteMapping("/Tache/Delete/{Id}")
	@ResponseBody
	
	void Delete_Tache(@PathVariable Long Id) {
		if(! Tache_service.exists(Id))
			throw new EntityNotFoundException("le code n'exist pas");
		Tache_service.DeleteTacheById(Id);
		
	}
	
	@PutMapping("/tache/Modifier/{id}")
	@ResponseBody
	public ResponseEntity<?> Modifie_Tache (@RequestBody Tache t ,@PathVariable Long id)
	{
		
		if (Tache_service.exists(id)) 
		{
		
		
			Tache  tache =Tache_service.Get_BY_Id(id).get();
			tache.setNom(t.getNom());
			tache.setDuree(t.getDuree());
			tache.setEtat(t.getEtat());
			tache.setMembres(t.getMembres());
			
			Tache_service.Ajouter_Tache(tache);
			return ResponseEntity.ok().body(tache);
			
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new EntityNotFoundException("le code "+id+"n'exist pas"));
	
		
		
	}
	
	
}
