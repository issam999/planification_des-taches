package com.example.planification_et_de_suivi_d_.projet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.planification_et_de_suivi_d_.projet.Models.Projet;
import com.example.planification_et_de_suivi_d_.projet.Repository.Projet_Repository;

@Service

public class Projet_Service_Impl implements Projet_Service{
	
	
	
	

		@Autowired
		Projet_Repository Projet_Rep;
		
		
		@Override
		public Projet Ajouter_Projets( Projet projet) {
			
			return Projet_Rep.save(projet);
		}

		@Override
		public Boolean exists(Long id) {
			// TODO Auto-generated method stub
			return Projet_Rep.existsById(id);
		}

		@Override
		public Optional<Projet> Get_BY_Id(Long Id) {
			// TODO Auto-generated method stub
			return Projet_Rep.findById(Id);
		}

		@Override
		public void DeleteProjet(Projet projet) {
			Projet_Rep.delete(projet);

		}

		@Override
		public List<Projet> Afficher_Projet() {
			// TODO Auto-generated method stub
			return Projet_Rep.findAll();
		}
		@Override
		public void DeleteProjetById(Long Id) {
			Projet_Rep.deleteById(Id);
			
		}

	}



