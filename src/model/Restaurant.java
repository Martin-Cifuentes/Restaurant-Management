package model;

import java.util.ArrayList;

public class Restaurant {

	private ArrayList<Ingredient> ingredients;
	private ArrayList<Employee> employees;
	private ArrayList<Client> clients;
	private ArrayList<Order> orders;
	private ArrayList<Product> products; 
	private ArrayList<Ingredient> ingredientsForProduct;
	private ArrayList<SizeAndPrice> sizeAndPrice;

	public Restaurant() {
		ingredients = new ArrayList<Ingredient>();
		employees = new ArrayList<Employee>();
		clients = new ArrayList<Client>();
		orders = new ArrayList<Order>();
		products = new ArrayList<Product>();
		ingredientsForProduct = new  ArrayList<Ingredient>();
		sizeAndPrice = new ArrayList<SizeAndPrice>();
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
	//add product
	public void ingredientForProduct(Ingredient ingredient) {
		ingredientsForProduct.add(ingredient);
	}
	//add product
	public void resetProductIngredientArray() {
		ingredientsForProduct.clear();
	}
	//add product
	public void sizeAndPriceForProduct(String a,Double b) {
		sizeAndPrice.add(new SizeAndPrice(a, b));
	}
	//add product
	public void resetsizeAndPriceArray() {
		sizeAndPrice.clear();
	}
	//add product
	public boolean addProduct( String name, String type) {
		boolean found=false;
		for(int c=0;c<products.size() && !found;c++) {
			if(name.equals(products.get(c).getName())) {
				found=true;
			}
		}
		if(!found) {
			products.add(new Product( name,  sizeAndPrice,  type,  ingredients));
		}
		return found;
	}
	//add product, checks if ingredient has already been added to a product
	public boolean productCheckDoubleIngredient(String a) {
		boolean found=false;
		for(int c=0;c<ingredientsForProduct.size() && !found;c++ ) {
			if(ingredientsForProduct.get(c).getIngredients().equals(a)) {
				found=true;
			}
		}
		return found;
	}
	//add product, checks if size has already been added to a product
	public boolean productCheckDoubleSize(String a) {
		boolean found=false;
		for(int c=0;c<sizeAndPrice.size() && !found;c++ ) {
			if(sizeAndPrice.get(c).getSize().equals(a)) {
				found=true;
			}
		}
		return found;
	}

	//add product
	public ArrayList<Ingredient> getIngredientsForProduct() {
		return ingredientsForProduct;
	}
	//add product
	public void setIngredientsForProduct(ArrayList<Ingredient> ingredientsForProduct) {
		this.ingredientsForProduct = ingredientsForProduct;
	}
	//se agrega un user
	public void createUser(String name, String lastName, String id,int nOO ,String userName,String password) {
		employees.add(new User(name,lastName,id,nOO,userName,password));
	}
	//se agrega un Employee
	public boolean createEmployee(String name, String lastName, String id,int nOO) {

		boolean found=false;
		for(int c=0;c<employees.size() && !found;c++) {
			if(id.equals(employees.get(c).id)) {
				found=true;
			}
		}
		if(found == false) {
			employees.add(new Employee(name,lastName,id,nOO));
		}
		return found;
	}
	//se ve si se pone la contraseña correcta del admin
	public boolean logInAdmin(String userName,String password) {
		boolean found=false;
		for(int c=0; c< employees.size() && !found;c++) {
			if(employees.get(c) instanceof User) {
				if(userName.equals(employees.get(c).getUserName()) && password.equals(employees.get(c).getPassword())) {
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
		return employees;
	}
	public void setEmployes(ArrayList<Employee> employes) {
		this.employees = employes;
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
	public ArrayList<SizeAndPrice> getSizeAndPrice() {
		return sizeAndPrice;
	}
	public void setSizeAndPrice(ArrayList<SizeAndPrice> sizeAndPrice) {
		this.sizeAndPrice = sizeAndPrice;
	}




}
