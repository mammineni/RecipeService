package com.mycompany.model;

import java.time.LocalDate;

public class Recipe {

	public Long id;
	public String name;
	public String ingredients;
	public LocalDate addedDate;
	public String url;

	public Recipe() {

	}

	public Recipe(String name, String ingredients, LocalDate addedDate) {
		super();
		this.name = name;
		this.ingredients = ingredients;
		this.addedDate = addedDate;
	}

	public Recipe(String name, String ingredients, LocalDate addedDate, String url) {
		super();
		this.name = name;
		this.ingredients = ingredients;
		this.addedDate = addedDate;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public LocalDate getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDate addedDate) {
		this.addedDate = addedDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Recipe [name=" + name + ", ingredients=" + ingredients + ", addedDate=" + addedDate + ", url=" + url
				+ "]";
	}
}
