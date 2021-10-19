package com.lead.dell.movies.configurations;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.lead.dell.movies.repository.UserRepository;
import com.lead.dell.movies.service.TokenService;
import com.lead.dell.movies.entities.User;

public class AuthenticationTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private UserRepository userRepository;
	
	public AuthenticationTokenFilter(TokenService tokenService, UserRepository userRepository) {
		this.tokenService = tokenService;
		this.userRepository = userRepository;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		boolean valido = tokenService.isTokenValido(token);
		if(valido) {
			autenticarUser(token);
		}
		
		filterChain.doFilter(request, response);
		
	}

	private void autenticarUser(String token) {
		Long idUser = tokenService.getIdUser(token);
		User user = userRepository.findById(idUser).get();	
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}
	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() ||!token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7, token.length());
	}
	

}
