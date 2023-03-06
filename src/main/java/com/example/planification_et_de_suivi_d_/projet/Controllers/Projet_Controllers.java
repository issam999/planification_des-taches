package com.example.planification_et_de_suivi_d_.projet.Controllers;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.planification_et_de_suivi_d_.projet.Models.EntityNotFoundException;
import com.example.planification_et_de_suivi_d_.projet.Models.Membre;
import com.example.planification_et_de_suivi_d_.projet.Models.Projet;
import com.example.planification_et_de_suivi_d_.projet.Models.Tache;
import com.example.planification_et_de_suivi_d_.projet.Service.Membre_Service;
import com.example.planification_et_de_suivi_d_.projet.Service.Projet_Service;
import com.example.planification_et_de_suivi_d_.projet.Service.Tache_Service;

@RestController

@RequestMapping("/api/v2")
public class Projet_Controllers {
	
	@Autowired
	Projet_Service projet_service;
	@Autowired
	Membre_Service	membre_service;
	@Autowired
	Tache_Service tache_service;
	
	@PostMapping(value ="/Projet/ajouter", consumes = {"application/json"})
	@ResponseBody
	public Projet Ajouter_Projet(@RequestBody Projet projet)
	{
		
		return projet_service.Ajouter_Projets(projet);
	}
	@GetMapping("/Projet/Afficher")
	@ResponseBody
	public List<Projet> Afficher()
	{
		return  projet_service.Afficher_Projet();
		
	}
	
	@GetMapping("/Projet/{Id}")
	@ResponseBody
	public Optional<Projet> AfficherParId(@PathVariable Long Id)
	{
		if(!projet_service.exists(Id))
			throw new EntityNotFoundException("le code de projet n'exist pas");
		Optional<Projet> p=projet_service.Get_BY_Id(Id);
		return p;
	}
	
	@DeleteMapping("/Projet/Delete/{Id}")

	void Delete_Projet(@PathVariable Long Id) {
		
		if(! projet_service.exists(Id))
			throw new EntityNotFoundException("le code de projet n'exist pas");
		projet_service.DeleteProjetById(Id);
	}
	
	@ResponseBody
	@Modifying
	@PutMapping(value = "/Projet/Modifier/{id}", consumes = {"application/json"})
	public ResponseEntity<?> Modifie_Projet (@RequestBody Projet p ,@PathVariable Long id)
	{
		
		if (projet_service.exists(id))   
		{
		
		
			Projet projet = projet_service.Get_BY_Id(id).get();
			projet.setId(p.getId());
			projet.setDesignation(p.getDesignation());
			projet.setNom(p.getNom());
			projet.setMembre(p.getMembre());
			projet_service.Ajouter_Projets(projet);
			return ResponseEntity.ok().body(projet);
			
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new EntityNotFoundException("le code "+id+"n'exist pas"));
	
		}
	
	@PutMapping(value = "/Projet/ajouter_membre/{Id}/{id}", consumes = {"application/json"})
	
	public ResponseEntity<?>  Ajouter_Membre_Projet(@PathVariable Long Id, @PathVariable Long id) {
		
		if (projet_service.exists(Id))
		{
			{
				
				Projet  p =projet_service.Get_BY_Id(Id).get();
				Membre membre=membre_service.Get_By_Id(id).get();
				
				membre.setProjets(p);
				membre_service.Ajouter_Membre(membre);
				return ResponseEntity.ok().body(membre);
			}
		}
		else 
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new EntityNotFoundException("le code "+Id+"n'exist pas"));


		

	}
	
	@PutMapping(value = "/Projet/ajouter_tache/{Id}/{id}", consumes = {"application/json"})
public ResponseEntity<?>  Ajouter_Tache_Projet(@PathVariable Long Id, @PathVariable Long id) {
	
	if (tache_service.exists(Id))
	{
		
			
			Tache  t =tache_service.Get_BY_Id(Id).get();
			//if( !(t.getMembres().getProjets().getId().equals(Id)))
			{
			Projet p =projet_service.Get_BY_Id(id).get();
			t.setProjets(p);
			tache_service.Ajouter_Tache(t);
			
			return ResponseEntity.ok().body(t);
			}
			
	}
	else 
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new EntityNotFoundException("le code "+Id+"n'exist pas"));


	

}}

























