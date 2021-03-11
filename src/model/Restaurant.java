package model;

import java.util.ArrayList;


public class Restaurant {
	
	private Ingredient ingredients;
	private ArrayList<Employee> employes;
	private ArrayList<Client> clients;
	private ArrayList<Order> orders;
	private ArrayList<Product> products; 
	
	
	
	public Restaurant() {
		super();
		ingredients = new Ingredient();
		employes = new ArrayList<Employee>();
		clients = new ArrayList<Client>();
		orders = new ArrayList<Order>();
		products = new ArrayList<Product>();
	}
	//se agrega un user
	public void createUser(String name, String lastName, int id, String userName,String password) {
		employes.add(new User(name,lastName,id,userName,password));
	}
	//se ve si se pone la contraseña correcta del admin
	public String logInAdmin(String userName,String password) {
		boolean found=false;
		String message="No hay un usuario de administrador con este usuario o contraseña";
		for(int c=0; c< employes.size() && !found;c++) {
			if(employes.get(c) instanceof User) {
				if(userName.equals(employes.get(c).getUserName()) && password.equals(employes.get(c).getPassword())) {
					found=true;
					message="Bienvenido "+employes.get(c).getName();
				}
			}
		}
		return message;
	}
	
}
