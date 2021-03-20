package model;

import java.util.ArrayList;

public class Product {
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

	public Product(String name, ArrayList<SizeAndPrice> sizeAndPrice, String type, ArrayList<Ingredient> ingredients) {
		this.name = name;
		this.sizeAndPrice = sizeAndPrice;
		this.type = type;
		this.ingredients = ingredients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
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
