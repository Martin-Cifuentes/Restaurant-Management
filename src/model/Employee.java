package model;

public class Employee extends Person {
	
	public int id;
	
	/** 
     * this constructor method creates a Employee objet
     * @param name String, name of the Employee
     * @param lastName String, last name of the Employee
     * @param id int, id number of the Employee
     */
	
	public Employee(String n, String ln, int id) {
		super(n, ln);
		this.id = id;
	}

	
	
	
	
}
