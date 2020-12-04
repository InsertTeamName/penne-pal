package application.controller;

import java.io.IOException;
import java.util.ArrayList;

import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * PalController class will handle switching screens.
 * 
 * @author Zain Momin (xct635)
 * UTSA CS3443-001
 * Fall 2020
 */
public class PalController {
	/**
	* switches views.
	* @param controller
	* @param resourcePath
	* @param event
	* @throws IOException
	*/
	public <T> void switchScene(final T controller, final String resourcePath, final ActionEvent event) throws IOException {
		final FXMLLoader loader = new FXMLLoader();
		loader.setLocation(controller.getClass().getClassLoader().getResource(resourcePath));
		
		final Parent root = loader.load();
		final Scene scene = new Scene(root);
		
		final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	* switches view to the home scene.
	* @param controller
	* @param user
	* @param resourcePath
	* @param event
	* @throws IOException
	*/
	public <T> void switchToHomeScene(final T controller, final User user, final String resourcePath, final ActionEvent event) throws IOException {
		final FXMLLoader loader = new FXMLLoader();
		loader.setLocation(controller.getClass().getClassLoader().getResource(resourcePath));
		
		
		final Parent root = loader.load();
		final Scene scene = new Scene(root);
		
		final HomeController home = loader.getController();
		home.initializeHome(user);
		
		final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

}
