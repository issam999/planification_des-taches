package com.example.planification_et_de_suivi_d_.projet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.planification_et_de_suivi_d_.projet.Models.Tache;
import com.example.planification_et_de_suivi_d_.projet.Repository.Tache_Repository;
@Service
public class Tache_Service_Impl implements Tache_Service {

	@Autowired
	Tache_Repository  Tache_repository;
	
	@Override
	public Tache Ajouter_Tache(Tache tache) {
		return Tache_repository.saveAndFlush(tache);
	}

	@Override
	public Boolean exists(long id) {
		return Tache_repository.existsById(id);
	}

	@Override
	public Optional<Tache> Get_BY_Id(long Id) {
		// TODO Auto-generated method stub
		return Tache_repository.findById(Id);
	}

	@Override
	public void DeleteTache(Tache tache) {
		Tache_repository.delete(tache);
		
	}
	@Override
	public void DeleteTacheById(Long Id) {
		Tache_repository.deleteById(Id);
		
	}


	@Override
	public List<Tache> Afficher_Tache() {
		// TODO Auto-generated method stub
		return Tache_repository.findAll();
	}

	
	
}

