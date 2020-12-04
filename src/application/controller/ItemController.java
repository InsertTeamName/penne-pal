package application.controller;

import application.model.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * ItemController class will handle the actions associated with items for each list.
 * 
 * @author Zain Momin (xct635) Christina Zhang (tro558)
 * UTSA CS3443-001
 * Fall 2020
 */
public class ItemController extends PalController{
	
	@FXML
	private CheckBox nameOfItem;
	@FXML
	private Label itemPriceLabel;
	@FXML
	private Label itemQuantityLabel;
	@FXML
	private Label totalAmountLabel;

	private Item item;
	private VBox vBox;
	
	/**
	 * initializes the item, setting its information
	 * @param item
	 * @param vBox
	 */
	public void initializeItem(final Item item, final VBox vBox) {
		this.item = item;
		this.vBox = vBox;
		nameOfItem.setText(item.getItemName());
		itemPriceLabel.setText(String.valueOf(item.getPrice()));
		itemQuantityLabel.setText(String.valueOf(item.getAmount()));
		totalAmountLabel.setText(String.valueOf(item.getAmount() * item.getPrice()));
		
	}

}
