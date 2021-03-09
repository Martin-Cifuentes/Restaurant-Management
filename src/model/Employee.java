package model;

public class Employee {
	public String name;
	public String lastName;
	public int id;
	public String adress;
	public int phone;
	
	/** 
     * this constructor method creates a Employee objet
     * @param name String, name of the Employee
     * @param lastName String, last name of the Employee
     * @param id int, id number of the Employee
     * @param adress String, adress of the Employee
     * @param phone Stringn phone of the Employee
     */
	public Employee(String n,String ln, int id, String a,int p){
		this.name = n;
		this.lastName = ln;
		this.id = id;
		this.adress = a;
		this.phone = p;
	}
}
