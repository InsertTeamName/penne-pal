package application.controller;

import java.io.IOException;
import java.util.List;

import application.model.ShoppingList;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

/**
 * AddListController class will handle the actions for adding lists.
 * 
 * @author Zain Momin (xct635) Christina Zhang (tro558)
 * UTSA CS3443-001
 * Fall 2020
 **/
public class AddListController extends PalController {

	@FXML
	private Label errorLabel;
	@FXML
	private TextField listNameTextField;
	@FXML
	private DatePicker listDatePicker;
	@FXML
	private Button addBtn;

	private User user;
	private FlowPane shoppingListPane;
	private BorderPane borderPane;
	
	/**
	* handles adding a list.
	* @param e
	public void initializeAddList(final User user, final FlowPane shoppingListPane, final BorderPane borderPane) {
		this.user = user;
		this.shoppingListPane = shoppingListPane;
		this.borderPane = borderPane;
	}
  
	@FXML
	private void addList(final ActionEvent e) throws IOException {
		System.out.println("Add List");
		System.out.println(listDatePicker.getValue());
		if(listDatePicker.getValue() == null || listNameTextField.getText().equals("")) {
			errorLabel.setVisible(true);
		}
		else {
			errorLabel.setVisible(false);
			ShoppingList.addShoppingListToCSV(user, listNameTextField.getText(), listDatePicker.getValue());
			shoppingListPane.getChildren().clear();
			for (ShoppingList list : ShoppingList.getShoppingListByUser(user)) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(this.getClass().getClassLoader().getResource("application/view/ShoppingList.fxml"));
				Pane pane = (Pane) loader.load();
			
				ShoppingListController shoppingListController = loader.getController();
				shoppingListController.initializeController(user, list, borderPane, shoppingListPane);
				shoppingListPane.getChildren().add(pane);
			}
			
			((Node)(e.getSource())).getScene().getWindow().hide();

		}
	}	
	
}
