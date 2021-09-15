package com.lead.dell.movies.validations;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import com.lead.dell.movies.repository.UserRepository;
import com.lead.dell.movies.DTO.UserDetailsData;


@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {
	
	private UserRepository userRepository;
	
	public void ImlementsUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Optional<com.lead.dell.movies.entities.User> user = userRepository.findByName(name);
		if(user.isEmpty()) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		
		return new UserDetailsData(user);
		
	}
	

}