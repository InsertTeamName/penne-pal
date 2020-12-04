package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * AddListController class will handle the actions for adding lists.
 * 
 * @author Zain Momin (xct635) Christina Zhang (tro558)
 * UTSA CS3443-001
 * Fall 2020
 */
public class AddListController extends PalController {

	@FXML
	private Label errorLabel;
	@FXML
	private TextField listNameTextField;
	@FXML
	private DatePicker listDatePicker;
	@FXML
	private Button addBtn;
	
	@FXML
	private void addList(final ActionEvent e) {
		System.out.println("Add List");
		System.out.println(listDatePicker.getValue());
		if(listDatePicker.getValue() == null || listNameTextField.getText().equals("")) {
			errorLabel.setVisible(true);
		}
		else {
			errorLabel.setVisible(false);
		}
	}
}
