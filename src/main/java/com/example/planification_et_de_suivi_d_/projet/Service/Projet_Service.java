package com.example.planification_et_de_suivi_d_.projet.Service;

import java.util.List;
import java.util.Optional;

import com.example.planification_et_de_suivi_d_.projet.Models.Membre;
import com.example.planification_et_de_suivi_d_.projet.Models.Projet;


public interface Projet_Service {
	
	Projet Ajouter_Projets(Projet projet);
	Boolean exists(Long id);
	Optional<Projet> Get_BY_Id(Long Id);
	void DeleteProjet(Projet Projet);
	void DeleteProjetById(Long Id);
	List<Projet> Afficher_Projet();
	

}
