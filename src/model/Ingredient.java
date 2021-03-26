package model;



public class Ingredient extends History implements Comparable<Ingredient>{
	private String ingredients ;
	private boolean avialable;
	
	
	public boolean isAvialable() {
		return avialable;
	}
	
	public void setAvialable(boolean avialable) {
		this.avialable = avialable;
	}
	
	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public Ingredient(String ingredients, boolean avialable) {
		this.ingredients = ingredients;
		this.avialable = avialable;
	}

	public Ingredient() {
	}

	@Override
	public int compareTo(Ingredient o) {
		return ingredients.compareTo(o.getIngredients());
	}
	

	


	
}
