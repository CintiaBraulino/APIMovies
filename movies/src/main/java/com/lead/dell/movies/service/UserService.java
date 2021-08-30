package com.lead.dell.movies.service;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.lead.dell.movies.entities.User;
import com.lead.dell.movies.entities.UserResponse;
import com.lead.dell.movies.repository.UserRepository;

@Service
public class UserService {
		
	@Autowired
	private UserRepository userRepository;
	

	public List<User> findAll(){	//Lista todos os usuarios
			return userRepository.findByActivite(true);	
	}
	
	public ResponseEntity<UserResponse> createUser(@Valid @RequestBody User user){	// Salva e cria o usuario porem verifica se ja tem cadastro com o email e cpf!!
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
	
	public Optional<User> listUsers(@PathVariable(value = "id")long id){	// Lista os usuarios de acordo com o ID
		  return userRepository.findById(id);
		}
	
	public User UserupdateUser(@RequestBody User user){		// Atualiza a informacao do usuario
		return userRepository.save(user);
	}
	

}
