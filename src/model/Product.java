package model;

import java.util.ArrayList;

public class Product {
	public String name;
	public boolean size;
	public String type;
	public ArrayList<String> ingredients;
	
	public Product(String n, boolean s, String t){
		this.name = n;
		this.size = s;
		this.type = t;
		this.ingredients = new ArrayList<String>();
	}
}
