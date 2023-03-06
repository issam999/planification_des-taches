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

import com.example.planification_et_de_suivi_d_.projet.Models.Chef_Projet;
import com.example.planification_et_de_suivi_d_.projet.Models.EntityNotFoundException;
import com.example.planification_et_de_suivi_d_.projet.Service.Chef_Projet_Serv;

@RestController


public class Chef_Projet_Controllers{
	
	
		
	
	@Autowired	
	 Chef_Projet_Serv Chef_Projets;
	
		
	@GetMapping("/Chef/Afficher")
	@ResponseBody
	
	public List<Chef_Projet> FindAllChef()
	{
		
		List<Chef_Projet> list;

	

		list=Chef_Projets.Get_All_Chef_Projet();
		return list;
	}
	@GetMapping("/Chef/Afficher/{Id}")
	@ResponseBody


	
	public Optional<Chef_Projet> FindById(@PathVariable Long Id)
	{
		if(! Chef_Projets.exist(Id))
			throw new EntityNotFoundException("le code n'exist pas");
		Optional<Chef_Projet> e=Chef_Projets.Get_By_Id(Id);
		return e;
	}
	@PostMapping("/Chef_Projets/Ajouter")
	Chef_Projet Ajouter_Chef_Projets ( @RequestBody Chef_Projet Chef_Projet) {
			return Chef_Projets.Ajouter_Chef_Projet(Chef_Projet);
	
		
		
		
	}
	@DeleteMapping("/Chef_Projets/Delete/{Id}")
	@ResponseBody
	
	void Delete_Chef_Projet(@PathVariable Long Id) {
		if(! Chef_Projets.exist(Id))
			throw new EntityNotFoundException("le code n'exist pas");
		Chef_Projets.DeleteChef_ProjetById(Id);
		
	}
	@DeleteMapping("/Chef_Projets/Delete")

	void Delete_Membre(Chef_Projet Chef_Projet) {
			
		Chef_Projets.DeleteChef_Projet(Chef_Projet);
		}	
	
	@PutMapping("/Chef_Projets/Put/{Id}")
	@ResponseBody
	
public ResponseEntity<?> Update_Chef_Projet(@RequestBody Chef_Projet Chef_projet,@PathVariable Long Id) {
		
		if (Chef_Projets.exist(Id)){
		Chef_Projet po=Chef_Projets.Get_By_Id(Id).get();
		po.setId(Chef_projet.getId());
		po.setEmail(Chef_projet.getEmail());
		po.setNom(Chef_projet.getNom());
		po.setPoste(Chef_projet.getPoste());
		po.setPrenom(Chef_projet.getPrenom());

		
		
		
		return ResponseEntity.ok().body(po);
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new EntityNotFoundException("le code n'exist pas"));
	}
	
	//public ResponseEntity<?> Update_
	
	}
	
	
	


