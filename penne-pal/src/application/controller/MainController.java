package application.controller;

import java.io.IOException;

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
public class MainController extends PalController{
	
	@FXML
	private Button signUpBtn;
	@FXML
	private Button loginBtn;
	
	
	/**
	 * Takes user to sign up page
	 * @param e
	 * @throws IOException 
	 */
	@FXML
	public void goToSignUpPage(final ActionEvent e) throws IOException {
		System.out.println("Go to Sign Up Page!");
		switchScene(this, "application/view/SignUp.fxml", e);
	}
	
	/**
	 * Takes user to login page
	 * @param e
	 * @throws IOException 
	 */
	@FXML
	public void goToLoginPage(final ActionEvent e) throws IOException {
		System.out.println("Go to Log in Page!");
		switchScene(this, "application/view/Login.fxml", e);
	}

}
