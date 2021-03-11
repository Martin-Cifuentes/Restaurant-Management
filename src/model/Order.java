package model;

import java.util.Date;

public class Order {
	public String code;
	public State state;
	public String requestClient;
	public String deliverEmployee;
	public Date date;
	public String observations;
	public Product[] productsList;
	public int[] quantityOfProduct;
	
	public Order(String c, State s, String rc, String de, Date d, String o, Product[] pl, int[] qp) {
		this.code = c;
		this.state = s;
		this.requestClient = rc;
		this.deliverEmployee = de;
		this.date = d;
		this.observations = o;
		this.productsList = pl;
		this.quantityOfProduct = qp;
	}
}
