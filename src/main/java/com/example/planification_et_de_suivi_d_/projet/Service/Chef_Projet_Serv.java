package com.example.planification_et_de_suivi_d_.projet.Service;

import java.util.List;
import java.util.Optional;

import com.example.planification_et_de_suivi_d_.projet.Models.Chef_Projet;
import com.example.planification_et_de_suivi_d_.projet.Models.Membre;
import com.example.planification_et_de_suivi_d_.projet.Models.Tache;


public interface Chef_Projet_Serv {
	
	Chef_Projet Ajouter_Chef_Projet(Chef_Projet Chef_projet);
	void DeleteChef_Projet(Chef_Projet Chef_projet);
	void DeleteChef_ProjetById(Long Id);
	List<Chef_Projet > Get_All_Chef_Projet();
	Optional<Chef_Projet> Get_By_Id(Long Id);
	Boolean exist(Long id);
}

