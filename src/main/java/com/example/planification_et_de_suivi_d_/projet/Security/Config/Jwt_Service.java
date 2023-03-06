package com.example.planification_et_de_suivi_d_.projet.Security.Config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Builder;

@Service
public class Jwt_Service {
	
	private static final String final_key="46294A404E635266556A586E3272357538782F4125442A472D4B615064536756";


	public String extractUsername(String token) {
		// TODO Auto-generated method stub
		return extractClaim(token, Claims::getSubject);
	}
	
	private Claims extractAllClaims(String token )
	{
		return Jwts.parserBuilder()
			.setSigningKey(getSignInKey())
			.build().parseClaimsJws(token).getBody();
		 
	}
	public <T> T extractClaim(String token , Function<Claims , T> claimsResolver)
	{
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
		
	}
	public String generateToken(UserDetails userDetails)
	{
		return generateToken(new HashMap<>(),userDetails);
	}
	public String generateToken(
		Map<String, Object> extractClaims, 
		UserDetails userDetails)
	{
		return Jwts.builder().setClaims(extractClaims).setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date (System.currentTimeMillis()+1000*60*24)).signWith(getSignInKey(),SignatureAlgorithm.HS256)
			.compact();
	}
	public Boolean isTokenValid(String token , UserDetails userDetails)
	{
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()))&& !isTokenExpired(token);		
	}
	
	
	
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		// TODO Auto-generated method stub
		return extractClaim(token , Claims::getExpiration);
	}

	private Key getSignInKey() {
		// TODO Auto-generated method stub
		byte[] keyByte = Decoders.BASE64.decode(final_key);
		return Keys.hmacShaKeyFor(keyByte);
	}
	
	
}
