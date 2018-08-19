package com.mycompany.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mycompany.model.Recipe;

@Repository
public class RecipeJdbcRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Recipe findById(long id) {
		return jdbcTemplate.queryForObject("select * from recipe where id=? ", new Object[] { id },
				new BeanPropertyRowMapper<Recipe>(Recipe.class));
	}

	public List<Recipe> findAll() {
		return jdbcTemplate.query("select * from recipe ", new RecipeRowMapper());
	}

	public int deleteById(long id) {
		return jdbcTemplate.update("delete from recipe where id=? ", new Object[] { id });
	}

	public int insert(Recipe recipe) {
		return jdbcTemplate.update(
				"insert into recipe (id, name, ingredients, addedDate, url ) " + "values(?,  ?, ?, ? ,?)",
				new Object[] { recipe.getId(), recipe.getName(), recipe.getIngredients(), Date.valueOf(recipe.getAddedDate()),
						recipe.getUrl() });
	}

	public int update(Recipe recipe) {
		return jdbcTemplate.update(
				"update recipe  set name = ?, ingredients = ? ,addedDate =?, url = ? where id = ?",
				new Object[] { recipe.getName(), recipe.getIngredients(), recipe.getAddedDate(), recipe.getUrl(), recipe.getId() });
	}

	class RecipeRowMapper implements RowMapper<Recipe> {
		@Override
		public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
			Recipe recipe = new Recipe();
			recipe.setId(rs.getLong("id"));
			recipe.setName(rs.getString("name"));
			recipe.setIngredients(rs.getString("ingredients"));
			recipe.setAddedDate(rs.getDate("addedDate").toLocalDate());
			recipe.setUrl(rs.getString("url"));
			return recipe;
		}
	}

}
