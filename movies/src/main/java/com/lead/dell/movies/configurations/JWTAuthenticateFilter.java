package com.lead.dell.movies.configurations;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import com.auth0.jwt.algorithms.Algorithm;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lead.dell.movies.DTO.UserDetailsData;
import com.lead.dell.movies.entities.User;

public class JWTAuthenticateFilter extends UsernamePasswordAuthenticationFilter{
	
	public static final int TOKEN_EXPIRACAO = 600_000;
    public static final String TOKEN_SENHA = "463408a1-54c9-4307-bb1c-6cced559f5a7";
	private final AuthenticationManager authenticationManager;
	
	public JWTAuthenticateFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	public Authentication attempAuthentication(HttpServletRequest request, 
			HttpServletResponse response) throws AuthenticationException{
		try {
			User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
			
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					user.getName(),
					user.getPassword(),
					new ArrayList<>()
					));
		} catch (IOException e) {
			throw new RuntimeException("Falha ao autenticar usuario",e);
		}	
	}
	protected void successfulAuthentication(HttpServlet request,
											HttpServletResponse response,
											FilterChain chain,
											Authentication authResult) throws IOException, ServletException {

        UserDetailsData userData = (UserDetailsData) authResult.getPrincipal();

        String token = JWT.create().
                withSubject(userData.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
                .sign(Algorithm.HMAC512(TOKEN_SENHA));

        response.getWriter().write(token);
        response.getWriter().flush();
    }

}
