package application.model;

/**
 * Item class contains constructor for item object as well as any associated methods.
 * 
 * @author Zain Momin (xct635) Christina Zhang (tro558)
 * UTSA CS3443-001
 * Fall 2020
 */
public class Item {
	
	private String itemName;
	private double price;
	private int amount;
	
	/**
	* constructor for item object.
	* @param itemName
	* @param price
	* @param amount
	*/
	public Item (final String itemName, final double price, final int amount) {
		this.itemName = itemName;
		this.price = price;
		this.amount = amount;
	}
	
	/**
	* get item name.
	* @return itemName
	*/
	public String getItemName() {
		return itemName;
	}
	
	/**
	* set item name.
	* @param itemName
	*/
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/**
	* get item price.
	* @return price
	*/
	public double getPrice() {
		return price;
	}
		
	/**
	* set item price.
	* @param price
	*/
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	* get item amount.
	* @return amount
	*/
	public int getAmount() {
		return amount;
	}
	
	/**
	* set item amount.
	* @param amount
	*/
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	* toString() for item.
	* @return string
	*/
	@Override
	public String toString() {
		return itemName + " - " + "$" + price + " x" + amount; 
	}

}
