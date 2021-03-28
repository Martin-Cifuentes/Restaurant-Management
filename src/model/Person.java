package model;

import java.io.Serializable;

public abstract class Person extends History implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	public String name;
	public String lastName;
	public String id;
	
	/** 
     * this constructor method creates a Person objet
     * @param name String, name of the Person
     * @param lastName String, last name of the Person
     */
	public Person(String n,String ln, String id){
		this.name = n;
		this.lastName = ln;
		this.id = id;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", id=" + id + "]";
	}
	
	
}
