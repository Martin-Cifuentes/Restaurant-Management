package model;

import java.util.ArrayList;

public class Product extends History {
	private String name;
	private ArrayList<SizeAndPrice> sizeAndPrice;
	private String type;
	private ArrayList<Ingredient> ingredients;

	public ArrayList<SizeAndPrice> getSizeAndPrice() {
		return sizeAndPrice;
	}

	public void setSizeAndPrice(ArrayList<SizeAndPrice> sizeAndPrice) {
		this.sizeAndPrice = sizeAndPrice;
	}

	public Product(String name, String type) {
		this.name = name;
		this.type = type;
		ingredients=new ArrayList<Ingredient>();
		sizeAndPrice = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int size() {
		return ingredients.size();
	}

	public String getType() {
		return type;
	}

	public void addIngredient(Ingredient e) {
		ingredients.add(e);
	}
	
	public void addSizeAndPrice(SizeAndPrice e) {
		sizeAndPrice.add(e);
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}


}
