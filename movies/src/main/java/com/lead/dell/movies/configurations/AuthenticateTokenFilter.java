package com.lead.dell.movies.configurations;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import com.lead.dell.movies.repository.UserRepository;
import com.lead.dell.movies.service.TokenService;

public class AuthenticateTokenFilter extends OncePerRequestFilter {
	
	private TokenService tokenService;
	private UserRepository repository;

	public AuthenticateTokenFilter(TokenService tokenService, UserRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperateToken(request);
		boolean valido = tokenService.isTokenValido(token);
		if (valido) {
			authenticateUser(token);
		}
		
		filterChain.doFilter(request, response);
	}

	private void authenticateUser(String token) {
		Long idUser = tokenService.getIdUser(token);
		User user = (User) repository.findById(idUser).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, ((AbstractAuthenticationToken) user).getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String recuperateToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}
}
