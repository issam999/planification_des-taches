package com.example.planification_et_de_suivi_d_.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.planification_et_de_suivi_d_.projet.Models.Projet;

@Repository
public interface Projet_Repository extends JpaRepository<Projet, Long> {

}
