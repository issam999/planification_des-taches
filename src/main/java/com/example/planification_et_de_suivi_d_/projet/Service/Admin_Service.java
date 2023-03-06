package com.example.planification_et_de_suivi_d_.projet.Service;

import java.util.List;
import java.util.Optional;

import com.example.planification_et_de_suivi_d_.projet.Models.Admin;


public interface Admin_Service {
	
	Admin Ajouter_Admin(Admin Admin);
	List<Admin> Get_All_Admin();
	Optional<Admin> Get_Admin_By_Id(Long Id);
	Boolean exist(Long id);


}
