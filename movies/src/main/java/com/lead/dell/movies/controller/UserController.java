package com.lead.dell.movies.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lead.dell.movies.entities.User;
import com.lead.dell.movies.entities.UserResponse;
import com.lead.dell.movies.repository.UserRepository;
import com.lead.dell.movies.service.UserService;


@RestController
@RequestMapping(value="/api")

public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private UserService userService;	
	
	@GetMapping() 							//Lista todos os usuarios
	public List<User> getAllUsers(){
		return userService.findAll();
	}
	
	@PostMapping("/registerUser") 			// Salva e cria o usuario porem verifica se ja tem cadastro com o email e cpf!!
	public ResponseEntity<UserResponse> saveUser(@RequestBody User user){
		return userService.createUser(user);
	}
	
	
	@GetMapping("/listUser/{id}") 			// Lista os usuarios de acordo com o ID
	public java.util.Optional<User> listUsers(@PathVariable(value = "id")long id) {
	  return userService.listUsers(id);
	}

	@PutMapping("/updateUser")				// Atualiza a informacao do usuario
	public User updateUser(@RequestBody User user) {
		return userService.UserupdateUser(user);
	}
}