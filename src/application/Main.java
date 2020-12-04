package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main Class launches GUI application.
 * 
 * @author Zain Momin (xct635)
 * UTSA CS3443-001
 * Fall 2020
 */
public class Main extends Application{
	
	private Stage primaryStage;

	/**
	 * creates the primary stage and shows the main view.
	 * @param primaryStage
	 * @throws IOException
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		showMainView();
	}
	
	/**
	 * sets up the main view. 
	 * @throws IOException
	 */
	private void showMainView() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/Main.fxml"));
		final Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Launch the application 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	
}
