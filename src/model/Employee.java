package model;

public class Employee extends Person {
	
	private int numOfOrders;
	
	/** 
     * this constructor method creates a Employee objet
     * @param name String, name of the Employee
     * @param lastName String, last name of the Employee
     * @param id int, id number of the Employee
     */
	
	public Employee(String n, String ln, String id,int nOO) {
		super(n, ln, id);
		numOfOrders=nOO;
	}

	
	
	public int getNumOfOrders() {
		return numOfOrders;
	}
	
	public void setNumOfOrders(int numOfOders) {
		this.numOfOrders = numOfOders;
	}

	@Override
	public String toString() {
		return "Employee [numOfOders=" + numOfOrders + ", name=" + name + ", lastName=" + lastName + ", id=" + id + "]";
	}

	
	
}
