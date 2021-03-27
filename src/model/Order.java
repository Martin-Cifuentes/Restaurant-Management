package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private String code;
	private State state;
	private String requestClient;
	private String deliverEmployee;
	private Date date;
	private List<String> observations;
	private List<Product> productsList;
	private double price;
	private int[] quantityOfProduct;
	
	

	public Order(String code, State state, String requestClient, String deliverEmployee, Date date,List<String> observations, List<Product> productsList, double price, int[] quantityOfProduct) {
		this.code = code;
		this.state = state;
		this.requestClient = requestClient;
		this.deliverEmployee = deliverEmployee;
		this.date = date;
		this.observations = observations;
		this.productsList = productsList;
		this.price = price;
		this.quantityOfProduct = quantityOfProduct;
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



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public List<String> getObservations() {
		return observations;
	}



	public void setObservations(List<String> observations) {
		this.observations = observations;
	}



	public List<Product> getProductsList() {
		return productsList;
	}



	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int[] getQuantityOfProduct() {
		return quantityOfProduct;
	}



	public void setQuantityOfProduct(int[] quantityOfProduct) {
		this.quantityOfProduct = quantityOfProduct;
	}

	
	
}
