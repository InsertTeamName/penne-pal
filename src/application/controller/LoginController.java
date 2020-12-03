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
 * Login Controller class will handle any actions from the Login.fxml page
 * 
 * @author Zain Momin (xct635)
 * UTSA CS3443-001
 * Fall 2020
 */
public class LoginController extends PalController{
	
	@FXML
	private TextField loginUserField;
	@FXML
	private PasswordField loginPassField;
	@FXML
	private Button loginBtn;
	@FXML
	private Button signUpBtn;
	@FXML
	private Label loginErrMsg;
	
	
	@FXML
	public void login(final ActionEvent e) throws IOException {
		System.out.println("Login");
		// Check if user name and password exist in csv file
		// if user name and password do not match show error message
		final User user = new User("username", "password", "name", "email");
		boolean validUser = loginUserField.getText().equals("user") && loginPassField.getText().equals("pass");
		if(validUser) {
			loginErrMsg.setVisible(false);
			System.out.println("Valid user!");
			switchToHomeScene(this, user, "application/view/Home.fxml", e);
		}
		else {
			loginErrMsg.setVisible(true);
		}
	}
	
	@FXML
	public void goToSignUpPage(final ActionEvent e) throws IOException {
		System.out.println("Go to Sign Up Page!");
		switchScene(this, "application/view/SignUp.fxml", e);
	}

}
