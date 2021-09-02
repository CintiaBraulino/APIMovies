package com.lead.dell.movies.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lead.dell.movies.entities.Movie;
import com.lead.dell.movies.repository.MovieRepository;
import com.lead.dell.movies.service.MovieService;

@RestController
@RequestMapping(value="/movie")
public class MovieController {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping()						//Lista todas os movies
	public List<Movie> getAllMovie(){
		return movieService.findAll();
	}
	
	@PostMapping("/registerMovie")		// Salva e cria um movie porem verifica se ja tem um nome cadastrado!!
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
		return movieService.createMovie(movie);
	}
	
	@GetMapping("/listMovie/{id}")		// Lista o movie de acordo com o ID
	public Optional<Movie> listMovie(@PathVariable(value ="id")long id){
		return movieService.listMovie(id);
	}
	
	@PutMapping("/updateMovie")			// Atualiza uma informacao do movie
	public Movie updateMovie(@RequestBody Movie movie){
		return movieService.movieUpdate(movie);
	}
	
	@PutMapping("/deleteMovie")			//seta movie para false
	public Movie deleteMovie(@RequestBody Movie movie){
		return movieService.deleteMovie(movie);
	}	
}
