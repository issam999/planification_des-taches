package com.example.planification_et_de_suivi_d_.projet.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Chef_Projet")
@Data

public class Chef_Projet implements Serializable {

	@Id
	@GeneratedValue
	private  Long Id;
	private String Nom;
	private String Prenom;
	private String Email;
	private String poste;
	
	@OneToMany(mappedBy="chef_projet")
	List<Projet> projet;
	

	

	public Chef_Projet() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Chef_Projet(Long id, String nom, String prenom, String email, String poste) {
		super();
		Id = id;
		Nom = nom;
		Prenom = prenom;
		Email = email;
		this.poste = poste;
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


	public List<Projet> getProjet() {
		return projet;
	}


	public void setProjet(List<Projet> projet) {
		this.projet = projet;
	}


	

	










	

}
