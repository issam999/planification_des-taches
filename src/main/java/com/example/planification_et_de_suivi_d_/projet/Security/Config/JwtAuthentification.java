package com.example.planification_et_de_suivi_d_.projet.Security.Config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthentification extends OncePerRequestFilter  {

	private  Jwt_Service jwt_Service;
	private  UserDetailsService userDetailsService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			
			throws ServletException, IOException {
		final String authHeader=request.getHeader("Authorization");
		final String jwt;
		final String userEmail;
		if (authHeader == null || !authHeader.startsWith("Bearer"))
		{
			filterChain.doFilter(request, response);
			return;
		}
		jwt=authHeader.substring(7);
		 userEmail = jwt_Service.extractUsername(jwt);
		 if (userEmail!= null && SecurityContextHolder.getContext().getAuthentication()== null)
		 {
			 UserDetails userDetails = this.userDetailsService
					 .loadUserByUsername(userEmail);
			 
			 if (jwt_Service.isTokenValid(jwt, userDetails))
			 {
				 UsernamePasswordAuthenticationToken authToken =new UsernamePasswordAuthenticationToken(
						 userDetails,
						 null,
						 userDetails.getAuthorities()
			 );
				 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)
						 );
				 SecurityContextHolder.getContext().setAuthentication(authToken);
				 filterChain.doFilter(request, response);
		
			 }
		 }
		 
		
		
	}
	
	
	
	
	

}
