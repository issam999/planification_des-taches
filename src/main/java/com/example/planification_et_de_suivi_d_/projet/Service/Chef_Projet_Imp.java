package com.example.planification_et_de_suivi_d_.projet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.planification_et_de_suivi_d_.projet.Models.Chef_Projet;
import com.example.planification_et_de_suivi_d_.projet.Models.Membre;
import com.example.planification_et_de_suivi_d_.projet.Models.Tache;
import com.example.planification_et_de_suivi_d_.projet.Repository.Chef_Projet_Repository;
import com.example.planification_et_de_suivi_d_.projet.Repository.Membre_Repository;



@Service
public class Chef_Projet_Imp implements Chef_Projet_Serv{
	
	@Autowired
	Chef_Projet_Repository Chef_Projet_Rep;

	@Override
	public Chef_Projet Ajouter_Chef_Projet(Chef_Projet Chef_projet) {
		
		return  Chef_Projet_Rep.saveAndFlush(Chef_projet);
	}

	@Override
	public void DeleteChef_Projet(Chef_Projet Chef_projet) {
		
		Chef_Projet_Rep.delete(Chef_projet);
	}

	@Override
	public void DeleteChef_ProjetById(Long Id) {
		Chef_Projet_Rep.deleteById(Id);
		
	}

	@Override
	public List<Chef_Projet> Get_All_Chef_Projet() {
		return Chef_Projet_Rep.findAll();
		 
	}

	@Override
	public Optional<Chef_Projet> Get_By_Id(Long Id) {
		// TODO Auto-generated method stub
		
		return Chef_Projet_Rep.findById(Id);
	}

	@Override
	public Boolean exist(Long id) {
		return Chef_Projet_Rep.existsById(id);
	}

	
	
	
}