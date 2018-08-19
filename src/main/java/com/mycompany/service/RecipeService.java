package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.model.Recipe;
import com.mycompany.repository.RecipeJdbcRepository;

@Service
public class RecipeService {
	
	@Autowired
	RecipeJdbcRepository repository;

	public Recipe findById(long id) {
		return repository.findById(id);
	}

	public List<Recipe> findAll() {
		return repository.findAll();
	}

	public int deleteById(long id) {
		return repository.deleteById(id);
	}

	public int add(Recipe recipe) {
		return repository.insert(recipe);
	}

	public int update(Recipe recipe) {
		return repository.update(recipe);
	}

}
