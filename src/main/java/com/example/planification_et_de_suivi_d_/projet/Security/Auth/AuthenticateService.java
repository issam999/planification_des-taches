package com.example.planification_et_de_suivi_d_.projet.Security.Auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.planification_et_de_suivi_d_.projet.Repository.UserRepository;
import com.example.planification_et_de_suivi_d_.projet.Security.Role;
import com.example.planification_et_de_suivi_d_.projet.Security.User;
import com.example.planification_et_de_suivi_d_.projet.Security.Config.Jwt_Service;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Service 
@RequiredArgsConstructor
public class AuthenticateService {
	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private Jwt_Service jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;

	public AuthenticationResponse register (registerRequest request) {
		
		User user1 = new User();
		user1.setFirstname(request.getFirstname());
		user1.setLastname(request.getLastname());
		user1.setEmail(request.getEmail());
		user1.setPassword(passwordEncoder.encode(request.getPassword()));
		user1.setRole(Role.User);
		repository.save(user1);
		  jwtService= new Jwt_Service();
		 
			
		  AuthenticationResponse response = new AuthenticationResponse();
			
		  response.setToken(jwtService.generateToken(user1));
			System.out.println(jwtService.generateToken(user1));
		 
		return response;
				
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		 User user = repository.findByEmail(request.getEmail());
			System.out.println("******************"+user.getEmail()+user.getPassword());

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		System.out.println("******************");
		System.out.println("******************");

		 System.out.println(request.getEmail());
		   AuthenticationResponse response = new AuthenticationResponse();
		  response.setToken(jwtService.generateToken(user));
		return response;
		
	}
	
	

}
