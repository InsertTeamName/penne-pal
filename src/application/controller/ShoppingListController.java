package application.controller;

import java.io.IOException;

import application.model.Item;
import application.model.ShoppingList;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

/**
 * ShoppingListController class will handle actions relating to the UpdateList.fxml view.
 * 
 * @author Zain Momin (xct635) Christina Zhang (tro558)
 * UTSA CS3443-001
 * Fall 2020
 */
public class ShoppingListController extends PalController {

	
	@FXML
	private ListView<String> shoppingItemsList;
	
	@FXML
	private BorderPane listPane;
	
	@FXML
	private Label listLabel;
	
	private ShoppingList shoppingList;
	private BorderPane borderPane;
	private User user;
	private FlowPane shoppingListPane;

	/**
	 * initializes the view.
	 * @param user
	 * @param shoppingList
	 * @param borderPane
	 * @param shoppingListPane
	 * @throws IOException
	 */
	public void initializeController(final User user, final ShoppingList shoppingList, final BorderPane borderPane, final FlowPane shoppingListPane) throws IOException {
		this.shoppingList = shoppingList;
		this.borderPane = borderPane;
		this.user = user;
		this.shoppingListPane = shoppingListPane;
		
		listLabel.setText(shoppingList.getListName());
		for(Item item : shoppingList.getItems()) {
			shoppingItemsList.getItems().add(item.toString());
		}
		
		
	}
	/**
	* handles updating a shopping list.
	* @param e
	* @throws IOException
	*/
	@FXML
	public void editShoppingList(final MouseEvent e) throws IOException {
		System.out.println("Selected " + listLabel.getText());
		
		final FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getClassLoader().getResource("application/view/UpdateList.fxml"));
		BorderPane pane = (BorderPane) loader.load();
		
		UpdateListController updateController= loader.getController();
		updateController.initializeUpdateList(shoppingList, user);
		
		borderPane.setCenter(pane);
		
	}


}
