package com.example.planification_et_de_suivi_d_.projet.Models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
	
	public EntityNotFoundException (String message)
	{
		super(message);
	}

}
