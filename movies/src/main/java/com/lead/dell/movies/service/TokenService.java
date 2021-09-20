package com.lead.dell.movies.service;

import org.springframework.stereotype.Service;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import com.lead.dell.movies.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${spring.jwt.expiration}")
	private String expiration;
	
	@Value("${spring.jwt.secret}")
	private String secret;
	

	public String gerarToken(Authentication authentication) {
		User login  = (User) authentication.getPrincipal();
		Date today = new Date();
		Date dateExpiration = new Date(today.getTime()+ Long.parseLong(expiration));
		return Jwts.builder()
				.setIssuer("APIMovie")
				.setSubject(login.getId().toString())
				.setIssuedAt(today)
				.setExpiration(dateExpiration)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getIdUser(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

}