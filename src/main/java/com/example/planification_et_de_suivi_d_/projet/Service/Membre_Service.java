package com.example.planification_et_de_suivi_d_.projet.Service;

import java.util.List;
import java.util.Optional;

import com.example.planification_et_de_suivi_d_.projet.Models.Membre;
import com.example.planification_et_de_suivi_d_.projet.Models.Tache;

public interface Membre_Service {
	
	
	Membre Ajouter_Membre(Membre membre);
	void DeleteMembre(Membre membre);
	void DeleteMembre(Long Id);
	List<Membre> Get_All_Membre();
	Optional<Membre> Get_By_Id(Long Id);
	Boolean exist(Long id);
	Boolean exists(Long id);
	

}
