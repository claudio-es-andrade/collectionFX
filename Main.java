package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Dado.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle(" Jogando Dados Aleatoriamente...");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(" Algo não ocorreu bem...");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
