package com.example.planification_et_de_suivi_d_.projet.Security.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class AuthenticationController {
	@Autowired
	private  AuthenticateService authenticateService ;
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse>register(@RequestBody registerRequest request)
	{
		
		return ResponseEntity.ok(authenticateService.register(request));
	}
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody AuthenticationRequest request)
	{
		System.out.println("reposne: " + authenticateService.authenticate(request).getToken() );
		return authenticateService.authenticate(request).getToken();
	}


}
