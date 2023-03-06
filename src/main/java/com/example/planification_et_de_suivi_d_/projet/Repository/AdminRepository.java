package com.example.planification_et_de_suivi_d_.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.planification_et_de_suivi_d_.projet.Models.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

}
