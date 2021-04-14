package ui;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import model.Client;
import model.Employee;
import model.Ingredient;
import model.Order;
import model.OrderItem;
import model.Product;
import model.Restaurant;

import model.SizeAndPrice;
import model.State;
import model.User;


public class RestaurantGUI {

	private Restaurant restaurant;

	public RestaurantGUI() {
		restaurant= new Restaurant();
	}


	private String currentUser;
	public final static String SEP = "\n";
	//main-pane
	@FXML
	private Pane mainPane;
	//main page
	@FXML
	private Label lbldateAndTime;


	//admin-page
	@FXML
	private TextField txtUsuario;
	//admin-page
	@FXML
	private PasswordField txtPassword;
	//admin-page
	@FXML
	private Label lblAdminPagewarning;

	//Employee-page
	@FXML
	private TableView<Employee> tvEmployees;

	//Employee-page
	@FXML
	private TableColumn<Employee, String> tcName;

	//Employee-page
	@FXML
	private TableColumn<Employee, String> tcLastName;

	//Employee-page
	@FXML
	private TableColumn<Employee, String> tcId;

	//Employee-page
	@FXML
	private TableColumn<Employee, Integer> tcNumOfOrders;

	@FXML
	private TextField txtNameIgredient;

	@FXML
	private RadioButton rbtnAvailable;

	@FXML
	private ToggleGroup available;

	@FXML
	private RadioButton rbtnNotAvailable;


	//create-Employee
	@FXML
	private TextField txtEmployeeName;
	//create-Employee
	@FXML
	private TextField txtEmployeeLastName;
	//create-Employee

	@FXML
	private TextField txtEmployeeId;
	//create-Employee
	@FXML
	private TextField txtNumOfOrders;
	//create-Employee
	@FXML
	private Label confirmEmployee;
	//ingredient page
	@FXML
	private Label lblIngredientPageWarning;
	//addIngredients
	@FXML
	private Label lblAddIngredient;
	//ingredient
	@FXML
	private TableView<Ingredient> tvIngredients;
	//ingredient
	@FXML
	private TableColumn<Ingredient, String> tcIngredient;
	//ingredient
	@FXML
	private TableColumn<Ingredient, Boolean> tcAvialable;
	//admin ingredient
	@FXML
	private RadioButton rbtnAdminIngredientsAvielable;
	//admin ingredient
	@FXML
	private RadioButton rbtnAdminIngredientsNotAvailable;
	//admin ingredient
	@FXML
	private Label lblNameIngredient;
	//admin ingredient
	@FXML
	private ComboBox<String> cboxIngredients;
	//admin ingredient
	@FXML
	private ToggleGroup adminIngredoeint;



	@FXML
	private ListView<String> listA;



	//admin ingredient
	@FXML
	private Label lblIngredientCreatedBy;
	//admin ingredient
	@FXML
	private Label lblIngredientLastEditedBy;
	//addProduct-page
	@FXML
	private TextField txtPriceOfSizeOfProduct;
	//addProduct-page
	@FXML
	private TextField txtTypeOfProduct;
	//addProduct-page
	@FXML
	private TextField txtSizeOfProduct;
	//addProduct-page
	@FXML
	private TextField txtNameOfProduct;
	//addProduct-page
	@FXML
	private ComboBox<String> cboxIngredientsForProduct;
	//addProduct-page
	@FXML
	private Label lblSizeAndPriceOfProducts;
	//addProduct-page
	@FXML
	private Label lblIngredientsForProduct;
	//addProduct-page
	@FXML
	private Label lblAddProductWarning;

	//admin ingredient
	@FXML
	private Label lblAdminIngredientWarning;

	//Client-page
	@FXML
	private TableView<Client> tvClients;

	@FXML
	private TableColumn<Client, String> tcClientName;

	@FXML
	private ListView<String> lvClients;


	@FXML
	private TableColumn<Client, String> tcClientLastName;

	@FXML
	private TableColumn<Client, String> tcClientID;

	@FXML
	private TableColumn<Client, String> tcClientAdress;

	@FXML
	private TableColumn<Client, Integer> tcClientPhone;

	@FXML
	private Label lblTimeOfSearch;

	//product page
	@FXML
	private TableView<Product> tvProducts;
	//product page
	@FXML
	private TableColumn<Product, String> tcNameOfProduct;
	//product page
	@FXML
	private TableColumn<Product, String> tcTypeOfProduct;


	//create-Client
	@FXML
	private Button btnCreateClient;

	@FXML
	private Label tiltleCreateClient;

	@FXML
	private TextField txtClientName;

	@FXML
	private TextField txtClientLastName;

	@FXML
	private TextField txtClientID;

	@FXML
	private TextField txtClientAdress;

	@FXML
	private TextField txtClientPhone;


	/*@FXML
    private Button btnModifyClient;*/
	@FXML
	private TextArea txtClientObservations;

	@FXML
	private Label labConfirmClient;

	//modify-Clients
	@FXML
	private TextField txtModifyClientName;

	@FXML
	private TextField txtModifyClientLastName;

	@FXML
	private Label labModifyClientID;

	@FXML
	private TextField txtModifyClientAdress;

	@FXML
	private TextField txtModifyClientPhone;

	@FXML
	private TextArea txtModifyClientObservations;

	@FXML
	private Label labConfirmModifyClient;



	//Users-page
	@FXML
	private TableView<User> tvUsers;

	@FXML
	private TableColumn<User, String> tcUserUserName;

	@FXML
	private TableColumn<User, String> tcUserName;

	@FXML
	private TableColumn<User, String> tcUserLastName;

	@FXML
	private TableColumn<User, String> tcUserID;

	@FXML
	private TableColumn<User, Integer> tcUserNoo;

	//createUser

	@FXML
	private TextField txtUserUserName;

	@FXML
	private PasswordField txtUserPassword;

	@FXML
	private TextField txtUserName;

	@FXML
	private TextField txtUserLastName;

	@FXML
	private TextField txtUserID;

	@FXML
	private TextField txtUserNoo;

	@FXML
	private Label confirmCreateUser;

	//modify-User
	@FXML
	private TextField txtModifyUsersUserName;

	@FXML
	private PasswordField txtModifyUserPassword;

	@FXML
	private TextField txtModifyUsersName;


	//Orders-page
	@FXML
	private TableView<Order> tvOrders;

	@FXML
	private ListView<String> lvOrdersObs;

	@FXML
	private TableColumn<Order, String> tcOrderCode;

	@FXML
	private TableColumn<Order, String> tcOrderState;

	@FXML
	private TableColumn<Order, String> tcOrderClient;

	@FXML
	private TableColumn<Order, String> tcOrderEmployee;

	@FXML
	private TableColumn<Order, String> tcOrderDate;

	/*@FXML
    private ListView<String> lvOrderProductsPrice;

    @FXML
    private ListView<String> lvOrderProductsCant;

    @FXML
    private ListView<String> lvOrderProducts;

    @FXML
    private ListView<String> lvOrderProductsSize;*/

	@FXML
	private TableView<OrderItem> tvOrderItems;

	@FXML
	private TableColumn<OrderItem, String> tcOrderProduct;

	@FXML
	private TableColumn<OrderItem, Integer> tcOrderProductAmount;

	@FXML
	private TableColumn<OrderItem, String> tcOrderProductSize;

	@FXML
	private TableColumn<OrderItem, Double> tcOrderProductPrice;

	@FXML
	private Label labTotalPrice;


	//create-Order
	@FXML
	private TextArea txtOrderObs;

	@FXML
	private Label labConfirmOrder;

	@FXML
	private Label labConfirmAddOrderS1;

	/*@FXML
	private TextField txtClientOrderName;

    @FXML
	private TextField txtEmployeeOrderName;*/
	@FXML
	private ChoiceBox<String> cbAbleClients;

	@FXML
	private ChoiceBox<String> cbAbleEmployees;

	@FXML
	private ChoiceBox<String> cbOrderState;

	@FXML
	private DatePicker calendarDate;

	//create-Order1

	@FXML
	private TableView<OrderItem> tvListOrderProducts;

	@FXML
	private TableColumn<OrderItem, String> tcCreateOrderProduct;

	@FXML
	private TableColumn<OrderItem, Integer> tcCreateOrderProductAmount;

	//addProductToOrder-page
	@FXML
	private Label labConfirmProductToOrder;

	@FXML
	private TextField txtProductCant;

	@FXML
	private ChoiceBox<String> cbProductsToOrder;

	@FXML
	private ChoiceBox<String> cbProductsSize;





	@FXML
	void btnAddProductToOrder(ActionEvent event) {
		try {
			if(Integer.parseInt(txtProductCant.getText()) != 0 && !cbProductsToOrder.getValue().equals("") && !cbProductsSize.getValue().equals("")) {
				int pos = restaurant.searchProduct(cbProductsToOrder.getValue());
				int sizePos = restaurant.getProducts().get(pos).searchSize(cbProductsSize.getValue());
				double price = restaurant.getProducts().get(pos).getSizeAndPrice().get(sizePos).getPrice();
				restaurant.addOrderItem(restaurant.getProducts().get(pos), cbProductsSize.getValue(),
						price, Integer.parseInt(txtProductCant.getText()));

				labConfirmProductToOrder.setText("Producto agregado correctamente a orden");
				labConfirmProductToOrder.setTextFill(Paint.valueOf("Green"));
			}else {
				labConfirmProductToOrder.setText("Se deben llenar todos los espacios");
				labConfirmProductToOrder.setTextFill(Paint.valueOf("RED"));
			}
		}catch (NumberFormatException nfe) {
			labConfirmProductToOrder.setText("Los valores no corresponden");
			labConfirmProductToOrder.setTextFill(Paint.valueOf("RED"));
		}

	}

	@FXML
	void findProduct(MouseEvent event) {
		if(cbProductsToOrder.getValue() != null) {
			String prodName = cbProductsToOrder.getValue();
			int pos = restaurant.searchProduct(prodName);
			ObservableList<String> observableList = FXCollections.observableArrayList(restaurant.getProducts().get(pos).getSizes());
			cbProductsSize.setItems(observableList);
		}else {
			labConfirmProductToOrder.setText("Ingrese primero el producto para poder ver sus tamaños");
			labConfirmProductToOrder.setTextFill(Paint.valueOf("orange"));
		}
	}


	@FXML
	void btnBackToCreateOrder(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("create-Order.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//create-Order
	@FXML
	void addOrder(ActionEvent event) {
		String[] observations;

		try {

			if(!cbAbleClients.getValue().equals("") && !cbAbleEmployees.getValue().equals("") &&
					!String.valueOf(calendarDate.getValue()).equals("") && !restaurant.getOrderItems().isEmpty()
					&& !cbOrderState.getValue().equals("")) {


				if(!txtOrderObs.getText().equals("")) {
					observations = txtOrderObs.getText().split(SEP);
				}else {
					observations = new String[1];
				}

				State state = null;
				if(!txtOrderObs.getText().equalsIgnoreCase("SOLICITADO")) {
					state = State.SOLICITADO;
				}else if(!txtOrderObs.getText().equalsIgnoreCase("ENVIADO")) {
					state = State.ENVIADO;
				}else if(!txtOrderObs.getText().equalsIgnoreCase("ENTREGADO")) {
					state = State.ENTREGADO;
				}else if(!txtOrderObs.getText().equalsIgnoreCase("EN_PROCESO")) {
					state = State.EN_PROCESO;
				}

				restaurant.createOrder(state, cbAbleClients.getValue(),
						cbAbleEmployees.getValue(), String.valueOf(calendarDate.getValue()) ,
						observations);

				labConfirmOrder.setText("Orden agregada correctamente");
				labConfirmOrder.setTextFill(Paint.valueOf("Green"));

			}else {

				labConfirmOrder.setText("Se deben llenar todos los espacios");
				labConfirmOrder.setTextFill(Paint.valueOf("RED"));

				System.out.println("observaciones: " + txtOrderObs.getText() + " cliente: " + cbAbleClients.getValue() 
				+ " empleado: " + cbAbleEmployees.getValue() + " dia: " + calendarDate.getValue() + 
				" orderitems: " + restaurant.getOrderItems() + " estado: " + cbOrderState.getValue());

			}
		}catch(NumberFormatException n) {

			confirmCreateUser.setText("Los valores no corresponden");
			confirmCreateUser.setTextFill(Paint.valueOf("RED"));
		}
	}

	@FXML
	void btnEraseProductFromOrder(ActionEvent event) {
		if(tvListOrderProducts.getSelectionModel().getSelectedItem() != null) {
			OrderItem prod = tvListOrderProducts.getSelectionModel().getSelectedItem();
			int o = restaurant.searchOrderItem(prod.getProduct().getName());
			restaurant.getOrderItems().remove(o);
		}
	}

	@FXML
	void btnOpenSearchProduct(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("addProductToOrder-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			ObservableList<String> observableList = FXCollections.observableArrayList(restaurant.getProductsNames());
			cbProductsToOrder.setItems(observableList);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	@FXML
	void btnBackToOrders(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Orders-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@FXML
	void btnCloseCreateOrder(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Orders-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			restaurant.getOrderItems().clear();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	//Orders-page

	//Orders-page
	@FXML
	public void btnEraseOrder(ActionEvent event) {
		if(tvOrders.getSelectionModel().getSelectedItem() != null) {
			Order order = tvOrders.getSelectionModel().getSelectedItem();
			int pos = restaurant.searchOrder(order.getCode());
			restaurant.getOrders().remove(pos);
		}
	}

	public void loadTableViewOrders() {
		ObservableList<Order> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getOrders());
		tvOrders.setItems(observableList);
		tcOrderCode.setCellValueFactory(new PropertyValueFactory<Order,String>("code")); 
		tcOrderState.setCellValueFactory(new PropertyValueFactory<Order,String>("state")); 
		tcOrderClient.setCellValueFactory(new PropertyValueFactory<Order,String>("requestClient")); 
		tcOrderEmployee.setCellValueFactory(new PropertyValueFactory<Order,String>("deliverEmployee"));
		tcOrderDate.setCellValueFactory(new PropertyValueFactory<Order,String>("date"));
	}




	@FXML
	public void showOrderInfo(MouseEvent event) {
		if(tvOrders.getSelectionModel().getSelectedItem() != null) {

			//tv
			Order order = tvOrders.getSelectionModel().getSelectedItem();
			int pos = restaurant.searchOrder(order.getCode());

			System.out.println(pos + " " + order);
			loadTvShowProductsFromOrder(pos);
			//lv
			ObservableList<String> orderObs = FXCollections.observableArrayList(restaurant.getOrders().get(pos).getObservations());
			lvOrdersObs.setItems(orderObs);
			//lab
			labTotalPrice.setText(restaurant.getTotalPriceOfOrder(pos));
		}
	}



	void loadTvShowProductsFromOrder(int pos) {
		ObservableList<OrderItem> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getOrders().get(pos).getItems());

		tvOrderItems.setItems(observableList);
		tcOrderProduct.setCellValueFactory(new PropertyValueFactory<OrderItem,String>("productName")); 
		tcOrderProductAmount.setCellValueFactory(new PropertyValueFactory<OrderItem,Integer>("productAmount")); 
		tcOrderProductSize.setCellValueFactory(new PropertyValueFactory<OrderItem,String>("productSize")); 
		tcOrderProductPrice.setCellValueFactory(new PropertyValueFactory<OrderItem,Double>("productPrice"));


	}

	void loadTvProductsFromOrder() {
		if(restaurant.getOrderItems() != null) {
			ObservableList<OrderItem> observableList;
			observableList = FXCollections.observableArrayList(restaurant.getOrderItems());
			tvListOrderProducts.setItems(observableList);
			tcCreateOrderProduct.setCellValueFactory(new PropertyValueFactory<OrderItem,String>("productName")); 
			tcCreateOrderProductAmount.setCellValueFactory(new PropertyValueFactory<OrderItem,Integer>("productAmount"));
		}

	}
	@FXML
	void btnOpenAddOrder(ActionEvent event) {
		if(!restaurant.getOrderItems().isEmpty()) {
			try {
				FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("create-Order.fxml"));
				fxmlLoader.setController(this);
				Parent login;
				login = fxmlLoader.load();
				mainPane.getChildren().setAll(login);
				ObservableList<String> observableListStates = FXCollections.observableArrayList("SOLICITADO","ENVIADO","ENTREGADO","EN PROCESO");
				ObservableList<String> observableListClients = FXCollections.observableArrayList(restaurant.getClientsNames());
				ObservableList<String> observableListEmployees = FXCollections.observableArrayList(restaurant.getemployeesNames());
				cbOrderState.setItems(observableListStates);
				cbAbleClients.setItems(observableListClients);
				cbAbleEmployees.setItems(observableListEmployees);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}else {

			labConfirmAddOrderS1.setText("Se debe agregar por lo menos un producto");
			labConfirmAddOrderS1.setTextFill(Paint.valueOf("RED"));
		}
	}

	@FXML
	void btnOpenAddOrderS1(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("create-Order1.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTvProductsFromOrder();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@FXML
	void btnOpenModifyPage(ActionEvent event) {

	}

	@FXML
	public void btnOrdersToLoggedIn(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Logged-in-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@FXML
	public void btnOrdersPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Orders-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewOrders();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@FXML
	private TextField txtModifyUsersLastName;

	@FXML
	private Label labModifyUserID;

	@FXML
	private TextField txtModifyUsersNoo;

	@FXML
	private Label confirmModifyUser;

	@FXML
	public void modifyUser(ActionEvent event) {
		try {

			if(!txtModifyUsersUserName.getText().equals("") && !txtModifyUserPassword.getText().equals("") &&
					!txtModifyUsersName.getText().equals("") && !txtModifyUsersLastName.getText().equals("") &&
					!labModifyUserID.getText().equals("") && !txtModifyUsersNoo.getText().equals("")) {

				restaurant.updateUser(txtModifyUsersUserName.getText(), txtModifyUserPassword.getText(),
						txtModifyUsersName.getText(),txtModifyUsersLastName.getText(),
						labModifyUserID.getText(),Integer.parseInt(txtModifyUsersNoo.getText()) );

				confirmModifyUser.setText("Usuario modificado correctamente");
				confirmModifyUser.setTextFill(Paint.valueOf("Green"));

			}else {

				confirmModifyUser.setText("Se deben llenar todos los espacios");
				confirmModifyUser.setTextFill(Paint.valueOf("RED"));
			}
		}catch(NumberFormatException n) {

			confirmModifyUser.setText("Los valores no corresponden");
			confirmModifyUser.setTextFill(Paint.valueOf("RED"));
		}
	}

	@FXML
	public void addUser(ActionEvent event) {
		try {

			if(!txtUserUserName.getText().equals("") && !txtUserPassword.getText().equals("") &&
					!txtUserName.getText().equals("") && !txtUserLastName.getText().equals("") &&
					!txtUserID.getText().equals("") && !txtUserNoo.getText().equals("")) {

				boolean x = restaurant.createUser(txtUserName.getText(), txtUserLastName.getText(),
						txtUserID.getText(),Integer.parseInt(txtUserNoo.getText()),
						txtUserUserName.getText(),txtUserPassword.getText());
				if(x == false) {
					confirmCreateUser.setText("Usuario agregado correctamente");
					confirmCreateUser.setTextFill(Paint.valueOf("Green"));
				}else {
					confirmCreateUser.setText("El usuario tiene un id que ya existe");
					confirmCreateUser.setTextFill(Paint.valueOf("RED"));
				}

			}else {

				confirmCreateUser.setText("Se deben llenar todos los espacios");
				confirmCreateUser.setTextFill(Paint.valueOf("RED"));
			}
		}catch(NumberFormatException n) {

			confirmCreateUser.setText("Los valores no corresponden");
			confirmCreateUser.setTextFill(Paint.valueOf("RED"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	public void btnAtrasCrearUsers(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Users-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewUsers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void eraseUser(ActionEvent event) {
		if(tvUsers.getSelectionModel().getSelectedItem() != null) {
			System.out.println("entró al if");
			User user = tvUsers.getSelectionModel().getSelectedItem();

			int pos = restaurant.searchEmployee(user.getId());
			restaurant.getEmployes().remove(pos);

		}

	}

	@FXML
	public void createUser(ActionEvent event) {
		try {		
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("create-User.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void btnOpenModifyUser(ActionEvent event) {

		if(tvUsers.getSelectionModel().getSelectedItem() != null) {

			User user = tvUsers.getSelectionModel().getSelectedItem();

			try {
				FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("modify-User.fxml"));
				fxmlLoader.setController(this);
				Parent login;
				login = fxmlLoader.load();
				mainPane.getChildren().setAll(login);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txtModifyUsersName.setText(user.getName());
			txtModifyUsersLastName.setText(user.getLastName());
			labModifyUserID.setText(user.getId());
			txtModifyUsersUserName.setText(user.getUserName());
			txtModifyUsersNoo.setText(String.valueOf(user.getNumOfOrders()));
			txtModifyUserPassword.setText(user.getPassword());
		}else {
			//System.out.println("f");
		}
	}

	//Users page to logged in page
	@FXML
	public void btnUsersToLoggedInPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("logged-in-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void btnUsers(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Users-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewUsers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	public void modifyEmployee(ActionEvent event) {
		try {

			if(!txtModifyEmployeeName.getText().equals("") && !txtModifyEmployeeLastName.getText().equals("") &&
					!labModifyEmployeeId.getText().equals("") && !txtModifyNumOfOrders.getText().equals("")) {

				restaurant.updateEmployee(txtModifyEmployeeName.getText(), txtModifyEmployeeLastName.getText(),
						labModifyEmployeeId.getText(), Integer.parseInt(txtModifyNumOfOrders.getText()) );

				confirmModifyEmployee.setText("Empleado modificado correctamente");
				confirmModifyEmployee.setTextFill(Paint.valueOf("Green"));

			}else {

				confirmModifyEmployee.setText("Se deben llenar todos los espacios");
				confirmModifyEmployee.setTextFill(Paint.valueOf("RED"));
			}
		}catch(NumberFormatException n) {

			confirmModifyEmployee.setText("Los valores no corresponden");
			confirmModifyEmployee.setTextFill(Paint.valueOf("RED"));
		}
	}
	@FXML
	public void btnOpenModifyEmployee(ActionEvent event) {
		if(tvEmployees.getSelectionModel().getSelectedItem() != null) {

			Employee employee = tvEmployees.getSelectionModel().getSelectedItem();

			try {
				FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("modify-Employee.fxml"));
				fxmlLoader.setController(this);
				Parent login;
				login = fxmlLoader.load();
				mainPane.getChildren().setAll(login);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			txtModifyEmployeeName.setText(employee.getName());
			txtModifyEmployeeLastName.setText(employee.getLastName());
			labModifyEmployeeId.setText(employee.getId());
			txtModifyNumOfOrders.setText(String.valueOf(employee.getNumOfOrders()));


		}
	}

	@FXML
	public void eraseEmployee(ActionEvent event) {
		if(tvEmployees.getSelectionModel().getSelectedItem() != null) {

			Employee employee = tvEmployees.getSelectionModel().getSelectedItem();

			int pos = restaurant.searchEmployee(employee.getId());
			restaurant.getEmployes().remove(pos);

		}
	}


	@FXML
	private TextField txtModifyEmployeeName;

	@FXML
	private TextField txtModifyEmployeeLastName;

	@FXML
	private Label labModifyEmployeeId;

	@FXML
	private TextField txtModifyNumOfOrders;

	@FXML
	private Label confirmModifyEmployee;




	//product admin
	@FXML
	private ComboBox<String> cboxProducts;
	//product admin
	@FXML
	private ComboBox<String> cboxIngredientsOfProduct;
	//product admin
	@FXML
	private ComboBox<String> cboxSizeAndPriceOfProduct;
	//product admin
	@FXML
	private TextField txtPriceOfSizeOfProductAdmin;
	//product admin
	@FXML
	private TextField txtTypeOfProductAdmin;
	//product admin
	@FXML
	private TextField txtNameOfProductAdmin;
	//product admin
	@FXML
	private Label lblCreatedByProduct;
	//product admin
	@FXML
	private Label lblLastEditedByProduct;
	//product admin
	@FXML
	private TextField txtSizeOfProductAdmin;
	//product admin
	@FXML
	private Label lblAvialableIngredientProduct;
	//product admin
	@FXML
	private Label lblProductAdminWarnings;

	//add ingredient and size price
	@FXML
	private TextField txtAddPriceForProductAdmin;
	//add ingredient and size price
	@FXML
	private TextField txtAddSizeToProductAdmin;
	//add ingredient and size price
	@FXML
	private Button btnAddIngredientAndSizePriceToAdminProduct;
	//add ingredient and size price
	@FXML
	private ComboBox<String> cboxAddIngredientAdmin;
	//add ingredient and size price
	@FXML
	private Label lblAddIngredientAndSizePriceWarning;

	//product admin
	private int selectedProduct;

	//menu page
	@FXML
	private TextField txtSearchProduct;
	//menu page
	@FXML
	private Label lblNameOfProductMenu;
	//menu page
	@FXML
	private Label lblTypeOfProductMenu;
	//menu page
	@FXML
	private Label lblSizeAndPriceOfProductMenu;
	//menu page
	@FXML
	private Label lblIngredientOfProductMenu;
	//menu page
	@FXML
	private Label lblNUmberOfProducts;
	//menu page
	@FXML
	private Label lblWarningMenu;
	//menu page
	private int currentProductSelected;
	//search client
	@FXML
	private Label lblNameOfSearchedClient;
	//search client
	@FXML
	private Label lblLastNameOfSearchedClient;
	//search client
	@FXML
	private Label lblIdOfSearchedClient;
	//search client
	@FXML
	private Label lblAdressOfSearchedClient;
	//search client
	@FXML
	private Label lblPhoneOfSearchedClient;
	//search client
	@FXML
	private Label lblObservationsOfSearchedClient;
	//search client
	@FXML
	private Label lblWarningsForSearchClientPage;
	//search client
	@FXML
	private TextField txtIdForSearch;






	@FXML
	public void btnModifyClient(ActionEvent event) {
		try {
			String[]observations;
			if(!txtModifyClientName.getText().equals("") && !txtModifyClientLastName.getText().equals("")
					&& !txtModifyClientAdress.getText().equals("") && !txtModifyClientPhone.getText().equals("") ) {

				if(!txtModifyClientObservations.getText().equals("")) {
					observations = txtModifyClientObservations.getText().split(SEP);
				}else {
					observations = new String[1];
				}
				restaurant.updateClient(txtModifyClientName.getText(), txtModifyClientLastName.getText(),
						labModifyClientID.getText(),txtModifyClientAdress.getText(),
						txtModifyClientPhone.getText(), observations );

				labConfirmModifyClient.setText("Cliente modificado correctamente");
				labConfirmModifyClient.setTextFill(Paint.valueOf("Green"));


			}else {
				labConfirmModifyClient.setText("Se deben llenar todos los espacios");
				labConfirmModifyClient.setTextFill(Paint.valueOf("RED"));
			}
		}catch(NumberFormatException n) {

			labConfirmModifyClient.setText("Los valores no corresponden");
			labConfirmModifyClient.setTextFill(Paint.valueOf("RED"));
		}
	}
	@FXML
	public void addClient(ActionEvent event) {
		try {
			String[]observations;
			if(!txtClientName.getText().equals("") && !txtClientLastName.getText().equals("") &&
					!txtClientID.getText().equals("") && !txtClientAdress.getText().equals("") &&
					!txtClientPhone.getText().equals("") ) {

				if(!txtClientObservations.getText().equals("")) {
					observations = txtClientObservations.getText().split(SEP);
				}else {
					observations = new String[1];
				}

				boolean x = restaurant.createClient(txtClientName.getText(), txtClientLastName.getText(),
						txtClientID.getText(),txtClientAdress.getText(), txtClientPhone.getText(), observations );
				if(!x) {
					labConfirmClient.setText("Cliente agregado correctamente");
					labConfirmClient.setTextFill(Paint.valueOf("Green"));
				}else {
					labConfirmClient.setText("El cliente tiene un id que ya existe");
					labConfirmClient.setTextFill(Paint.valueOf("RED"));
				}

			}else {

				labConfirmClient.setText("Se deben llenar todos los espacios");
				labConfirmClient.setTextFill(Paint.valueOf("RED"));
			}
		}catch(NumberFormatException n) {

			labConfirmModifyClient.setText("Los valores no corresponden");
			labConfirmModifyClient.setTextFill(Paint.valueOf("RED"));
		}

	}

	//create-Client
	@FXML
	public void showClientInfo(MouseEvent event) {
		if(tvClients.getSelectionModel().getSelectedItem() != null) {
			Client client = tvClients.getSelectionModel().getSelectedItem();
			int pos = restaurant.searchClient(client.getId());
			ObservableList<String> clientObs = FXCollections.observableArrayList(restaurant.getClients().get(pos).getObservations());
			lvClients.setItems(clientObs);
		}
	}

	//client page to search client page
	@FXML
	public void btnSearchClient(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("searchClient-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			mainPane.getChildren().setAll(login);
			if(!restaurant.getClients().isEmpty()) {
				restaurant.bubbleSortForClients();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//search client page
	@FXML
	public void bntSearchForId(ActionEvent event) {
		int found= restaurant.binarySearchForClients(txtIdForSearch.getText());
		lblTimeOfSearch.setText(""+restaurant.getTime());
		if(found==-1) {
			lblWarningsForSearchClientPage.setText("No se encontro un cliente con esta id");
			lblWarningsForSearchClientPage.setTextFill(Paint.valueOf("RED"));
		}else {
			lblNameOfSearchedClient.setText(restaurant.getClients().get(found).getName());
			lblLastNameOfSearchedClient.setText(restaurant.getClients().get(found).getLastName());
			lblIdOfSearchedClient.setText(restaurant.getClients().get(found).getId());
			lblAdressOfSearchedClient.setText(restaurant.getClients().get(found).getAdress());
			lblPhoneOfSearchedClient.setText(restaurant.getClients().get(found).getPhone());
			lblObservationsOfSearchedClient.setText(restaurant.getClients().get(found).observationsToString());
		}
	}
	//search client page
	@FXML
	public void btnBackToClientPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Clients-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			if(!restaurant.getClients().isEmpty()) {
				restaurant.bubbleSortForClients();
			}
			loadTableViewClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void btnImportClients(ActionEvent event) {
		try {
			restaurant.importClients(currentUser);
			restaurant.saveData();
			if(!restaurant.getClients().isEmpty()) {
				restaurant.bubbleSortForClients();
			}
			loadTableViewClient();
		}catch (IOException e) {
			// TODO: handle exception
		}
	}



	@FXML
	public void openModifyClient(ActionEvent event) {
		if(tvClients.getSelectionModel().getSelectedItem() != null) {

			Client client = tvClients.getSelectionModel().getSelectedItem();

			String ModObs = "";
			for(int i = 0; i < client.getObservations().size(); i++) {
				ModObs += client.getObservations().get(i) + "\n";
			}

			try {
				FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("modify-Client.fxml"));
				fxmlLoader.setController(this);
				Parent login;
				login = fxmlLoader.load();
				mainPane.getChildren().setAll(login);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txtModifyClientName.setText(client.getName());
			txtModifyClientLastName.setText(client.getLastName());
			labModifyClientID.setText(client.getId());
			txtModifyClientAdress.setText(client.getAdress());
			txtModifyClientPhone.setText(client.getPhone());
			txtModifyClientObservations.setText(ModObs);


		}
	}

	@FXML
	public void eraseClient(ActionEvent event) {
		if(tvClients.getSelectionModel().getSelectedItem() != null) {

			Client client = tvClients.getSelectionModel().getSelectedItem();

			int pos = restaurant.searchClient(client.getId());
			restaurant.getClients().remove(pos);

		}
	}

	@FXML
	public void createClient(ActionEvent event) {
		try {		
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("create-Client.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void addEmployee(ActionEvent event) {
		try {

			if(!txtEmployeeName.getText().equals("") && !txtEmployeeLastName.getText().equals("") &&
					!txtEmployeeId.getText().equals("") && !txtNumOfOrders.getText().equals("")) {

				boolean x = restaurant.createEmployee(txtEmployeeName.getText(), txtEmployeeLastName.getText(),
						txtEmployeeId.getText(), Integer.parseInt(txtNumOfOrders.getText()) );

				if(x == false) {
					confirmEmployee.setText("Empleado agregado correctamente");
					confirmEmployee.setTextFill(Paint.valueOf("Green"));
				}else {
					confirmEmployee.setText("El empleado tiene un id que ya existe");
					confirmEmployee.setTextFill(Paint.valueOf("RED"));
				}

			}else {

				confirmEmployee.setText("Se deben llenar todos los espacios");
				confirmEmployee.setTextFill(Paint.valueOf("RED"));
			}
		}catch(NumberFormatException n) {

			confirmEmployee.setText("Los valores no corresponden");
			confirmEmployee.setTextFill(Paint.valueOf("RED"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}



	//create-Employee
	@FXML
	public void btnAtrasCrearEmpleados(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Employee-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewEmployees();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	//admin-page
	@FXML
	public void btnAtras(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("main-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//admin-page
	@FXML
	public void btnLogIn(ActionEvent event) {
		if(restaurant.logInAdmin(txtUsuario.getText(), txtPassword.getText())) {
			currentUser=txtUsuario.getText();
			try {
				FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("logged-in-page.fxml"));
				fxmlLoader.setController(this);
				Parent login;
				login = fxmlLoader.load();
				mainPane.getChildren().setAll(login);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			lblAdminPagewarning.setText("El usuario o contraseña no es correcto");
			lblAdminPagewarning.setTextFill(Paint.valueOf("Red"));
		}
	}
	@FXML
	public void btnDeleteSavedFiles(ActionEvent event) {
		try {
			restaurant.clearData();
			restaurant.loadClientsData();
			restaurant.loadEmployeesData();
			restaurant.loadIngredientsData();
			restaurant.loadProductsData();
			restaurant.saveData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//main-page
	private Thread time;
	public void loadMainPage(){
		try {
			restaurant.loadIngredientsData();
			restaurant.loadEmployeesData();
			restaurant.loadProductsData();
			restaurant.loadClientsData();
			restaurant.saveData();
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("main-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			lbldateAndTime.setText(LocalDateTime.now().getDayOfMonth()+"/"+LocalDateTime.now().getMonthValue()+"/"+LocalDateTime.now().getYear()  +" "+LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+":"+LocalTime.now().getSecond() );
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		time = new Thread(new Runnable() {
			@Override
			public void run() {
				for(;;){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							lbldateAndTime.setText(LocalDateTime.now().getDayOfMonth()+"/"+LocalDateTime.now().getMonthValue()+"/"+LocalDateTime.now().getYear()  +" "+LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+":"+LocalTime.now().getSecond() );
						}
					});
				}
			}
		});
		time.start();
	}

	//main-page
	@FXML
	public void btnAdmin(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("admin-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			time.interrupt();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//main-page
	@FXML
	public void btnMenu(ActionEvent event) {
		currentProductSelected=0;
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("menu-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			time.interrupt();
			if(restaurant.getProducts().isEmpty()) {
				lblWarningMenu.setText("No hay productos");
				lblWarningMenu.setTextFill(Paint.valueOf("Red"));
			}else {
				restaurant.resetMenuProducts();
				lblNameOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getName());
				lblTypeOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getType());
				lblSizeAndPriceOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).sizeAndPriceToString());
				lblIngredientOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).ingredientsToString());
				lblNUmberOfProducts.setText((currentProductSelected+1)+"/"+(restaurant.getMenuProducts().size()));
			}
			lblSizeAndPriceOfProductMenu.setWrapText(true);
			lblIngredientOfProductMenu.setWrapText(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	//menu page
	@FXML
	public void btnBackProduct(ActionEvent event) {
		try {
			currentProductSelected--;
			lblNameOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getName());
			lblTypeOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getType());
			lblSizeAndPriceOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).sizeAndPriceToString());
			lblIngredientOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).ingredientsToString());
			lblNUmberOfProducts.setText((currentProductSelected+1)+"/"+(restaurant.getMenuProducts().size()));
		}catch(NullPointerException e) {
			lblWarningMenu.setText("Este es el primer producto, no hay anterior");
			lblWarningMenu.setTextFill(Paint.valueOf("Red"));
			currentProductSelected++;
		}catch(IndexOutOfBoundsException e) {
			lblWarningMenu.setText("Este es el primer producto, no hay anterior");
			lblWarningMenu.setTextFill(Paint.valueOf("Red"));
			currentProductSelected++;
		}

	}
	//menu page
	@FXML
	public void btnMenutoMain(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("main-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//menu page
	@FXML
	public void btnNextProduct(ActionEvent event) {
		try {
			currentProductSelected++;
			lblNameOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getName());
			lblTypeOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getType());
			lblSizeAndPriceOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).sizeAndPriceToString());
			lblIngredientOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).ingredientsToString());
			lblNUmberOfProducts.setText((currentProductSelected+1)+"/"+(restaurant.getMenuProducts().size()));
		}catch(NullPointerException e) {
			lblWarningMenu.setText("Este es el ultimo producto");
			lblWarningMenu.setTextFill(Paint.valueOf("Red"));
			currentProductSelected--;
		}catch(IndexOutOfBoundsException e) {
			lblWarningMenu.setText("Este es el ultimo producto");
			lblWarningMenu.setTextFill(Paint.valueOf("Red"));
			currentProductSelected--;
		}
	}
	//menu page
	@FXML
	public void btnSearchProduct(ActionEvent event) {
		currentProductSelected=0;
		restaurant.searchMenuProducts(txtSearchProduct.getText());
		if(restaurant.getMenuProducts().isEmpty()) {
			lblWarningMenu.setText("No hay productos relacionados con "+txtSearchProduct.getText());
			lblWarningMenu.setTextFill(Paint.valueOf("Red"));	
		}else {
			lblNameOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getName());
			lblTypeOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getType());
			lblSizeAndPriceOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).sizeAndPriceToString());
			lblIngredientOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).ingredientsToString());
			lblNUmberOfProducts.setText((currentProductSelected+1)+"/"+(restaurant.getMenuProducts().size()));
		}

	}

	//menu page
	@FXML
	public void btnResetSearch(ActionEvent event) {
		restaurant.resetMenuProducts();
		txtSearchProduct.clear();
		if(restaurant.getProducts().isEmpty()) {
			lblWarningMenu.setText("No hay productos");
			lblWarningMenu.setTextFill(Paint.valueOf("Red"));
		}else {
			restaurant.resetMenuProducts();
			lblNameOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getName());
			lblTypeOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).getType());
			lblSizeAndPriceOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).sizeAndPriceToString());
			lblIngredientOfProductMenu.setText(restaurant.getMenuProducts().get(currentProductSelected).ingredientsToString());
			lblNUmberOfProducts.setText((currentProductSelected+1)+"/"+(restaurant.getMenuProducts().size()));
		}
		lblSizeAndPriceOfProductMenu.setWrapText(true);

	}



	//Logged-in-page
	@FXML
	public void btnEmpleados(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Employee-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewEmployees();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//Logged-in-page
	@FXML
	public void btnClients(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Clients-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			if(!restaurant.getClients().isEmpty()) {
				restaurant.bubbleSortForClients();
			}
			loadTableViewClient();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//tv Users-page
	public void loadTableViewUsers() {
		ObservableList<User> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getUsers());
		tvUsers.setItems(observableList);
		tcUserName.setCellValueFactory(new PropertyValueFactory<User,String>("name")); 
		tcUserLastName.setCellValueFactory(new PropertyValueFactory<User,String>("lastName")); 
		tcUserID.setCellValueFactory(new PropertyValueFactory<User,String>("id"));
		tcUserNoo.setCellValueFactory(new PropertyValueFactory<User,Integer>("numOfOrders"));
		tcUserUserName.setCellValueFactory(new PropertyValueFactory<User,String>("userName"));

	}


	//tv Clients-page
	public void loadTableViewClient() {
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getClients());
		tvClients.setItems(observableList);
		tcClientName.setCellValueFactory(new PropertyValueFactory<Client,String>("name")); 
		tcClientLastName.setCellValueFactory(new PropertyValueFactory<Client,String>("lastName")); 
		tcClientID.setCellValueFactory(new PropertyValueFactory<Client,String>("id"));
		tcClientAdress.setCellValueFactory(new PropertyValueFactory<Client,String>("adress"));
		tcClientPhone.setCellValueFactory(new PropertyValueFactory<Client,Integer>("phone"));
	}

	@FXML
	public void btnReturnToLoggedInPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("logged-in-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Employee to logged in page
	@FXML
	public void btnBackToLoggedInPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("logged-in-page.fxml"));

			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);

			loadTableViewEmployees();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//ingredient-page
	@FXML
	public void btnAddIngredient(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("addIngredient-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewIngredient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//ingredient-page
	@FXML
	public void btnImportIngredients(ActionEvent event) {
		try {
			restaurant.importIngredientData(currentUser);
			loadTableViewIngredient();
			restaurant.saveData();
		}catch(IOException e) {
			lblIngredientPageWarning.setText("No se encontro el archivo de ingredientes");
			lblIngredientPageWarning.setTextFill(Paint.valueOf("Red"));
		}
	}

	//ingredient-page to logged-in-page
	@FXML
	public void btnGoToLoggedInPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("logged-in-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//addIngredient-page
	@FXML
	public void btnAddINgredient(ActionEvent event) {
		boolean avialable=false;
		if(rbtnAvailable.isSelected() || rbtnNotAvailable.isSelected()) {
			if(rbtnAvailable.isSelected()) {
				avialable=true;
			}
			try {
				if(!restaurant.addIngredient(txtNameIgredient.getText(), avialable)) {
					restaurant.getIngredients().get(restaurant.getIngredients().size()-1).setCreatedBy(currentUser);
					restaurant.getIngredients().get(restaurant.getIngredients().size()-1).setLastEditedBy(currentUser);
					lblAddIngredient.setText("Se agregado ingrediente correctamente");
					lblAddIngredient.setTextFill(Paint.valueOf("Green"));
				}else {
					lblAddIngredient.setText("Ya hay un ingrediente con este nombre");
					lblAddIngredient.setTextFill(Paint.valueOf("Red"));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			lblAddIngredient.setText("Por favor llene todos los campos");
			lblAddIngredient.setTextFill(Paint.valueOf("Red"));
		}
	}

	//addIngredient-page to ingredient-page
	@FXML
	public void btnBackToIngredient(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("ingredient-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewIngredient();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Logged-in-page
	@FXML
	public void btnLoadIngredient(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("ingredient-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewIngredient();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//ingredient-page
	@FXML
	public void btnOrganizeIngredients(ActionEvent event) {
		restaurant.sortIngredients();
		loadTableViewIngredient();
	}

	//Logged-in-page
	public void loadTableViewEmployees() {
		if(!restaurant.getEmployes().isEmpty()) {
			restaurant.sortEmployee();
		}
		ObservableList<Employee> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getEmployes());
		tvEmployees.setItems(observableList);
		tcName.setCellValueFactory(new PropertyValueFactory<Employee,String>("name")); 
		tcLastName.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName")); 
		tcId.setCellValueFactory(new PropertyValueFactory<Employee,String>("id"));
		tcNumOfOrders.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("numOfOrders"));
	}

	//ingredient
	public void loadTableViewIngredient() {
		ObservableList<Ingredient> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getIngredients());
		tvIngredients.setItems(observableList);
		tcIngredient.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("ingredients")); 
		tcAvialable.setCellValueFactory(new PropertyValueFactory<Ingredient,Boolean>("avialable")); 
	}

	//ingredient to admin ingredient
	@FXML
	public void btnAdminIngredients(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("admin-ingredients.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			for(int c=0;c<restaurant.getIngredients().size();c++) {
				cboxIngredients.getItems().add(restaurant.getIngredients().get(c).getIngredients());
			}
			lblIngredientCreatedBy.setText("");
			lblIngredientLastEditedBy.setText("");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void btnAddEmployee(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("create-Employee.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//admin ingredient
	@FXML
	public void btnAdminIngredientsToIngredients(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("ingredient-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewIngredient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//admin ingredient
	@FXML
	public void btnDeleteIngredient(ActionEvent event) {
		boolean found = false;
		for(int c=0;c<restaurant.getProducts().size() && !found;c++) {
			for(int i=0; i<restaurant.getProducts().get(c).getIngredients().size() && !found;i++) {

				if(restaurant.getProducts().get(c).getIngredients().get(i).getIngredients().equals(restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).getIngredients())) {
					found=true;
				}
			}
		}
		if(found) {
			lblAdminIngredientWarning.setText("No se puede borrar el ingrediente porque un producto lo esta usando");
			lblAdminIngredientWarning.setTextFill(Paint.valueOf("Red"));
		}else {
			restaurant.getIngredients().remove(cboxIngredients.getSelectionModel().getSelectedIndex());
			cboxIngredients.getItems().clear();

			for(int c=0;c<restaurant.getIngredients().size();c++) {
				cboxIngredients.getItems().add(restaurant.getIngredients().get(c).getIngredients());
			}
		}
	}

	//admin ingredient
	@FXML
	public void btnSaveIngredient(ActionEvent event) {
		//poner if para que no saque error

		boolean found = false;
		for(int c=0;c<restaurant.getProducts().size() && !found;c++) {
			for(int i=0; i<restaurant.getProducts().get(c).getIngredients().size() && !found;i++) {
				if(restaurant.getProducts().get(c).getIngredients().get(i).getIngredients().equals(restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).getIngredients())) {
					restaurant.getProducts().get(c).getIngredients().get(i).setAvialable(rbtnAdminIngredientsAvielable.isSelected());
					restaurant.getProducts().get(c).getIngredients().get(i).setLastEditedBy(currentUser);


				}
			}
		}
		restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).setAvialable(rbtnAdminIngredientsAvielable.isSelected());
		restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).setLastEditedBy(currentUser);
	}

	//admin ingredient
	@FXML
	public void cBoxChangeIngredient(ActionEvent event) {
		try{
			lblNameIngredient.setText(restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).getIngredients());
			lblIngredientCreatedBy.setText(restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).getCreatedBy());
			lblIngredientLastEditedBy.setText(restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).getLastEditedBy());
			if(restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).isAvialable()) {
				rbtnAdminIngredientsAvielable.setSelected(true);
			}else {
				rbtnAdminIngredientsNotAvailable.setSelected(true);
			}
		}catch(ArrayIndexOutOfBoundsException a){
			lblNameIngredient.setText("El ingrediente fue borrrado");
			lblIngredientCreatedBy.setText("");
			lblIngredientLastEditedBy.setText("");
			rbtnAdminIngredientsAvielable.setSelected(false);
			rbtnAdminIngredientsNotAvailable.setSelected(false);
		}
	}

	//addProduct-page
	@FXML
	public void btnAddProduct(ActionEvent event) {
		lblAddProductWarning.setText("");
		if(txtNameOfProduct.getText().equals("") || txtTypeOfProduct.getText().equals("") || restaurant.getIngredientsForProduct().isEmpty() || restaurant.getSizeAndPrice().isEmpty()) {
			lblAddProductWarning.setText("Llene todo los campos");
			lblAddProductWarning.setTextFill(Paint.valueOf("Red"));
		}else {
			try {
				if(!restaurant.addProduct(txtNameOfProduct.getText() ,txtTypeOfProduct.getText())) {
					lblAddProductWarning.setText("Se creo el producto: "+txtNameOfProduct.getText()+" con exito");
					lblAddProductWarning.setTextFill(Paint.valueOf("Green"));
					lblSizeAndPriceOfProducts.setText("");
					lblIngredientsForProduct.setText("");
					restaurant.getProducts().get(restaurant.getProducts().size()-1).setCreatedBy(currentUser);
					restaurant.getProducts().get(restaurant.getProducts().size()-1).setLastEditedBy(currentUser);
				}else {
					lblAddProductWarning.setText("Ya hay un producto: "+txtNameOfProduct.getText());
					lblAddProductWarning.setTextFill(Paint.valueOf("Red"));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//addProduct-page
	@FXML
	public void btnClearSizeAndPrice(ActionEvent event) {
		restaurant.resetsizeAndPriceArray();
		lblSizeAndPriceOfProducts.setText("");
		lblAddProductWarning.setText("Se borraron los tamaños del producto");
		lblAddProductWarning.setTextFill(Paint.valueOf("Green"));
		txtSizeOfProduct.clear();
		txtPriceOfSizeOfProduct.clear();
	}

	//addProduct-page to product-page
	@FXML
	public void btnAddProductToProduct(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("product-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			restaurant.resetProductIngredientArray();
			restaurant.resetsizeAndPriceArray();
			loadTableViewProduct();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//addProduct-page
	@FXML
	public void btnClearIngredientsForProduct(ActionEvent event) {
		restaurant.resetProductIngredientArray();
		lblIngredientsForProduct.setText("");
		lblAddProductWarning.setText("Se borraron los ingredientes del producto \n test");
		lblAddProductWarning.setTextFill(Paint.valueOf("Green"));
	}

	//addProduct-page
	@FXML
	public void btnAddSizeAndPriceForProduct(ActionEvent event) {
		lblAddProductWarning.setText("");
		if(txtSizeOfProduct.getText().equals("")) {
			lblAddProductWarning.setText("Se debe llenar el campo de tamaño");
			lblAddProductWarning.setTextFill(Paint.valueOf("Red"));
			txtSizeOfProduct.clear();
			txtPriceOfSizeOfProduct.clear();
		}else {
			try {
				if(!restaurant.productCheckDoubleSize(txtSizeOfProduct.getText())) {
					restaurant.sizeAndPriceForProduct(txtSizeOfProduct.getText(), Double.parseDouble(txtPriceOfSizeOfProduct.getText()));
					lblSizeAndPriceOfProducts.setText(lblSizeAndPriceOfProducts.getText()+" "+restaurant.getSizeAndPrice().get(restaurant.getSizeAndPrice().size()-1).getSize()+" con precio de: "+restaurant.getSizeAndPrice().get(restaurant.getSizeAndPrice().size()-1).getPrice()+" , ");
					txtSizeOfProduct.clear();
					txtPriceOfSizeOfProduct.clear();
				}else {
					lblAddProductWarning.setText("Este tamaño ya fue añadido");
					lblAddProductWarning.setTextFill(Paint.valueOf("Red"));
				}
			}catch (NumberFormatException e) {
				lblAddProductWarning.setText("El precio debe ser un numero");
				lblAddProductWarning.setTextFill(Paint.valueOf("Red"));
			}
		}
	}

	//addProduct-page
	@FXML
	public void btnIngredientForProduct(ActionEvent event) {
		lblAddProductWarning.setText("");
		if(cboxIngredientsForProduct.getSelectionModel().getSelectedIndex()!=-1) {
			if(!restaurant.productCheckDoubleIngredient(restaurant.getIngredients().get(cboxIngredientsForProduct.getSelectionModel().getSelectedIndex()).getIngredients())) {
				restaurant.ingredientForProduct(restaurant.getIngredients().get(cboxIngredientsForProduct.getSelectionModel().getSelectedIndex()));

				lblIngredientsForProduct.setText(lblIngredientsForProduct.getText()+" "+restaurant.getIngredientsForProduct().get(restaurant.getIngredientsForProduct().size()-1).getIngredients()+" , ");
			}else {
				lblAddProductWarning.setText("Este ingrediente ya fue añadido");
				lblAddProductWarning.setTextFill(Paint.valueOf("Red"));
			}
		}else {
			lblAddProductWarning.setText("Seleccione un ingrediente");
			lblAddProductWarning.setTextFill(Paint.valueOf("Red"));
		}
	}

	//logged in page to products page 
	@FXML
	public void btnLoadProducts(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("product-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewProduct();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//product page
	@FXML
	public void btnImportProductData(ActionEvent event) {
		try {
			restaurant.importProductData(currentUser);
			loadTableViewProduct();
			restaurant.saveData();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	//product page to add product page
	@FXML
	public void btnLoadAddProduct(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("addProduct-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			for(int c=0;c<restaurant.getIngredients().size();c++) {
				cboxIngredientsForProduct.getItems().add(restaurant.getIngredients().get(c).getIngredients());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//product page to logged in page
	@FXML
	public void btnProductToLoggedInPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("logged-in-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//product load tv
	public void loadTableViewProduct() {
		if(!restaurant.getProducts().isEmpty())
			restaurant.selectionSort();
		ObservableList<Product> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getProducts());
		tvProducts.setItems(observableList);
		tcNameOfProduct.setCellValueFactory(new PropertyValueFactory<Product,String>("name")); 
		tcTypeOfProduct.setCellValueFactory(new PropertyValueFactory<Product,String>("type")); 
	}

	//products to admin products
	@FXML
	public void btnProductsToAdminProducts(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("admin-product-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			for(int c=0;c<restaurant.getProducts().size();c++) {
				cboxProducts.getItems().add(restaurant.getProducts().get(c).getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//product admin
	@FXML
	public void btnCboxIngredientsOfProduct(ActionEvent event) {
		if(cboxIngredientsOfProduct.getSelectionModel().getSelectedIndex()!=-1) {
			if(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getIngredients().get(cboxIngredientsOfProduct.getSelectionModel().getSelectedIndex()).isAvialable()) {
				lblAvialableIngredientProduct.setText("Esta disponible");
			}else {
				lblAvialableIngredientProduct.setText("No esta disponible");
			}

		}
	}
	//product admin
	@FXML
	public void btnCboxProducts(ActionEvent event) {
		cboxIngredientsOfProduct.getItems().clear();
		cboxSizeAndPriceOfProduct.getItems().clear();
		if(cboxProducts.getSelectionModel().getSelectedIndex()!=-1) {
			txtNameOfProductAdmin.setText(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getName());
			txtTypeOfProductAdmin.setText(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getType());
			lblLastEditedByProduct.setText("Ultimo cambio por: "+restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getLastEditedBy());
			lblCreatedByProduct.setText("Creado por: "+restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getCreatedBy());
			for(int c=0;c<restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getIngredients().size();c++) {
				cboxIngredientsOfProduct.getItems().add(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getIngredients().get(c).getIngredients());
			}
			for(int c=0;c<restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().size();c++) {
				cboxSizeAndPriceOfProduct.getItems().add(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(c).getSize());
			}
		}
	}
	//product admin
	@FXML
	public void btnCboxSizeAndPriceOfProduct(ActionEvent event) {
		if(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()!=-1) {
			txtSizeOfProductAdmin.setText(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).getSize());
			txtPriceOfSizeOfProductAdmin.setText(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).getPrice()+"");
		}
	}
	//product admin
	@FXML
	public void btnChangePriceOfSizeOfProduct(ActionEvent event) {
		if(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()!=-1) {
			try {
				if(!txtSizeOfProduct.getText().equals("")) {
					restaurant.getProducts().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).setSize(txtSizeOfProduct.getText());
				}
				if(!txtPriceOfSizeOfProductAdmin.getText().equals("")) {
					restaurant.getProducts().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).setPrice(Double.parseDouble(txtPriceOfSizeOfProductAdmin.getText()));
				}
				txtSizeOfProductAdmin.setText(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).getSize());
				txtPriceOfSizeOfProductAdmin.setText(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex()).getPrice()+"");
			}catch(NumberFormatException e) {
				lblProductAdminWarnings.setText("inserte un numero valido");
				lblProductAdminWarnings.setTextFill(Paint.valueOf("Red"));
			}
		}
	}
	//product admin
	@FXML
	public void btnDeleteIngredientFromProduct(ActionEvent event) {
		if(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getIngredients().size()==1) {
			lblProductAdminWarnings.setText("El producto debe tener por lo menos 1 ingrediente");
			lblProductAdminWarnings.setTextFill(Paint.valueOf("Red"));
		}else {
			restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getIngredients().remove(cboxIngredientsOfProduct.getSelectionModel().getSelectedIndex());
			cboxIngredientsOfProduct.getItems().clear();
			lblProductAdminWarnings.setText("Se borro el ingrediente");
			lblProductAdminWarnings.setTextFill(Paint.valueOf("Green"));
			lblAvialableIngredientProduct.setText("Disponibilidad");
			for(int c=0;c<restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getIngredients().size();c++) {
				cboxIngredientsOfProduct.getItems().add(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getIngredients().get(c).getIngredients());
			}
		}
	}

	//product admin
	@FXML
	public void btnDeleteSizeAndPrice(ActionEvent event) {
		if(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().size()==1) {
			lblProductAdminWarnings.setText("El producto debe tener por lo menos 1 tamaño");
			lblProductAdminWarnings.setTextFill(Paint.valueOf("Red"));
		}else{
			restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().remove(cboxSizeAndPriceOfProduct.getSelectionModel().getSelectedIndex());
			cboxSizeAndPriceOfProduct.getItems().clear();
			for(int c=0;c<restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().size();c++) {
				cboxSizeAndPriceOfProduct.getItems().add(restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).getSizeAndPrice().get(c).getSize());
			}
			txtSizeOfProductAdmin.clear();
			txtPriceOfSizeOfProductAdmin.clear();
		}
	}
	//product admin
	@FXML
	public void btnDeleteProductAdmin(ActionEvent event) {
		restaurant.getProducts().remove(cboxProducts.getSelectionModel().getSelectedIndex());
		txtSizeOfProductAdmin.clear();
		txtPriceOfSizeOfProductAdmin.clear();
		txtNameOfProductAdmin.clear();
		txtTypeOfProductAdmin.clear();
		cboxIngredientsOfProduct.getItems().clear();
		cboxSizeAndPriceOfProduct.getItems().clear();
		cboxProducts.getItems().clear();
		for(int c=0;c<restaurant.getProducts().size();c++) {
			cboxProducts.getItems().add(restaurant.getProducts().get(c).getName());
		}
		lblAvialableIngredientProduct.setText("Disponibilidad");
		lblProductAdminWarnings.setText("Se borro el producto");
		lblProductAdminWarnings.setTextFill(Paint.valueOf("Green"));
		lblLastEditedByProduct.setText("Ultimo cambio por: ");
		lblCreatedByProduct.setText("Creado por: ");
	}

	@FXML
	public void btnSaveChangesAdmin(ActionEvent event) {
		if(!txtNameOfProductAdmin.getText().equals("")) {
			restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).setName(txtNameOfProductAdmin.getText());
		}
		if(!txtTypeOfProductAdmin.getText().equals("")) {
			restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).setType(txtTypeOfProductAdmin.getText());
		}
		restaurant.getProducts().get(cboxProducts.getSelectionModel().getSelectedIndex()).setLastEditedBy(currentUser+"a");
		cboxProducts.getItems().clear();
		for(int c=0;c<restaurant.getProducts().size();c++) {
			cboxProducts.getItems().add(restaurant.getProducts().get(c).getName());
		}
		txtSizeOfProductAdmin.clear();
		txtPriceOfSizeOfProductAdmin.clear();
		txtNameOfProductAdmin.clear();
		txtTypeOfProductAdmin.clear();
		cboxIngredientsOfProduct.getItems().clear();
		cboxSizeAndPriceOfProduct.getItems().clear();
		lblAvialableIngredientProduct.setText("Disponibilidad");
		lblProductAdminWarnings.setText("Se guardo el producto");
		lblProductAdminWarnings.setTextFill(Paint.valueOf("Green"));
		lblLastEditedByProduct.setText("Ultimo cambio por: ");
		lblCreatedByProduct.setText("Creado por: ");

	}


	//product admin to product
	@FXML
	public void btnAdminProductToProduct(ActionEvent event) {

		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("product-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewProduct();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//product admin to product
	@FXML
	public void btnAddIngredientAndSizePriceToProductPage(ActionEvent event) {
		selectedProduct=cboxProducts.getSelectionModel().getSelectedIndex();
		if(selectedProduct!=-1) {
			try {
				FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("addIngredientAndSizePrice-page.fxml"));
				fxmlLoader.setController(this);
				Parent login;
				login = fxmlLoader.load();
				mainPane.getChildren().setAll(login);
				for(int c=0;c<restaurant.getIngredients().size();c++) {
					cboxAddIngredientAdmin.getItems().add(restaurant.getIngredients().get(c).getIngredients());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			lblProductAdminWarnings.setText("seleccione un producto por favor");
			lblProductAdminWarnings.setTextFill(Paint.valueOf("Red"));
		}
	}

	//add ingredient and size price
	@FXML
	public void btnAddIngredientToProduct(ActionEvent event) {
		boolean found= false;
		try {
			for(int c=0;c<restaurant.getProducts().get(selectedProduct).getIngredients().size()&&!found;c++) {
				if(restaurant.getProducts().get(selectedProduct).getIngredients().get(c).getIngredients().equals(restaurant.getIngredients().get(cboxAddIngredientAdmin.getSelectionModel().getSelectedIndex()).getIngredients())){
					found =true;
				}
			}
			if(found) {

				lblAddIngredientAndSizePriceWarning.setText("El producto ya tiene este ingrediente");
				lblAddIngredientAndSizePriceWarning.setTextFill(Paint.valueOf("Red"));
			}else {
				restaurant.getProducts().get(selectedProduct).getIngredients().add(restaurant.getIngredients().get(cboxAddIngredientAdmin.getSelectionModel().getSelectedIndex()));
				lblAddIngredientAndSizePriceWarning.setText("Se añadio el ingrediente al producto");
				lblAddIngredientAndSizePriceWarning.setTextFill(Paint.valueOf("Green"));
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			lblAddIngredientAndSizePriceWarning.setText("Seleccione un ingrediente");
			lblAddIngredientAndSizePriceWarning.setTextFill(Paint.valueOf("Red"));
		}
	}
	//add ingredient and size price
	@FXML
	public void btnAddIngredientAndSizePriceToAdminProduct(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("admin-product-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			for(int c=0;c<restaurant.getProducts().size();c++) {
				cboxProducts.getItems().add(restaurant.getProducts().get(c).getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@FXML
	public void btnBackToMainPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("main-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//add ingredient and size price
	@FXML
	public void btnAddSizeAndPriceToProduct(ActionEvent event) {
		if(txtPriceOfSizeOfProductAdmin.getText().equals("") || txtSizeOfProductAdmin.getText().equals("")) {
			lblAddIngredientAndSizePriceWarning.setText("Llene todos los campos para el tamaño");
			lblAddIngredientAndSizePriceWarning.setTextFill(Paint.valueOf("Red"));
		}else {
			try {

				boolean found= false;

				for(int c=0;c<restaurant.getProducts().get(selectedProduct).getSizeAndPrice().size()&&!found;c++) {
					if(restaurant.getProducts().get(selectedProduct).getSizeAndPrice().get(c).getSize().equals(txtAddSizeToProductAdmin.getText())){
						found =true;
					}
				}

				if(found) {
					lblAddIngredientAndSizePriceWarning.setText("Este producto ya tiene este tamaño");
					lblAddIngredientAndSizePriceWarning.setTextFill(Paint.valueOf("Red"));
				}else {
					restaurant.getProducts().get(selectedProduct).addSizeAndPrice(new SizeAndPrice(txtAddSizeToProductAdmin.getText(),Double.parseDouble(txtAddSizeToProductAdmin.getText())));
					lblAddIngredientAndSizePriceWarning.setText("Se añadio un tamaño");
					lblAddIngredientAndSizePriceWarning.setTextFill(Paint.valueOf("Green"));
				}

			}catch (NumberFormatException e) {
				lblAddIngredientAndSizePriceWarning.setText("Entre un numero valido");
				lblAddIngredientAndSizePriceWarning.setTextFill(Paint.valueOf("Red"));
			}
		}

	}




}



