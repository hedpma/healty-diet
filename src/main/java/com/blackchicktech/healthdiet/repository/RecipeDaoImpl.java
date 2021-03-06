package com.blackchicktech.healthdiet.repository;

import com.blackchicktech.healthdiet.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class RecipeDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Recipe> rowMapper = new BeanPropertyRowMapper(Recipe.class);

	public Recipe getRecipeById(String recipeId) {
		List<Recipe> foodList = jdbcTemplate.query("SELECT * FROM recipe_tbl WHERE recipe_id = ?",
				rowMapper, recipeId);
		return foodList.stream().findFirst().orElse(null);
	}

	public List<String> getAllMealTime() {
		return Arrays.asList("早餐","中餐","晚餐","加餐");
	}

	public List<String> getAllCategory() {
		List<String> list = jdbcTemplate.queryForList("SELECT DISTINCT category FROM recipe_tbl", String.class);
		return list;
	}

	public List<Recipe> getRecipeByName(String recipeName) {
		return jdbcTemplate.query("SELECT * FROM recipe_tbl WHERE recipe_name LIKE ?",
				rowMapper, "%" + recipeName + "%");
	}

	public List<Recipe> getRecipeByMealTime(String mealTime) {
		return jdbcTemplate.query("SELECT * FROM recipe_tbl WHERE meal_time LIKE ?",
				rowMapper, "%" + mealTime + "%");
	}

	public List<Recipe> getRecipeByCategory(String category) {
		return jdbcTemplate.query("SELECT * FROM recipe_tbl WHERE category = ?",
				rowMapper, category);
	}

	public List<Recipe> getRecommendRecipe(String foodName) {
	    List<Recipe> recipeList = jdbcTemplate.query("SELECT * FROM recipe_tbl where material LIKE ? ORDER BY RAND() LIMIT 3;",
                rowMapper, "%" + foodName + "%");
	    return recipeList;
    }

	public List<Recipe> getRecipeByCookMethod(String cookMethod) {
		return jdbcTemplate.query("SELECT * FROM recipe_tbl WHERE cook_method = ?",
				rowMapper, cookMethod);
	}
}
