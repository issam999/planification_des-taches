package com.example.planification_et_de_suivi_d_.projet.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;



@Entity
@Table(name="Membre")  
@Data
public class Membre  implements Serializable {

	@Id
	@GeneratedValue
	private  Long Id;
	private String Nom;
	private String Prenom;
	private String Email;
	private String poste;
	
	@OneToMany(mappedBy="membres",fetch=FetchType.LAZY)
	private List<Tache> taches;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="projet_id")
	private Projet projets;
	
	

	
	


	public Membre(Long id, String nom, String prenom, String email, String poste) {
		super();
		Id = id;
		Nom = nom;
		Prenom = prenom;
		Email = email;
		this.poste = poste;
	}



	public Membre() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		Id = id;
	}



	public String getNom() {
		return Nom;
	}



	public void setNom(String nom) {
		Nom = nom;
	}



	public String getPrenom() {
		return Prenom;
	}



	public void setPrenom(String prenom) {
		Prenom = prenom;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public String getPoste() {
		return poste;
	}



	public void setPoste(String poste) {
		this.poste = poste;
	}

	public List<Tache> getTaches() {
		return taches;
	}



	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}



	public Projet getProjets() {
		return projets;
	}



	public void setProjets(Projet projets) {
		this.projets = projets;
	}
	





	




	
	
	
}
