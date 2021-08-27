package com.lead.dell.movies.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lead.dell.movies.entities.User;
import com.lead.dell.movies.entities.UserResponse;
import java.util.Optional;
import com.lead.dell.movies.repository.UserRepository;



@RestController
@RequestMapping(value="/api")

public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping() // Lista todos os Usuarios
	public List<User> listUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/listUser/{id}") // Lista os usuarios por ID
	public Optional<User> listUsers(@PathVariable(value = "id")long id) {
	  return userRepository.findById(id);
	}

	@PostMapping("save") // Salva o usuario
	public void saveUser(@RequestBody User user) {
		userRepository.save(user);
	}
		
	@PostMapping("/cadasteUser") // Salva o usuario porem verifica se ja tem cadastro com o email e cpf
	public ResponseEntity<UserResponse> createUser(@Valid @RequestBody User user) {
	    Optional<User> cpf = userRepository.findUsertByCpf(user.getCpf());
	    Optional<User> email = userRepository.findUserByEmail(user.getEmail());
	    UserResponse data = new UserResponse();
	    if(cpf.isPresent() || email.isPresent()){
	        if (cpf.isPresent() && email.isPresent()) {
	        	data.setMessage("E-mail is required and must be unique. " +
	               "CPF is required and must be unique");
	        } else if(email.isEmpty()) {
	           data.setMessage("CPF is required and must be unique");
	        } else {
	           data.setMessage("E-mail is required and must be unique.");
	        }
	      return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
	     }
	    else{
	        var newUser = userRepository.save(user);
	        data.setUser(newUser);
	        data.setMessage("Sucess");
	        return new ResponseEntity<>(data, HttpStatus.CREATED);
	    }   

	}	
}