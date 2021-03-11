package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
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
	private TextField txtPassword;
	//admin-page
	@FXML
	void btnAtras(ActionEvent event) {

	}
	//admin-page
	@FXML
	void btnLogIn(ActionEvent event) {
		if(restaurant.logInAdmin(txtUsuario.getText(), txtUsuario.getText()).contains("Bienvenido ")) {
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
	}

	//main-page
	public void loadMainPage(){
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
		restaurant.createUser("Admin","SuperAdmin", 1,"El admin","123 ");

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

}

