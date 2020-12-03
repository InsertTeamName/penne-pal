package application.controller;

import java.io.IOException;

import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
	
	@FXML
	public void signOutUser(final ActionEvent e) throws IOException{
		System.out.println("Sign Out User!");
		switchScene(this, "application/view/Main.fxml", e);
	}
	
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
