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
import com.lead.dell.movies.entities.Category;
import com.lead.dell.movies.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){		//Lista todas categorias
		return categoryRepository.findByActive(true);	
	}
	
	public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category){			// Salva e cria uma categoria porem verifica se ja tem um nome cadastrado!!
		Optional<Category> name = categoryRepository.findByName(category.getName());
		if (name.isPresent()){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else{
			categoryRepository.save(category);
			return new ResponseEntity<>(HttpStatus.CREATED);	
		}
	}
	
	public Optional<Category> listCategory(@PathVariable(value="id")long id){			// Lista as categorias de acordo com o ID
		return categoryRepository.findById(id);
	}
	
	public Category categoryUpdate(@RequestBody Category category){			// Atualiza uma informacao da categoria
		return categoryRepository.save(category);
	}
	
	public Category deleteCategory(Category category){				//seta categoria para false 
		category.setActive(false);
		return categoryRepository.save(category);
	}
}
