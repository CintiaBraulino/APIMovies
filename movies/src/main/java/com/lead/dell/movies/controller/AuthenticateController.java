package com.lead.dell.movies.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lead.dell.movies.Dto.TokenDto;
import com.lead.dell.movies.entities.LoginForm;
import com.lead.dell.movies.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthenticateController {
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@PostMapping
	public ResponseEntity<?> autentic(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken dataLogin = form.converter();
		//System.out.println(dataLogin);
		try {
			Authentication authentication = authManager.authenticate(dataLogin);
			String token = tokenService.gerarToken(authentication);
			System.out.println(token);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		
		}
	}
}
