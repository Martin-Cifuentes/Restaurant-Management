package model;

import java.util.ArrayList;

public class Client extends Person{
	
	public String adress;
	public String phone;
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
	public Client(String n,String ln, String id, String a,String p, ArrayList<String> obs){
		super(n, ln,id);
		this.adress = a;
		this.phone = p;
		this.observations = obs;
	}
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ArrayList<String> getObservations() {
		return observations;
	}

	public void setObservations(ArrayList<String> observations) {
		this.observations = observations;
	}
	
}
