package com.example.planification_et_de_suivi_d_.projet.Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="Tache")
@Data
public class Tache implements Serializable {
	@Id
	@GeneratedValue
	Long id;
	String Nom;
	String duree;
	@Enumerated(EnumType.STRING)
	Etat_Tache etat;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Membre membres;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Projet projets;
	
	
	public Tache() {
		super();
	}



	public Tache(Long id, String nom, String duree, Etat_Tache etat) {
		super();
		this.id = id;
		Nom = nom;
		this.duree = duree;
		this.etat = etat;
		
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



	public String getDuree() {
		return duree;
	}



	public void setDuree(String duree) {
		this.duree = duree;
	}



	public Etat_Tache getEtat() {
		return etat;
	}



	public void setEtat(Etat_Tache etat) {
		this.etat = etat;
	}



	public Membre getMembres() {
		return membres;
	}


	public void setMembres(Membre membres) {
		this.membres = membres;
	}



	public Projet getProjets() {
		return projets;
	}



	public void setProjets(Projet projets) {
		this.projets = projets;
	}







}
