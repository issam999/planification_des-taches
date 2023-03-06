package com.example.planification_et_de_suivi_d_.projet.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="Projet")
@Data

public class Projet implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	private String Nom;
	private String designation;

	@ManyToOne
	Chef_Projet chef_projet;

	@ManyToOne
	Admin admins;
	
	@OneToMany(mappedBy="projets",fetch=FetchType.LAZY)
	private List<Membre> membre = new ArrayList<>();
	@OneToMany(mappedBy="projets",fetch=FetchType.LAZY)
	private List<Tache> taches = new ArrayList<>();
	
	public Projet() {
		super();
	}



	public Projet(Long id, String nom, String designation) {
		super();
		this.id = id;
		Nom = nom;
		this.designation = designation;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public Chef_Projet getChef_projet() {
		return this.chef_projet;
	}


	public List<Membre> getMembre() {
		return membre;
	}

	public void setMembre(List<Membre> membre) {
		this.membre = membre;
	}



	public List<Tache> getTaches() {
		return taches;
	}



	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}



}
