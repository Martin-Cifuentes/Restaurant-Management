package model;

import java.util.ArrayList;

public class Client extends Person{
	public int opId;
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
	public Client(String n,String ln, int id, String a,int p){
		super(n, ln);
		this.opId = id;
		this.adress = a;
		this.phone = p;
		observations = new ArrayList <String>();
	}
}
