package com.example.planification_et_de_suivi_d_.projet.Security.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/democont")
public class demoController {

	@GetMapping("/hello")
	public ResponseEntity<String> sayHello()
	{
		return ResponseEntity.ok("Hello from Secured endpoint");
	}
}
