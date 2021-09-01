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
import com.lead.dell.movies.entities.Category;
import com.lead.dell.movies.repository.CategoryRepository;
import com.lead.dell.movies.service.CategoryService;

@RestController
@RequestMapping(value="/category")

public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryService categoryService;	
	
	@GetMapping() 							//Lista todas as categorias
	public List<Category> getAllCategory(){
		return categoryService.findAll();
	}
	
	@PostMapping("/regiterCategory")		// Salva e cria uma categoria porem verifica se ja tem um nome cadastrado!!
	public ResponseEntity<Category> saveCategory(@RequestBody Category category){
		return categoryService.createCategory(category);
	}
	
	@GetMapping("/listCategory/{id}")		// Lista a categoria de acordo com o ID
	public Optional<Category> listCategory(@PathVariable(value = "id")long id){
		return categoryService.listCategory(id);
	}
	
	@PutMapping("/updateCategory")		// Atualiza uma informacao da categoria
	public Category updateCategory(@RequestBody Category category) {
		return categoryService.CategoryUpdate(category);
	}
	
	@PutMapping("/deleteCategory")		//seta categoria para false
	public Category deleteCategory(@RequestBody Category category) {
		return categoryService.deleteCategory(category);
	}

}
