package model;

import java.util.ArrayList;

public class Ingredient {
	ArrayList<String> ingredients;
	boolean avialable;
	
	public ArrayList<String> getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(ArrayList<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	public boolean isAvialable() {
		return avialable;
	}
	
	public void setAvialable(boolean avialable) {
		this.avialable = avialable;
	}
	
	public Ingredient(ArrayList<String> ingredients, boolean avialable) {
		this.ingredients = ingredients;
		this.avialable = avialable;
	}
	
	public Ingredient() {
	}
	
	
	
}
