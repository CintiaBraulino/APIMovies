package com.lead.dell.movies.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lead.dell.movies.entities.Movie;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	Optional <Movie> findByTitle(String title);
	Optional <Movie> findById(long id);
	List<Movie> findByActive(boolean active);
	
}
