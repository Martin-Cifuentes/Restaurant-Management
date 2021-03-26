package model;

import java.util.Date;

public class Order {
	public String code;
	public State state;
	public String requestClient;
	public String deliverEmployee;
	public Date date;
	public String[] observations;
	public Product[] productsList;
	public int[] quantityOfProduct;
	
	public Order(String c, State s, String rc, String de, Date d, String[] o, Product[] pl, int[] qp) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String[] getObservations() {
		return observations;
	}

	public void setObservations(String[] observations) {
		this.observations = observations;
	}

	public Product[] getProductsList() {
		return productsList;
	}

	public void setProductsList(Product[] productsList) {
		this.productsList = productsList;
	}

	public int[] getQuantityOfProduct() {
		return quantityOfProduct;
	}

	public void setQuantityOfProduct(int[] quantityOfProduct) {
		this.quantityOfProduct = quantityOfProduct;
	}
	
}
