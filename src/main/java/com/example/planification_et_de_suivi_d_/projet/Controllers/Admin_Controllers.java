package com.example.planification_et_de_suivi_d_.projet.Controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.planification_et_de_suivi_d_.projet.Models.Admin;
import com.example.planification_et_de_suivi_d_.projet.Models.EntityNotFoundException;
import com.example.planification_et_de_suivi_d_.projet.Service.Admin_Service;

@RestController
public class Admin_Controllers{
	
	@Autowired
	Admin_Service Admins;
	
@PostMapping("/Admin/ajouter")
	public Admin Ajouter_admin (Admin Admin)
	{
	
	return Admins.Ajouter_Admin(Admin);
}

@GetMapping("/Admin/Afficher/{Id}")
	public Optional<Admin> Get_admin_By_Id(@PathVariable Long Id)
	{
		if(! Admins.exist(Id)) {
		throw new EntityNotFoundException("le code n'exist pas");
		}
	
	
		return Admins.Get_Admin_By_Id(Id);
	}
@GetMapping("/Admin/Afficher")
public List<Admin> Get_all_admin()

{
	List<Admin>list=Admins.Get_All_Admin();
	return list;
	
	
}
}

