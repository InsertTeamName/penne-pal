package application.controller;

import java.io.IOException;

import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
/**
 * HomeController class will handle any actions from the Home.fxml page
 * 
 * @author Zain Momin (xct635) Christina Zhang (tro558)
 * UTSA CS3443-001
 * Fall 2020
 */
public class HomeController extends PalController{
	
	@FXML
	private Button shoppingListBtn;
	@FXML
	private Button profileBtn;
	@FXML
	private BorderPane homePane;
	
	private User user;
	
	/**
	* initializes the view
	* @param user
	* @throws IOException
	*/
	public void initializeHome(final User user) throws IOException {
		this.user = user;
		
		disableButton(shoppingListBtn);

		loadLists();
	}
	

	/**
	* loads the profile view
	* @param e
	* @throws IOException
	*/
	@FXML
	public void loadProfile(final ActionEvent e) throws IOException {
		System.out.println("Load Profile");
		disableButton(profileBtn);
		enableButton(shoppingListBtn);
		
		loadUserProfile();
	}
	
	/**
	* loads the shopping list view
	* @param e
	* @throws IOException
	*/
	@FXML
	public void loadShoppingLists(final ActionEvent e) throws IOException {
		System.out.println("Load Shopping Lists");
		disableButton(shoppingListBtn);
		enableButton(profileBtn);
		
		loadLists();
	}
	
	/**
	* loads the lists view
	* @throws IOException
	*/
	public void loadLists() throws IOException {
		final FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getClassLoader().getResource("application/view/Lists.fxml"));
		BorderPane pane = (BorderPane) loader.load();
		
		ListsController listController = loader.getController();
		listController.initializeLists(user, homePane);
		homePane.setCenter(pane);
	}
	
	/**
	* loads the user profile view
	* @throws IOException
	*/
	public void loadUserProfile() throws IOException {
		final FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getClassLoader().getResource("application/view/Profile.fxml"));
		BorderPane pane = (BorderPane) loader.load();
		
		ProfileController profileController= loader.getController();
		profileController.initializeProfile(user);
		homePane.setCenter(pane);
	}
	
	/**
	* disables button
	* @param button
	* @throws IOException
	*/
	private void disableButton(final Button button) {
		button.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		button.setStyle("-fx-text-fill: navy");
		button.setDisable(true);
	}
	
	/**
	* enables button
	* @param button
	* @throws IOException
	*/
	private void enableButton(final Button button) {
		button.setBackground(new Background(new BackgroundFill(null, null, null)));
		button.setStyle("-fx-text-fill: WHITE");
		button.setDisable(false);
	}

}
