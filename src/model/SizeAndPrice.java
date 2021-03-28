package model;

import java.io.Serializable;

public class SizeAndPrice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private String size;
	private double price;
	
	public SizeAndPrice(String size, double price) {
		this.size = size;
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
