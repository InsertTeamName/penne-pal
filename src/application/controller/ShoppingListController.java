package application.controller;

import java.io.IOException;

import application.model.Item;
import application.model.ShoppingList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * ShoppingListController class will handle actions relating to the UpdateList.fxml view.
 * 
 * @author Zain Momin (xct635) Christina Zhang (tro558)
 * UTSA CS3443-001
 * Fall 2020
 */
public class ShoppingListController extends PalController {
	
	@FXML
	private Button removeListBtn;
	
	@FXML
	private ListView<String> shoppingItemsList;
	
	@FXML
	private BorderPane listPane;
	
	@FXML
	private Label listLabel;
	
	private ShoppingList shoppingList;
	private BorderPane borderPane;
	
	/**
	* initializes the view.
	* @param shoppingList
	* @param borderPane
	* @throws IOException
	*/
	public void initializeController(final ShoppingList shoppingList, final BorderPane borderPane) throws IOException {
		this.shoppingList = shoppingList;
		this.borderPane = borderPane;
		
		listLabel.setText(shoppingList.getListName());
		System.out.println(shoppingList.getItems());
		System.out.println(shoppingItemsList);
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
		updateController.initializeUpdateList(shoppingList.getItems());
		
		borderPane.setCenter(pane);
		
	}
	
	/**
	* removes a list.
	* @param e
	*/
	@FXML
	public void removeList(final ActionEvent e) {
		System.out.println("Remove list: " + listLabel.getText());
	}

}
