package com.example.planification_et_de_suivi_d_.projet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication // (exclude = {SecurityAutoConfiguration.class })

public class PlanificationEtDeSuiviDProjetApplication  {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PlanificationEtDeSuiviDProjetApplication.class, args);
	}

}



