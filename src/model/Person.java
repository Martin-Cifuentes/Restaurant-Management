package model;

public class Person {
	public String name;
	public String lastName;
	
	/** 
     * this constructor method creates a Person objet
     * @param name String, name of the Person
     * @param lastName String, last name of the Person
     */
	public Person(String n,String ln){
		this.name = n;
		this.lastName = ln;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
