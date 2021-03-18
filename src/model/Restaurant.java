package model;

import java.util.ArrayList;

public class Restaurant {

	private ArrayList<Ingredient> ingredients;
	private ArrayList<Employee> employes;
	private ArrayList<Client> clients;
	private ArrayList<Order> orders;
	private ArrayList<Product> products; 

	public Restaurant() {
		ingredients = new ArrayList<Ingredient>();
		employes = new ArrayList<Employee>();
		clients = new ArrayList<Client>();
		orders = new ArrayList<Order>();
		products = new ArrayList<Product>();
	}
	//se añade un ingrediente
	public boolean addIngredient(String name, boolean avialable) {
		boolean found=false;
		for(int c=0;c<ingredients.size() && !found;c++) {
			if(name.equals(ingredients.get(c).getIngredients())) {
				found=true;
			}
		}
		if(!found) {
			ingredients.add(new Ingredient(name,avialable));
		}
		return found;
	}

	//se agrega un user
	public void createUser(String name, String lastName, String id,int nOO ,String userName,String password) {
		employes.add(new User(name,lastName,id,nOO,userName,password));
	}
	//se agrega un Employee
	public void createEmployee(String name, String lastName, String id,int nOO) {
		employes.add(new Employee(name,lastName,id,nOO));
	}
	//se ve si se pone la contraseña correcta del admin
	public boolean logInAdmin(String userName,String password) {
		boolean found=false;
		for(int c=0; c< employes.size() && !found;c++) {
			if(employes.get(c) instanceof User) {
				if(userName.equals(employes.get(c).getUserName()) && password.equals(employes.get(c).getPassword())) {
					found=true;
				}
			}
		}
		return found;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public ArrayList<Employee> getEmployes() {
		return employes;
	}
	public void setEmployes(ArrayList<Employee> employes) {
		this.employes = employes;
	}
	public ArrayList<Client> getClients() {
		return clients;
	}
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}



}
