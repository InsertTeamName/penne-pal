package application.controller;

import java.io.IOException;
import java.util.List;

import application.model.Item;
import application.model.ShoppingList;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * ListController class will handle the actions associated with shopping lists.
 * 
 * @author Zain Momin (xct635) Christina Zhang (tro558)
 * UTSA CS3443-001
 * Fall 2020
 */
public class ListsController extends PalController {

	@FXML
	private Button addListBtn;
	@FXML
	private FlowPane shoppingListPane;
	@FXML
	private Label numListsLabel;
	@FXML
	private Label totalAmountLabel;
	
	private User user;
	private BorderPane borderPane;
	
	/**
	* initializes lists for an user
	* @param user
	* @param borderPane
	*/
	public void initializeLists(final User user, final BorderPane borderPane) throws IOException {
		this.user = user;
		this.borderPane = borderPane;
		
		final List<ShoppingList> shoppingLists = ShoppingList.getShoppingListByUser(user);
		
		numListsLabel.setText("Number of List: " + shoppingLists.size());
		double total = 0;
		for(ShoppingList list : shoppingLists) {
			for(Item item : list.getItems()) {
				total += item.getPrice() * item.getAmount();
			}
		}
		totalAmountLabel.setText("Total Amount: $" + total);
	
		for (ShoppingList list : shoppingLists) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getClassLoader().getResource("application/view/ShoppingList.fxml"));
			Pane pane = (Pane) loader.load();
		
			ShoppingListController shoppingListController = loader.getController();
			shoppingListController.initializeController(user, list, borderPane, shoppingListPane);
			shoppingListPane.getChildren().add(pane);
		}
	}
	
	/**
	* adds a shopping list for an user
	* @param user
	* @throws IOException
	*/
	@FXML
	public void addShoppingList(final ActionEvent e) throws IOException {
		System.out.println("Add shopping lists");
		final Stage listPopup = new Stage();
		listPopup.initModality(Modality.APPLICATION_MODAL);
		final Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		listPopup.initOwner(currentStage);
		
		final FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getClassLoader().getResource("application/view/AddList.fxml"));
				
		final Parent root = loader.load();
		final Scene scene = new Scene(root);

		final AddListController listController = loader.getController();
		listController.initializeAddList(user, shoppingListPane, borderPane);
		
		listPopup.setScene(scene);
		listPopup.show();
		
	}
}
