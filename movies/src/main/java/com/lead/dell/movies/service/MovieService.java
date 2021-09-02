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
import com.lead.dell.movies.entities.Movie;
import com.lead.dell.movies.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> findAll(){			//Lista todas os movies
		return movieRepository.findByActive(true);
	}
	
	public ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie movie){			// Salva e cria um movie porem verifica se ja tem um nome cadastrado!!
		Optional<Movie> title = movieRepository.findByTitle(movie.getTitle());
		if (title.isPresent()){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else{
			movieRepository.save(movie);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
	}
	
	public Optional<Movie> listMovie(@PathVariable(value="id")long id){			// Lista o movie de acordo com o ID
		return movieRepository.findById(id);
	}
	
	public Movie movieUpdate(@RequestBody Movie movie){			// Atualiza uma informacao do movie
		return movieRepository.save(movie);
	}
	
	public Movie deleteMovie(Movie movie){				//seta movie para false
		movie.setActive(false);
		return movieRepository.save(movie);
	}
}
