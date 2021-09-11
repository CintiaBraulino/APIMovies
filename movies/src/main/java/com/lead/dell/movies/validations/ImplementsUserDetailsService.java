package com.lead.dell.movies.validations;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import com.lead.dell.movies.repository.UserRepository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {
	
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		com.lead.dell.movies.entities.User user = userRepository.findByName(name);
		
		if(user == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		return new User(user.getPassword(), user.getUsername(), true, true, true, true, user.getAuthorities());
		
	}
	

}
