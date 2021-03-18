package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	private RestaurantGUI restaurantGUI;
	public Main() {
		restaurantGUI= new RestaurantGUI();
	}
	public static void main(String[] args) {
		launch(args); 
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("main-pane.fxml"));
		fxmlLoader.setController(restaurantGUI);
		Parent root= fxmlLoader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("LA CASA DORADA");
		primaryStage.show();
		restaurantGUI.loadMainPage();
		
	}
}
