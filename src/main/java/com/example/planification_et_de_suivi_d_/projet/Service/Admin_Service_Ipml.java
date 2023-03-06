package com.example.planification_et_de_suivi_d_.projet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.planification_et_de_suivi_d_.projet.Models.Admin;
import com.example.planification_et_de_suivi_d_.projet.Repository.AdminRepository;

@Service
public class Admin_Service_Ipml implements Admin_Service{

	
	@Autowired
	AdminRepository Admin_Rep;
	
	@Override
	public Admin Ajouter_Admin(Admin Admin) {
		
		return Admin_Rep.save(Admin);
	}

	@Override
	public List<Admin> Get_All_Admin() {
		return Admin_Rep.findAll();
		
	}

	@Override
	public Optional<Admin> Get_Admin_By_Id(Long Id) {
		
		return Admin_Rep.findById(Id);
	}

	@Override
	public Boolean exist(Long id) {
		return Admin_Rep.existsById(id);
	}
	
	

}
