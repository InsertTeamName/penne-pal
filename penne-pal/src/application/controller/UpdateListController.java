package application.controller;

import java.io.IOException;
import java.util.List;

import application.model.Item;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class UpdateListController extends PalController{
	
	@FXML
	private Label errorLabel;
	@FXML
	private TextField itemNameField;
	@FXML
	private TextField itemPriceField;
	@FXML
	private TextField quantityTextField;
	@FXML
	private Button addItem;
	@FXML
	private VBox itemsPane;

	
	public void initializeUpdateList(final List<Item> items) throws IOException {
		loadItemsList(items);
	}
	@FXML
	public void addItem() {
		
		System.out.println("Add Item");
		
		if(itemNameField.getText().equals("") || itemPriceField.getText().equals("") || quantityTextField.getText().equals("")) {
			errorLabel.setVisible(true);
		} else {
			errorLabel.setVisible(false);
		}
		
	}

	
	private void loadItemsList(final List<Item> items) throws IOException {
		for(Item item : items) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getClassLoader().getResource("application/view/Item.fxml"));
			Pane pane = (Pane) loader.load();
			
			ItemController itemController = loader.getController();
			itemController.initializeItem(item);
			itemsPane.getChildren().add(pane);
		}
	}
}
