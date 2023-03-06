package com.example.planification_et_de_suivi_d_.projet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.example.planification_et_de_suivi_d_.projet.Models.Membre;
import com.example.planification_et_de_suivi_d_.projet.Models.Tache;
import com.example.planification_et_de_suivi_d_.projet.Repository.Membre_Repository;

@Service

public class Membre_Service_Impl implements Membre_Service {

	
	@Autowired
	 Membre_Repository Membre_Rep;
	@Override
	public Membre Ajouter_Membre(Membre membre) {
		
		return Membre_Rep.saveAndFlush(membre);
	}

	@Override
	public void DeleteMembre(Membre membre) {
		
		Membre_Rep.delete(membre);
	}

	@Override
	public void DeleteMembre(Long Id) {
		Membre_Rep.deleteById(Id);
		
	}

	@Override
	public List<Membre> Get_All_Membre() {
		
		return Membre_Rep.findAll();
	}

	@Override
	public Optional<Membre> Get_By_Id(Long Id) {
		return Membre_Rep.findById(Id);
	}

	@Override
	public Boolean exist(Long id) {
		return Membre_Rep.existsById(id);
	}

	@Override
	public Boolean exists(Long id) {
		return Membre_Rep.existsById(id);
	}

	

	
	
		 
		
	}



	
