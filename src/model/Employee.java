package model;

public class Employee extends Person {
	
	private int numOfOders;
	private int id;
	
	/** 
     * this constructor method creates a Employee objet
     * @param name String, name of the Employee
     * @param lastName String, last name of the Employee
     * @param id int, id number of the Employee
     */
	
	public Employee(String n, String ln, int id,int nOO) {
		super(n, ln);
		numOfOders=nOO;
		id = id;
	}

	
	
	public int getNumOfOders() {
		return numOfOders;
	}



	public void setNumOfOders(int numOfOders) {
		this.numOfOders = numOfOders;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUserName() {
		return "Este campo no es valido para este empleado";
	}
	
	public void setUserName(String userName) {
	}
	
	public String getPassword() {
		return "Este campo no es valido para este empleado";
	}
	public void setPassword(String password) {
	}

	
	
}
