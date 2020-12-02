package application.controller;

import java.io.IOException;

import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Sign Up Controller class will handle any actions from the SignUp.fxml page
 * 
 * @author Zain Momin (xct635)
 * UTSA CS3443-001
 * Fall 2020
 */
public class SignupController extends PalController {
	
	@FXML
	private TextField signupUserField;
	@FXML
	private PasswordField signupPassField;
	@FXML
	private Button signupBtn;
	@FXML
	private Button loginBtn;
	@FXML
	private Label signupErrMsg;
	
	@FXML
	public void signup(final ActionEvent e) throws IOException {
		System.out.println("Sign Up!");
		// if user name exists in csv file then show error message.
		boolean validUsername = !signupUserField.getText().equals("user");
		if(validUsername) {
			signupErrMsg.setVisible(false);
			// Add user name and password to excel file
			final User user = new User(signupUserField.getText(), signupPassField.getText(), "", "");
			
			switchToHomeScene(this, user, "application/view/Home.fxml", e);
		} else {
			signupErrMsg.setVisible(true);
		}
		
	}
	
	@FXML
	public void goToLoginPage(final ActionEvent e) throws IOException {
		System.out.println("Go to Login Page!");
		switchScene(this, "application/view/Login.fxml", e);
	}

	
	
}
