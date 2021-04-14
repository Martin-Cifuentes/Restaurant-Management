package ui;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
		
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("main-pane.fxml"));
		fxmlLoader.setController(restaurantGUI);
		Parent root= fxmlLoader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("LA CASA DORADA");
		primaryStage.show();
		restaurantGUI.loadMainPage();
		
	}
	/*
	public void thread(Stage primaryStage){
		Thread time= new Thread() {
			public void run() {
				while(primaryStage.isShowing()) {
					primaryStage.setTitle(LocalDateTime.now().getDayOfMonth()+"/"+LocalDateTime.now().getMonthValue()+"/"+LocalDateTime.now().getYear()+"    "+LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+":"+LocalTime.now().getSecond());
					//LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+":"+LocalTime.now().getSecond();
					//LocalDateTime.now().getDayOfMonth()+"/"+LocalDateTime.now().getMonthValue()+"/"+LocalDateTime.now().getYear();
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		};time.run();
		}
		*/
}
