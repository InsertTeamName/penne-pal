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
import javafx.scene.layout.Pane;

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
	
	@FXML
	public void removeList(final ActionEvent e) {
		System.out.println("Remove list: " + listLabel.getText());
	}

}
