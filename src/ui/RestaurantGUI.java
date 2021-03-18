package ui;

import java.io.IOException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import model.Employee;
import model.Restaurant;

public class RestaurantGUI {

	private Restaurant restaurant;

	public RestaurantGUI() {
		restaurant= new Restaurant();
	}

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
    //create-Employee
    @FXML
    void addEmployee(ActionEvent event) {
    	try {
    		
	    	if(!txtEmployeeName.getText().equals("") && !txtEmployeeLastName.getText().equals("") &&
	    	   !txtEmployeeId.getText().equals("") && !txtNumOfOrders.getText().equals("")) {
	    		
	    		restaurant.createEmployee(txtEmployeeName.getText(), txtEmployeeLastName.getText(),
	    		txtEmployeeId.getText(), Integer.parseInt(txtNumOfOrders.getText()) );
	    		
	    		confirmEmployee.setText("Empleado agregado correctamente");
	    		confirmEmployee.setTextFill(Paint.valueOf("Green"));
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
			// TODO Auto-generated catch block
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
    

    //ingredient-page
    @FXML
    void btnAddIngredient(ActionEvent event) {
    	try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("addIngredient-page.fxml"));
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
    	if(rbtnAvailable.isSelected()) {
    		avialable=true;
    	}else if(rbtnNotAvailable.isSelected()) {
    		avialable=false;
    	}
    	
    	if(!restaurant.addIngredient(txtNameIgredient.getText(), avialable)) {
    		System.out.println("se creo un ingrediente");
    	}else {
    		System.out.println("no se creo ingrediente");
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
	



}

