package application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.model.Item;
import application.model.ShoppingList;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class ListsController extends PalController {

	@FXML
	private Button addListBtn;
	@FXML
	private FlowPane shoppingListPane;
	
	public void initializeLists(final User user, final BorderPane borderPane) throws IOException {
		
		final List<ShoppingList> shoppingLists = getShoppingList(user);
	
		//for (ShoppingList list : shoppingLists) {
		
		//remove this counter and replace with shopping lists
		for(int i = 0; i < 3; i++) {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getClassLoader().getResource("application/view/ShoppingList.fxml"));
			Pane pane = (Pane) loader.load();
			
			Item item = new Item("pizza", 32.50, 3);
			List<Item> items = new ArrayList<>();
			items.add(item);
			
			ShoppingList list = new ShoppingList();
			list.setItems(items);
			list.setListName("List " + i);
			

			ShoppingListController shoppingListController = loader.getController();
			shoppingListController.initializeController(list, borderPane);
			shoppingListPane.getChildren().add(pane);
		}
	}
	
	private List<ShoppingList> getShoppingList(final User user) {
		
		return new ArrayList<>();
	}
	
	@FXML
	public void addShoppingList(final ActionEvent e) {
		System.out.println("Add shopping lists");
	}
}
