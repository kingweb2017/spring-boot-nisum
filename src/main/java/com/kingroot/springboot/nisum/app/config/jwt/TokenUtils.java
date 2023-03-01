package com.kingroot.springboot.nisum.app.config.jwt;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenUtils {
	
	private final static String ACCES_TOKEN_SECRECET = "cb95bb0b-722b-4e23-8197-87dbd84e81dc";
	private final static Long ACCES_TOKEN_VALIDITY_SECONDS = 2_592000L;
	
	public static String createToken(String name, String email) {
		long expirationTime = ACCES_TOKEN_VALIDITY_SECONDS * 1_000;
		Date expirationDate = new Date(System.currentTimeMillis() * expirationTime);
		
		Map<String, Object> extra = new HashMap<>();
		
		extra.put("name", name);
		
		return Jwts.builder()
				.setSubject(email)
				.setExpiration(expirationDate)
				.addClaims(extra)
				.signWith(SignatureAlgorithm.HS256, ACCES_TOKEN_SECRECET.getBytes())
				.compact();
	}
	
	public static UsernamePasswordAuthenticationToken getAuhentication(String token) {
		try {
			Claims claims = Jwts.parser()
					.setSigningKey(ACCES_TOKEN_SECRECET.getBytes())
					.parseClaimsJws(token)
					.getBody();
			
			String email  = claims.getSubject();
			
			return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
		} catch (JwtException e) {
			// TODO: handle exception
			return null;
		}
	}

}
