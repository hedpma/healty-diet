package com.blackchicktech.healthdiet.domain;

import com.blackchicktech.healthdiet.entity.Recipe;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeDetailResponse extends BasicResponse {

	@JsonProperty("recipeName")
	private String recipeName;

	@JsonProperty("cookMethod")
	private String cookMethod;

	@JsonProperty("taste")
	private String taste;

	@JsonProperty("difficulty")
	private String difficulty;

	@JsonProperty("mealTime")
	private String mealTime;

	@JsonProperty("category")
	private String category;

	@JsonProperty("material")
	private String material;

	@JsonProperty("mainIngredients")
	private List<MainIngredient> mainIngredients;

	@JsonProperty("energy")
	private float energy;

	@JsonProperty("protein")
	private float protein;

	@JsonProperty("ckdCategory")
	private String ckdCategory;

	@JsonProperty("ckdCategory")
	private int preference;

	public RecipeDetailResponse(Recipe recipe, List<MainIngredient> mainIngredients, PreferenceResponse preference) {
		if (recipe == null) {
			//set parent value for error
		}

		this.recipeName = recipe.getRecipeName();
		this.cookMethod = recipe.getCookMethod();
		this.taste = recipe.getTaste();
		this.mealTime = recipe.getMealTime();
		this.category = recipe.getCategory();
		this.material = recipe.getMaterial();
		this.mainIngredients = mainIngredients;
		this.energy = recipe.getEnergy();
		this.protein = recipe.getProtein();
		this.ckdCategory = recipe.getCkdCategory();
		this.difficulty = recipe.getDifficulty();
		if (preference != null) {
			this.preference = preference.getPreference();
		}
	}
}
