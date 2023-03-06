package com.example.planification_et_de_suivi_d_.projet.Models;

	
	
	import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	import lombok.Data;

	@Entity
	@Table(name="Admin")
	@Data
	 
	
	public class Admin implements Serializable{
		
		@Id
		@GeneratedValue
		private  Long Id;
		private String Nom;
		private String Prenom;
		private String Email;
		private String Pwd;
	
	
		@OneToMany(mappedBy="admins",fetch=FetchType.LAZY)
		private List<Projet> Projet;
	
		
		
	
		
		public Admin(Long id, String nom, String prenom, String email, String pwd) {
			super();
			Id = id;
			Nom = nom;
			Prenom = prenom;
			Email = email;
			Pwd = pwd;
		}
		public Admin() {
			super();
		}
		public Long getId() {
			return Id;
		}
		public void setId(Long id) {
			Id= id;
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
		public String getPwd() {
			return Pwd;
		}
		public void setPwd(String pwd) {
			Pwd = pwd;
		}
	
		
}
