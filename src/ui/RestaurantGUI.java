package ui;

import java.io.IOException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import model.Client;
import model.Employee;
import model.Ingredient;
import model.Restaurant;
import model.SizeAndPrice;

public class RestaurantGUI {

	private Restaurant restaurant;

	public RestaurantGUI() {
		restaurant= new Restaurant();
	}

	private String currentUser;

	//main-pane
	@FXML
	private Pane mainPane;
	//admin-page
	@FXML
	private TextField txtUsuario;
	//admin-page
	@FXML
	private PasswordField txtPassword;

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
	
	//Client-page
	@FXML
    private TableView<Client> tvClients;
	
	@FXML
    private TableColumn<Client, String> tcClientName;

    @FXML
    private TableColumn<Client, String> tcClientLastName;

    @FXML
    private TableColumn<Client, String> tcClientID;

    @FXML
    private TableColumn<Client, String> tcClientAdress;

    @FXML
    private TableColumn<Client, Integer> tcClientPhone;
    
    //create-Client
    
	@FXML
	void addEmployee(ActionEvent event) {
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
		}

	}




	//create-Employee
	@FXML
	void btnAtrasCrearEmpleados(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Employee-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableView();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	//admin-page
	@FXML
	void btnAtras(ActionEvent event) {
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
	void btnLogIn(ActionEvent event) {
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
			//borrar esto en el futuro 
			System.out.println("No encontro el usuario");
		}
	}

	//main-page
	public void loadMainPage(){
		restaurant.createUser("Admin","SuperAdmin","a003",0,"A","1");
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


	//main-page
	@FXML
	void btnAdmin(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("admin-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//main-page
	@FXML
	void btnMenu(ActionEvent event) {

	}

	//Logged-in-page
	@FXML
	void btnEmpleados(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Employee-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableView();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//Logged-in-page
	@FXML
    void btnClients(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Clients-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
			loadTableViewClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	void btnReturnToLoggedInPage(ActionEvent event) {
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
	void btnBackToLoggedInPage(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("logged-in-page.fxml"));

			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);

			loadTableView();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
	

	//ingredient-page
	@FXML
	void btnAddIngredient(ActionEvent event) {
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

	//ingredient-page to logged-in-page
	@FXML
	void btnGoToLoggedInPage(ActionEvent event) {
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
	void btnAddINgredient(ActionEvent event) {
		boolean avialable=false;
		if(rbtnAvailable.isSelected() || rbtnNotAvailable.isSelected()) {
			if(rbtnAvailable.isSelected()) {
				avialable=true;
			}
			if(!restaurant.addIngredient(txtNameIgredient.getText(), avialable)) {
				restaurant.getIngredients().get(restaurant.getIngredients().size()-1).setCreatedBy(currentUser);
				restaurant.getIngredients().get(restaurant.getIngredients().size()-1).setLastEditedBy(currentUser);
				lblAddIngredient.setText("Se agregado ingrediente correctamente");
				lblAddIngredient.setTextFill(Paint.valueOf("Green"));
			}else {
				lblAddIngredient.setText("Ya hay un ingrediente con este nombre");
				lblAddIngredient.setTextFill(Paint.valueOf("Red"));
			}
		}else {
			lblAddIngredient.setText("Por favor llene todos los campos");
			lblAddIngredient.setTextFill(Paint.valueOf("Red"));
		}
	}

	//addIngredient-page to ingredient-page
	@FXML
	void btnBackToIngredient(ActionEvent event) {
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

	//Logged-in-page
	@FXML
	void btnLoadIngredient(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("ingredient-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//Logged-in-page
	public void loadTableView() {
		ObservableList<Employee> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getEmployes());
		tvEmployees.setItems(observableList);
		tcName.setCellValueFactory(new PropertyValueFactory<Employee,String>("name")); 
		tcLastName.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName")); 
		tcId.setCellValueFactory(new PropertyValueFactory<Employee,String>("id"));
		tcNumOfOrders.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("numOfOders"));
		
		
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
	void btnAdminIngredients(ActionEvent event) {
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
	void btnAddEmployee(ActionEvent event) {
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
	void btnAdminIngredientsToIngredients(ActionEvent event) {
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
	void btnDeleteIngredient(ActionEvent event) {
		restaurant.getIngredients().remove(cboxIngredients.getSelectionModel().getSelectedIndex());
		cboxIngredients.getItems().clear();
		
		for(int c=0;c<restaurant.getIngredients().size();c++) {
			cboxIngredients.getItems().add(restaurant.getIngredients().get(c).getIngredients());
		}
	}
	//admin ingredient
	@FXML
	void btnSaveIngredient(ActionEvent event) {
		//poner if para que no saque error
		restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).setAvialable(rbtnAdminIngredientsAvielable.isSelected());
		restaurant.getIngredients().get(cboxIngredients.getSelectionModel().getSelectedIndex()).setLastEditedBy(currentUser);
	}

	//admin ingredient
	@FXML
	void cBoxChangeIngredient(ActionEvent event) {
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
	void btnAddProduct(ActionEvent event) {

	}
	
	//addProduct-page
	@FXML
	void btnAddSizeAndPriceForProduct(ActionEvent event) {
	 	restaurant.sizeAndPriceForProduct(txtSizeOfProduct.getText(), Double.parseDouble(txtPriceOfSizeOfProduct.getText()));
	 	txtSizeOfProduct.clear();
	 	txtPriceOfSizeOfProduct.clear();
	 	lblIngredientsForProduct.setText(lblIngredientsForProduct.getText()+" "+restaurant.getSizeAndPrice().get(restaurant.getSizeAndPrice().size()-1).getSize()+" con precio de: "+restaurant.getSizeAndPrice().get(restaurant.getSizeAndPrice().size()-1).getPrice()+", ");
	}
	
	//addProduct-page
	@FXML
	void btnIngredientForProduct(ActionEvent event) {

	}
	
	//logged in page to products page
    @FXML
    void btnLoadProducts(ActionEvent event) {
    	try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("product-page.fxml"));
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
    void btnLoadAddProduct(ActionEvent event) {
    	try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("addProduct-page.fxml"));
			fxmlLoader.setController(this);
			Parent login;
			login = fxmlLoader.load();
			mainPane.getChildren().setAll(login);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}







