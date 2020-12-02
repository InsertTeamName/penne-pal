package application.controller;

import application.model.Item;
import application.model.ShoppingList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class ShoppingListController extends PalController {
	
	@FXML
	private Button removeListBtn;
	
	@FXML
	private ListView<String> shoppingItemsList;
	
	@FXML
	private BorderPane listPane;
	
	@FXML
	private Label listLabel;
	
	public void initializeController(final ShoppingList shoppingList) {
		listLabel.setText(shoppingList.getListName());
		System.out.println(shoppingList.getItems());
		System.out.println(shoppingItemsList);
		for(Item item : shoppingList.getItems()) {
			shoppingItemsList.getItems().add(item.toString());
		}
	}
	
	@FXML
	public void editShoppingList(final MouseEvent e) {
		System.out.println("Selected " + listLabel.getText());
	}
	@FXML
	public void removeList(final ActionEvent e) {
		System.out.println("Remove list: " + listLabel.getText());
	}

}
