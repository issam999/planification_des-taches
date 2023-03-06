package com.example.planification_et_de_suivi_d_.projet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.planification_et_de_suivi_d_.projet.Models.Chef_Projet;
import com.example.planification_et_de_suivi_d_.projet.Models.Membre;
import com.example.planification_et_de_suivi_d_.projet.Models.Tache;







@Repository

public interface Chef_Projet_Repository extends JpaRepository<Chef_Projet,Long> {
	
	
	
	

}
