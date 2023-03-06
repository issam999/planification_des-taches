package com.example.planification_et_de_suivi_d_.projet.Service;

import java.util.List;
import java.util.Optional;


import com.example.planification_et_de_suivi_d_.projet.Models.Tache;

public interface Tache_Service {
	
	Tache Ajouter_Tache(Tache tache);
	Boolean exists(long id);
	Optional<Tache> Get_BY_Id(long Id);
	void DeleteTache(Tache tache);
	void DeleteTacheById(Long Id);
	List<Tache> Afficher_Tache();
	//List<Tache> update (String id , List<Tache> tache);
	

}
