package model;

import java.util.ArrayList;

public class Order {
	public String code;
	public State state;
	public String requestClient;
	public String deliverEmployee;
	public String date;
	public ArrayList<String> observations;
	public ArrayList<Product> productsList;
	public ArrayList<String> productsSizes;
	public ArrayList<Integer> quantityOfProduct;
	
	public Order(String c, State s, String rc, String de, String d, ArrayList<String> o, ArrayList<Product> pl, ArrayList<Integer> qp) {
		this.code = c;//
		this.state = s;//
		this.requestClient = rc;//
		this.deliverEmployee = de;//
		this.date = d;//
		this.observations = o;//
		this.productsList = pl;
		this.quantityOfProduct = qp;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getRequestClient() {
		return requestClient;
	}

	public void setRequestClient(String requestClient) {
		this.requestClient = requestClient;
	}

	public String getDeliverEmployee() {
		return deliverEmployee;
	}

	public void setDeliverEmployee(String deliverEmployee) {
		this.deliverEmployee = deliverEmployee;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public ArrayList<String> getObservations() {
		return observations;
	}

	public void setObservations(ArrayList<String> observations) {
		this.observations = observations;
	}

	public ArrayList<Product> getProductsList() {
		return productsList;
	}

	public void setProductsList(ArrayList<Product> productsList) {
		this.productsList = productsList;
	}
	
	public ArrayList<String> getProductsNames() {
		ArrayList<String> prodNames = new ArrayList<String>();
		for(int i = 0; i < productsList.size(); i++) {
			prodNames.add(productsList.get(i).getName());
		}
		return prodNames;
	}

	public ArrayList<Integer> getQuantityOfProduct() {
		return quantityOfProduct;
	}

	public void setQuantityOfProduct(ArrayList<Integer> quantityOfProduct) {
		this.quantityOfProduct = quantityOfProduct;
	}
	
	public ArrayList<String> getQuantityOfProductStr() {
		ArrayList<String> prodAm = new ArrayList<String>();
		for(int i = 0; i < quantityOfProduct.size(); i++) {
			prodAm.add(String.valueOf(quantityOfProduct.get(i)));
		}
		return prodAm;
	}
	public ArrayList<Double> getProductsPricesList(){
		ArrayList<Double> prodPrice = new ArrayList<Double>();
		for(int i = 0; i < productsList.size(); i++) {
			for(int j = i; j < productsList.get(i).getSizeAndPrice().size(); j++) {
				if(productsSizes.get(i).equals(productsList.get(i).getSizeAndPrice().get(j).getSize())) {
					prodPrice.add(productsList.get(i).getSizeAndPrice().get(j).getPrice());
				}
			}
			
		}
		return prodPrice;
	}

	public ArrayList<String> getProductsSizes() {
		return productsSizes;
	}

	public void setProductsSizes(ArrayList<String> productsSizes) {
		this.productsSizes = productsSizes;
	}
	
}
