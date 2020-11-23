package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Main Controller class will handle any actions from the Main.fxml page
 * 
 * @author Zain Momin (xct635)
 * UTSA CS3443-001
 * Fall 2020
 */
public class MainController {
	
	@FXML
	private Button signUpBtn;
	@FXML
	private Button loginBtn;
	
	
	/**
	 * Takes user to sign up page
	 * @param e
	 */
	@FXML
	public void goToSignUpPage(final ActionEvent e) {
		System.out.println("Go to Sign Up Page!");
		
	}
	
	/**
	 * Takes user to login page
	 * @param e
	 */
	@FXML
	public void goToLoginPage(final ActionEvent e) {
		System.out.println("Go to Log in Page!");
	}

}
