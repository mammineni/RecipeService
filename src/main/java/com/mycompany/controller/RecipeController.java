package com.mycompany.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.model.Recipe;
import com.mycompany.service.RecipeService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RecipeController {

	private final Logger log = LoggerFactory.getLogger(RecipeController.class);

	@Autowired
	RecipeService recipeService;

	@GetMapping("/recipes")
	@ResponseBody
	ResponseEntity<List<Recipe>> getAllRecipes() {
		log.info("Fetching all the recipes");
		return new ResponseEntity<List<Recipe>>(recipeService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/recipe/{id}")
	@ResponseBody
	ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
		log.info("Fetching the recipes for the id : " + id);
		return new ResponseEntity<Recipe>(recipeService.findById(id), HttpStatus.OK);
	}

	@PostMapping("/addRecipe")
	@ResponseBody
	ResponseEntity<String> addRecipe(@Valid @RequestBody Recipe recipe){
		log.info("Adding the recipe");
		recipeService.add(recipe);
		return new ResponseEntity<String>("Recipe Added", HttpStatus.OK);
	}

	@PutMapping("/recipe/{id}")
	@ResponseBody
	ResponseEntity<String> updateRecipe(@PathVariable Long id, @Valid @RequestBody Recipe recipe) {
		log.info("Updating the recipe with id :"  + id );
		recipeService.update(recipe);
		return new ResponseEntity<String>("Recipe updated", HttpStatus.OK);
	}

	@DeleteMapping("/recipe/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteRecipe(@PathVariable Long id) {
		log.info("Deleting the recipe with id : " +id);
		recipeService.deleteById(id);
		return new ResponseEntity<String>("Recipe Deleted", HttpStatus.OK);
	}

}
