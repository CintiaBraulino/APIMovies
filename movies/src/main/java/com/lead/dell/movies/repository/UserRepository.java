package com.lead.dell.movies.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lead.dell.movies.entities.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
	
	Optional<User> findByEmail(String email);
	Optional<User> findUsertByCpf(String cpf);
	Optional<User> findUserByEmail(String email);
	Optional <User> findById(long id);
	List<User> findByActivite(boolean activite);
	Optional<User> findById(Integer id);
	User save(User user);
}
