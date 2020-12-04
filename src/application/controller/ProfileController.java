package application.controller;

import java.io.IOException;

import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * ProfileController class will handle actions relating to the Profile view.
 * 
 * @author Zain Momin (xct635) Christina Zhang (tro558)
 * UTSA CS3443-001
 * Fall 2020
 */
public class ProfileController extends PalController {
	
	@FXML
	private TextField nameTextField;
	@FXML
	private TextField emailTextField;
	@FXML
	private Label userLabel;
	@FXML
	private Label hiddenUsername;
	@FXML
	private Label errorLabel;
	@FXML
	private Button saveBtn;
	@FXML
	private Button signOutBtn;
	
	private User tempUser;
	
	/**
	* initializes the profile view for a user.
	* @param user
	*/
	public void initializeProfile(final User user) {
		if(user.getName() == null || user.getName().equals("")) {
			userLabel.setText("Hi " + user.getUsername());
		}
		else {
			userLabel.setText("Hi " + user.getName());
			nameTextField.setText(user.getName());
			emailTextField.setText(user.getEmail());
		}
		
		if(user.getUsername() != null && !(user.getUsername().equals(""))){
			hiddenUsername.setText(user.getUsername());
		}
		tempUser = user;
	}
	
	/**
	* signs out the user.
	* @param e
	* @throws IOException
	*/
	@FXML
	public void signOutUser(final ActionEvent e) throws IOException{
		System.out.println("Sign Out User!");
		switchScene(this, "application/view/Main.fxml", e);
	}
	
	/**
	* saves updated information for a user.
	* @param e
	*/
	@FXML
	public void saveInfo(final ActionEvent e) {
		System.out.println("Save Info");
		if(emailTextField.getText().equals("") || nameTextField.getText().equals("")) {
			errorLabel.setVisible(true);
		}
		else {
			errorLabel.setVisible(false);
			//Update CSV file
			try {
				tempUser.editProfile(hiddenUsername.getText(), nameTextField.getText(), emailTextField.getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
