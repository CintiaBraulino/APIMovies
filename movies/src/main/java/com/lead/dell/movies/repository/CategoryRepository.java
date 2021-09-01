package com.lead.dell.movies.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lead.dell.movies.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long>{
	
	Optional <Category> findByName(String name);
	Optional <Category> findById(long id);
	List<Category> findByActive(boolean active);
}
