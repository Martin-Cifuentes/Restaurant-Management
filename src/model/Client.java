package model;

import java.util.ArrayList;

public class Client extends Person{
	
	public String adress;
	public int phone;
	public ArrayList <String> observations;
	/** 
     * this constructor method creates a Client objet
     * @param name String, name of the Client
     * @param lastName String, last name of the Client
     * @param id int, id number of the Client
     * @param adress String, adress of the Client
     * @param phone Stringn phone of the Client
     * @param 
     */
	public Client(String n,String ln, String id, String a,int p, ArrayList<String> obs){
		super(n, ln,id);
		this.adress = a;
		this.phone = p;
		observations = obs;
	}
	
	public String getAdress() {
		return lastName;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
}
