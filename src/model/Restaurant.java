package model;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Restaurant {


	private List<Ingredient> ingredients;
	private List<Employee> employees;
	private List<Client> clients;
	private List<Order> orders;
	private List<Product> products; 
	private List<Ingredient> ingredientsForProduct;
	private List<SizeAndPrice> sizeAndPrice;
	private List<OrderItem> orderItems;
	private List<Product> menuProducts; 
	private long start;
	private long time;
	private Language language;
	private Dictionary dictionary;

	public Restaurant() {
		ingredients = new ArrayList<>();
		orderItems = new ArrayList<>();
		employees = new ArrayList<>();
		clients = new ArrayList<>();
		orders = new ArrayList<>();
		products = new ArrayList<>();
		ingredientsForProduct = new  ArrayList<>();
		sizeAndPrice = new ArrayList<>();
		menuProducts= new ArrayList<>();
		language = Language.ENGLISH;
		dictionary = new Dictionary(language);
	}

	public void updateOrderProducts(String code) {
		int pos = searchOrder(code);
		orders.get(pos).getItems().clear();
		ArrayList<OrderItem> oI = new ArrayList<>();
		oI.addAll(orderItems);
		orders.get(pos).getItems().addAll(oI);
		orderItems.clear();
	}

	public void updateOrder(String code, State state, String clientName, String employeeName, String date, String[] obs) {
		ArrayList<String>observations = new ArrayList<String>();
		for(int i = 0; i<obs.length; i++) {
			observations.add(obs[i]);
		}
		int pos = searchOrder(code);
		Order order = new Order(code, state, clientName, employeeName, date, observations, orders.get(pos).getItems());
		System.out.println(order);
		orders.set(pos,order);

	}
	
	public void createOrder(State state, String clientName, String employeeName, String date, String[] obs) {
		String code = randomCode();
		int exist = searchOrder(code);

		ArrayList<OrderItem> oI = new ArrayList<>();
		oI.addAll(orderItems);


		ArrayList<String>observations = new ArrayList<String>();
		for(int i = 0; i<obs.length; i++) {
			observations.add(obs[i]);
		}

		if(exist < 0) {
			Order order = new Order(code, state, clientName, employeeName, date, observations, oI);
			orders.add(order);
		}else {
			createOrder(state,clientName,employeeName,date,obs);
		}
	}

	public ArrayList<String> getemployeesNames() {
		ArrayList<String> names = new ArrayList<String>();
		for(int i = 0; i < employees.size(); i++) {
			names.add(employees.get(i).getName());
		}
		return names;
	}

	public ArrayList<String> getClientsNames() {
		ArrayList<String> names = new ArrayList<String>();
		for(int i = 0; i < clients.size(); i++) {
			names.add(clients.get(i).getName());
		}
		return names;
	}

	public void addOrderItem(Product product, String size, double price, int amount) {
		OrderItem item = new OrderItem(product,size,price,amount);
		orderItems.add(item);
	}

	public int searchOrderItem(String name, String size) {
		int pos = 0;
		for(int i = 0; i<orderItems.size(); i++) {
			if(name.equals(orderItems.get(i).getProductName()) && size.equals(orderItems.get(i).getProductSize())) {
				pos = i;
			}
		}
		return pos;
	}

	public ArrayList<String> getProductsNames(){
		ArrayList<String> names = new ArrayList<String>();
		for(int i = 0; i<products.size(); i++) {
			names.add(products.get(i).getName());
		}
		return names;
	}

	public int searchProduct(String name) {
		int pos = 0;
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getName().equals(name)) {
				pos = i;
			}
		}
		return pos;
	}

	public ArrayList<String> getTotalPriceForOrderProduct(int o) {
		ArrayList<String> totals = new ArrayList<String>();
		for(int i = 0; i < orders.get(o).getProductsPricesList().size(); i++) {
			totals.add(String.valueOf(orders.get(o).getProductsPricesList().get(i) * orders.get(o).getQuantityOfProduct().get(i)));

		}

		return totals;
	}

	public String getTotalPriceOfOrder(int o) {
		String total = "";
		ArrayList<String> totals = getTotalPriceForOrderProduct(o);
		for(int i = 0; i < totals.size(); i++) {
			total += totals.get(i);
		}
		return total;
	}
	/**
	 * 
	 * @param longitud
	 * @return
	 */
	public String randomCode() {
		String box = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String code = "";
		for (int x = 0; x < 10; x++) {
			int randInt = randNum(0, box.length() - 1);
			char randChar = box.charAt(randInt);
			code += randChar;
		}
		return code;
	}

	public int randNum(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}


	//se añade un ingrediente
	public boolean addIngredient(String name, boolean avialable) throws IOException {
		boolean found=false;
		for(int c=0;c<ingredients.size() && !found;c++) {
			if(name.equals(ingredients.get(c).getIngredients())) {
				found=true;
			}
		}
		if(!found) {
			ingredients.add(new Ingredient(name,avialable));
			saveData();
		}
		return found;
	}
	//menu page
	public void resetMenuProducts() {
		menuProducts.clear();
		boolean add=true;
		for(int c=0;c<products.size();c++) {
			add=true;
			for(int i=0;i<products.get(c).getIngredients().size();i++) {
				if(!products.get(c).getIngredients().get(i).isAvialable()) {
					add=false;
				}
				if(add) {
					menuProducts.add(products.get(c));
				}
			}
		}
	}
	//menu page
	public void searchMenuProducts(String search) {
		for(int c=0;c<menuProducts.size();c++) {
			if(!menuProducts.get(c).getName().contains(search)) {
				menuProducts.remove(c);
			}
		}
	}
	//comparator for employee
	public void sortEmployee() {
		EmployeeIdComparator afc= new EmployeeIdComparator();
		Collections.sort(employees,afc);
	}


	//selection sort for products
	public void selectionSort() {
		Product tmpProduct=null;
		for (int j = 0; j < products.size()-1; j++) {
			int min=j;
			for (int k = 1+j; k < products.size(); k++) {
				if(products.get(k).getName().compareTo(products.get(min).getName())<0) {
					min=k;
				}
				tmpProduct=products.get(min);
				products.remove(min);
				products.add(min,products.get(j));
				products.remove(j);
				products.add(j,tmpProduct);

			}
		}
	}

	//bubble sort for clients
	public void bubbleSortForClients() {
		Client tmpClient= null;
		for(int c=0; c < clients.size();c++) {
			for(int i=c+1; i < clients.size();i++) {
				if(clients.get(i).getId().compareTo(clients.get(c).getId())<0) {
					tmpClient=clients.get(i);
					clients.remove(i);
					clients.add(i,clients.get(c));
					clients.remove(c);
					clients.add(c,tmpClient);
				}
			}
		}

	}

	//binary sort for client search
	public int binarySearchForClients(String id) {
		start=System.nanoTime();
		int l = 0;
		int size = clients.size() - 1;
		int found=-1;
		while (l <= size) {
			int m = l + (size - l) / 2;
			int answer = id.compareTo(clients.get(m).getId());
			if (answer == 0) {
				found= m;
			}
			if (answer > 0) {
				l = m + 1;

			}else {
				size = m - 1;
			}
		}
		time=System.nanoTime()-start;
		return found;
	}

	public long getTime() {
		return time;
	}


	//ingredients
	public void sortIngredients() {
		Collections.sort(ingredients);
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
	public boolean addProduct( String name ,String type ) throws IOException {
		boolean found=false;
		for(int c=0;c<products.size() && !found;c++) {
			if(name.equals(products.get(c).getName())) {
				found=true;
			}
		}
		if(!found) {
			products.add(new Product( name, type));
			for(int c=0; c<ingredientsForProduct.size();c++) {
				products.get(products.size()-1).addIngredient(ingredientsForProduct.get(c));
			}
			for(int c=0; c<sizeAndPrice.size();c++) {
				products.get(products.size()-1).addSizeAndPrice(sizeAndPrice.get(c));
			}
			resetProductIngredientArray();
			resetsizeAndPriceArray();
			saveData();
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
	public List<Ingredient> getIngredientsForProduct() {
		return ingredientsForProduct;
	}
	//add product
	public void setIngredientsForProduct(ArrayList<Ingredient> ingredientsForProduct) {
		this.ingredientsForProduct = ingredientsForProduct;
	}
	//se agrega un user
	/*public void createUser(String name, String lastName, String id,int nOO ,String userName,String password) {
		employees.add(new User(name,lastName,id,nOO,userName,password));
	}*/
	//se agrega un Employee
	public boolean createEmployee(String name, String lastName, String id,int nOO) throws IOException {

		boolean found=false;
		for(int c=0;c<employees.size() && !found;c++) {
			if(id.equals(employees.get(c).getId())) {
				found=true;
			}
		}
		if(found == false) {
			employees.add(new Employee(name,lastName,id,nOO));
			saveData();
		}
		return found;
	}
	/**
	 * se agrega un usuario
	 * @throws IOException 
	 */
	public boolean createUser(String name, String lastName, String id,int nOO, String userName, String password) throws IOException {

		boolean found=false;
		for(int c=0;c<employees.size() && !found;c++) {
			if(id.equals(employees.get(c).getId())) {
				found=true;
			}
		}
		if(found == false) {
			employees.add(new User(name,lastName,id,nOO,userName,password));
			saveData();
		}
		return found;
	}
	/**
	 * se modifica un usuario
	 */
	public void updateUser(String userName, String password,String name, String lastName, String id, int nOO) {
		User user = new User(name, lastName, id, nOO, userName, password);
		int pos = searchEmployee(id);
		employees.set(pos, user);
	}
	/**
	 * se modifica un empleado
	 */
	public void updateEmployee(String name, String lastName, String id, int nOO) {
		Employee employee = new Employee(name, lastName, id, nOO);
		int pos = searchEmployee(id);
		employees.set(pos, employee);
	}
	//buscar un cliente
	public int searchClient(String id) {
		int x = -1;
		for(int i = 0; i< clients.size(); i++ ) {
			if(clients.get(i).getId().equals(id)) {
				x = i;
			}
		}
		return x;
	}
	//se agrega un cliente
	public boolean createClient(String name, String lastName, String id, String adress, String phone, String[] obs) {
		ArrayList<String>observations = new ArrayList<String>();
		for(int i = 0; i<obs.length; i++) {
			observations.add(obs[i]);
		}
		boolean found=false;
		for(int c=0;c<clients.size() && !found;c++) {
			if(id.equals(clients.get(c).getId())) {
				found=true;
			}
		}

		if(!found) {

			clients.add(new Client(name,lastName,id,adress,phone,observations));
		}
		return found;
	}
	/**
	 *actualiza un cliente 
	 */
	public void updateClient(String name, String lastName, String id, String adress, String phone, String[] obs) {
		ArrayList<String>observations = new ArrayList<String>();
		for(int i = 0; i<obs.length; i++) {
			observations.add(obs[i]);
		}
		Client client = new Client(name, lastName, id, adress, phone, observations);
		int pos = searchClient(id);
		clients.set(pos, client);
	}
	/**
	/buscar un empleado
	 */
	public int searchEmployee(String id) {
		int x = -1;
		for(int i = 0; i< employees.size(); i++ ) {
			if(employees.get(i).getId().equals(id)) {
				x = i;
			}
		}
		return x;
	}

	/**
	/buscar una orden
	 */
	public int searchOrder(String code) {
		int x = -1;
		for(int i = 0; i< orders.size(); i++ ) {
			if(orders.get(i).getCode().equals(code)) {
				x = i;
			}
		}
		return x;
	}

	//se ve si se pone la contraseña correcta del admin
	public boolean logInAdmin(String userName,String password) {
		boolean found=false;
		for(int c=0; c< employees.size() && !found;c++) {
			if(employees.get(c) instanceof User) {
				if(userName.equals(((User)employees.get(c)).getUserName()) && password.equals(((User)employees.get(c)).getPassword())) {
					found=true;
				}
			}
		}
		return found;
	}

	public ArrayList<User> getUsers(){
		ArrayList<User> users = new ArrayList<User>();
		for(int i = 0; i < employees.size(); i++ ) {
			if(employees.get(i) instanceof User) {
				users.add((User) employees.get(i));
			}
		}

		return users;
	}
	public void importOrders(String user) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/ImportEmployees.csv"));
		String line= br.readLine();
		while(line!=null) {
			String[] parts= line.split(",");
			employees.add(new Employee(parts[0], parts[1], parts[2], 0));
			employees.get(employees.size()-1).setCreatedBy(user);
			employees.get(employees.size()-1).setLastEditedBy(user);
			line=br.readLine();
		}
		br.close();

		br = new BufferedReader(new FileReader("data/ImportOrders.csv"));
		line= br.readLine();
		ArrayList<String> o = new ArrayList<>();
		ArrayList<OrderItem> oi = new ArrayList<>();
		int c=0;
		while(line!=null) {
			String[] parts= line.split(",");
			o.add(parts[2]);
			int stateChooser=0;
			Random random = new Random();
			stateChooser=  random.nextInt(4 - 1 + 1) + 1;
			oi.add(new OrderItem(products.get(c), products.get(c).getSizeAndPrice().get(0).getSize(), products.get(c).getSizeAndPrice().get(0).getPrice(), Integer.parseInt(parts[3])));
			ArrayList<OrderItem> oiTemp= new ArrayList<>();
			oiTemp.addAll(oi);
			oi.clear();
			if(stateChooser==1) {
				orders.add(new Order(parts[0], State.valueOf("SOLICITADO"),clients.get(c).getName(), employees.get(c).getName(), parts[1],  o ,  oiTemp));
			}else if(stateChooser==2) {
				orders.add(new Order(parts[0], State.valueOf("ENVIADO"),clients.get(c).getName(), employees.get(c).getName(), parts[1],  o ,  oiTemp));
			}else if(stateChooser==3){
				orders.add(new Order(parts[0], State.valueOf("ENTREGADO"),clients.get(c).getName(), employees.get(c).getName(), parts[1],  o ,  oiTemp));
			}else {
				orders.add(new Order(parts[0], State.valueOf("EN_PROCESO"),clients.get(c).getName(), employees.get(c).getName(), parts[1],  o ,  oiTemp));
			}
			c++;
			line=br.readLine();
		}
		br.close();
	}

	//se importan ingredientes
	public void importIngredientData(String user) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("data/ImportIngredientData.txt"));
		String line= br.readLine();
		while(line!=null) {
			String[] parts= line.split(",");
			ingredients.add(new Ingredient(parts[0],Boolean.parseBoolean(parts[1])));
			ingredients.get(ingredients.size()-1).setCreatedBy(user);
			ingredients.get(ingredients.size()-1).setLastEditedBy(user);
			line=br.readLine();
		}
		br.close();
	}
	
	
	//se importan productos
	public void importProductData(String user) throws IOException{
		List<Ingredient> TmpIngredients = new ArrayList<>();
		List<SizeAndPrice> TmpsizeAndPrice = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("data/ImportIngredientData.txt"));
		String line= br.readLine();
		while(line!=null) {
			String[] parts= line.split(",");
			TmpIngredients.add(new Ingredient(parts[0],Boolean.parseBoolean(parts[1])));
			line=br.readLine();
		}
		br.close();

		br = new BufferedReader(new FileReader("data/ImportSizeAndPriceData.txt"));
		line= br.readLine();
		while(line!=null) {
			String[] parts= line.split(",");
			TmpsizeAndPrice.add(new SizeAndPrice(parts[0],Double.parseDouble(parts[1])));
			line=br.readLine();
		}

		br.close();

		br = new BufferedReader(new FileReader("data/ImportProductData.txt"));
		line= br.readLine();
		int i= 0;
		while(line!=null) {
			String[] parts= line.split(",");
			products.add(new Product(parts[0],(parts[1])));
			line=br.readLine();
			products.get(i).addIngredient(TmpIngredients.get(i));
			products.get(i).addSizeAndPrice(TmpsizeAndPrice.get(i));
			products.get(i).setCreatedBy(user);
			products.get(i).setLastEditedBy(user);
			i++;
		}
		br.close();
	}
	//se importan clientes
	public void importClients(String user) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("data/ImportClientData.txt"));
		String line= br.readLine();
		ArrayList<String> obs=new ArrayList<String>();
		ArrayList<String> obsSend=new ArrayList<String>();
		while(line!=null) {
			String[] parts= line.split(",");
			obs.add(parts[5]);
			obs.add(parts[6]);
			obsSend.addAll(obs);
			clients.add(new Client(parts[0],parts[1],parts[2], parts[3],parts[4],obsSend));
			clients.get(clients.size()-1).setCreatedBy(user);
			clients.get(clients.size()-1).setLastEditedBy(user);
			line=br.readLine();
			obs.clear();
		}
		br.close();
	}

	public void saveData() throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/SaveClientInfo.ap2"));
		oos.writeObject(clients);
		oos.close();
		oos = new ObjectOutputStream(new FileOutputStream("data/SaveIngredientInfo.ap2"));
		oos.writeObject(ingredients);
		oos.close();
		oos = new ObjectOutputStream(new FileOutputStream("data/SaveEmployeeInfo.ap2"));
		oos.writeObject(employees);
		oos.close();
		oos = new ObjectOutputStream(new FileOutputStream("data/SaveProductInfo.ap2"));
		oos.writeObject(products);
		oos.close();
		oos = new ObjectOutputStream(new FileOutputStream("data/SaveClientInfo.ap2"));
		oos.writeObject(clients);
		oos.close();
		oos = new ObjectOutputStream(new FileOutputStream("data/SaveOrderData.ap2"));
		oos.writeObject(orders);
		oos.close();

	}

	@SuppressWarnings("unchecked")
	public boolean loadOrderData() throws IOException, ClassNotFoundException{
		File f = new File("data/SaveOrderData.ap2");
		boolean loaded = false;

		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			orders = (ArrayList<Order>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}

	@SuppressWarnings("unchecked")
	public boolean loadClientsData() throws IOException, ClassNotFoundException{
		File f = new File("data/SaveClientInfo.ap2");
		boolean loaded = false;

		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			clients = (ArrayList<Client>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}

	@SuppressWarnings("unchecked")
	public boolean loadIngredientsData() throws IOException, ClassNotFoundException{
		File f = new File("data/SaveIngredientInfo.ap2");
		boolean loaded = false;
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			ingredients = (ArrayList<Ingredient>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}

	@SuppressWarnings("unchecked")
	public boolean loadEmployeesData() throws IOException, ClassNotFoundException{
		File f = new File("data/SaveEmployeeInfo.ap2");
		boolean loaded = false;
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			employees = (ArrayList<Employee>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}

	@SuppressWarnings("unchecked")
	public boolean loadProductsData() throws IOException, ClassNotFoundException{
		File f = new File("data/SaveProductInfo.ap2");
		boolean loaded = false;
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			products = (ArrayList<Product>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}

	public void clearData() throws IOException {
		clients.clear();
		products.clear();
		ingredients.clear();
		sizeAndPrice.clear();
		employees.clear();
		menuProducts.clear();
		orders.clear();
		orderItems.clear();
		createUser("Admin","SuperAdmin","a003",0,"A","1");
	}
	//TODO
	public boolean compareDates(String d1,String d2,String d3) {
		boolean found =false;
		String[] d1Parts= d1.split("/");
		String[] d2Parts= d2.split("/");
		String[] d3Parts= d3.split("/");
		String d1S=d1Parts[2]+"/"+d1Parts[1]+"/"+d1Parts[0];
		String d2S=d2Parts[2]+"/"+d2Parts[1]+"/"+d2Parts[0];
		String d3S=d3Parts[2]+"/"+d3Parts[1]+"/"+d3Parts[0];
	      if(d1S.compareTo(d3S) <= 0 && d2S.compareTo(d3S) >= 0) {
	      found = true;
	      }
	      return found;
	}
	//TODO 
	public void exportData(String d1,String d2,String sep) throws FileNotFoundException {
		PrintWriter pw= new PrintWriter("data/exportOrders.csv");
		for(int c=0;c<orders.size();c++) {
			Client tempClient = new Client();
			if(compareDates(d1, d2, orders.get(c).getDate())){		
				boolean found=false;
				for(int i=0;i<clients.size() && !found;i++) {
					if(clients.get(i).getName().equals(orders.get(c).getRequestClient())){
						found=true;
						tempClient=clients.get(i);
					}
				}
				pw.println(orders.get(c).getRequestClient()+""+sep+""+tempClient.getAdress()+""+sep+""+tempClient.getPhone()+""+sep+""+orders.get(c).getDeliverEmployee()+""+sep+""+orders.get(c).getStateString()+""+sep+""+orders.get(c).getDate()+""+sep+""+orders.get(c).getObservationsStrWhitoutLinejump()+""+orders.get(c).exportProduct(sep));
			}

		}
		pw.close();
	}
	//TODO	
	public void exportProduct(String d1,String d2) throws IOException {
		PrintWriter pw= new PrintWriter("data/ExportProducts.csv");
		for(int i =0;i<products.size();i++ ) {
			int timesOrdered=0;
			double price=0;
			for(int c=0;c<orders.size();c++) {
				if(compareDates(d1, d2, orders.get(c).getDate())){	
					for(int z=0;z<orders.get(c).getProductsList().size();z++) {
						if(products.get(i).getName().equals(orders.get(c).getItems().get(z).getProductName())){
							for(int a=0;a<products.get(i).getSizeAndPrice().size();a++) {
								if(products.get(i).getSizeAndPrice().get(a).getSize().equals(orders.get(c).getItems().get(z).getProductSize())){
									timesOrdered++;
									price+=orders.get(c).getItems().get(z).getProductPrice();
								}
							}
						}
					}
					
				}
			}
			if(timesOrdered!=0) {
				pw.println(products.get(i).getName()+";"+timesOrdered+";"+price);
			}
		}
		pw.close();
	}
	
	public void loadLenguage() throws IOException{
		ArrayList<Word> read = new ArrayList<Word>();
		BufferedReader br;
		if(dictionary.getActualLanguage() == Language.SPANISH) {
			br = new BufferedReader(new FileReader("data/Languages/ImportWordsSpanish.csv"));
		} else if(dictionary.getActualLanguage() == Language.ENGLISH) {
			br = new BufferedReader(new FileReader("data/Languages/ImportWordsEnglish.csv"));
		} else if(dictionary.getActualLanguage() == Language.CHINISE) {
			br = new BufferedReader(new FileReader("data/Languages/ImportWordsChinese.csv"));
		} else if(dictionary.getActualLanguage() == Language.FRENCH) {
			br = new BufferedReader(new FileReader("data/Languages/ImportWordsFrench.csv"));
		} else if(dictionary.getActualLanguage() == Language.GERMAN) {
			br = new BufferedReader(new FileReader("data/Languages/ImportWordsGerman.csv"));
		} else if(dictionary.getActualLanguage() == Language.ITALIAN) {
			br = new BufferedReader(new FileReader("data/Languages/ImportWordsItalian.csv"));
		} else if(dictionary.getActualLanguage() == Language.JAPANESE) {
			br = new BufferedReader(new FileReader("data/Languages/ImportWordsJapanese.csv"));
		} else if(dictionary.getActualLanguage() == Language.KOREAN) {
			br = new BufferedReader(new FileReader("data/Languages/ImportWordsKorean.csv"));
		} else if(dictionary.getActualLanguage() == Language.PORTUGUESE) {
			br = new BufferedReader(new FileReader("data/Languages/ImportWordsPortuguese.csv"));
		} else if(dictionary.getActualLanguage() == Language.RUSIAN) {
			br = new BufferedReader(new FileReader("data/Languages/ImportWordsRussian.csv"));
		} else  {
			br = new BufferedReader(new FileReader("data/ImportWordsEnglish.csv"));
		}
		String line= br.readLine();
		String[] parts;
		while(line!=null) {
			parts= line.split(",");
			System.out.println(line);
			read.add(new Word(parts[0],parts[1]));
			line=br.readLine();
		}//br.readLine()
		br.close();
		
		dictionary.setWords(read);
	}

	@Override
	public String toString() {
		return "Restaurant [employees=" + employees + "]" + "Restaurant [users=" + this.getUsers() + "]" ;

	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public List<Employee> getEmployes() {
		return employees;
	}
	public void setEmployes(ArrayList<Employee> employes) {
		this.employees = employes;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	public List<SizeAndPrice> getSizeAndPrice() {
		return sizeAndPrice;
	}
	public void setSizeAndPrice(ArrayList<SizeAndPrice> sizeAndPrice) {
		this.sizeAndPrice = sizeAndPrice;
	}
	public List<Product> getMenuProducts() {
		return menuProducts;
	}
	public void setMenuProducts(ArrayList<Product> menuProducts) {
		this.menuProducts = menuProducts;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	



}
