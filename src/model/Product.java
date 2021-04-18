package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Product extends History implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
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
	
	public int searchSize(String size) {
		int pos = 0;
		for(int i = 0; i < sizeAndPrice.size(); i++) {
			if(size.equals(sizeAndPrice.get(i).getSize())){
				pos = i;
			}
		}
		return pos;
	}
	
	public String sizeAndPriceToString() {
		String s=": ";
		for(int c=0;c<sizeAndPrice.size();c++) {
			s+=sizeAndPrice.get(c).getSize()+"\n$"+sizeAndPrice.get(c).getPrice()+" \n";
		}
		return s;
	}
	
	public ArrayList<String> getSizes(){
		ArrayList<String> sizes = new ArrayList<String>();
		for(int i = 0; i < sizeAndPrice.size(); i++) {
			sizes.add(sizeAndPrice.get(i).getSize());
		}
		return sizes;
	}
	
	public ArrayList<Double> getPrices(){
		ArrayList<Double> prices = new ArrayList<Double>();
		for(int i = 0; i < sizeAndPrice.size(); i++) {
			prices.add(sizeAndPrice.get(i).getPrice());
		}
		return prices;
	}
	
	public String ingredientsToString() {
		String s="";
		for(int c=0;c<ingredients.size();c++) {
			if(c==0) {
				s=": "+ingredients.get(c).getIngredients()+", ";
			}else if(c%3==0) {
				if(c==ingredients.size()-1) {
					s+="\ny "+ingredients.get(c).getIngredients();
				}else if(c==ingredients.size()-2){
					s+="\n"+ingredients.get(c).getIngredients()+" ";
				}else {
					s+="\n"+ingredients.get(c).getIngredients()+", ";
				}

			}else {
				if(c==ingredients.size()-1) {
					s+=" y "+ingredients.get(c).getIngredients();
				}else if(c==ingredients.size()-2){
					s+=ingredients.get(c).getIngredients()+" ";
				}else {
					s+=ingredients.get(c).getIngredients()+", ";
				}

			}
		}
		return s;
	}
	
	

}
