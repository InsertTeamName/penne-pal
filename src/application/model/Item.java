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
	* Public Item 
	* contains constructor for item object.
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
	* gets item name.
	* @return itemName (String) 
	*/
	public String getItemName() {
		return itemName;
	}
	
	/**
	* sets item name.
	* @param itemName (String) 
	*/
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/**
	* gets item price.
	* @return price (double) 
	*/
	public double getPrice() {
		return price;
	}
		
	/**
	* sets item price.
	* @param price (double) 
	*/
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	* gets item amount.
	* @return amount (int) 
	*/
	public int getAmount() {
		return amount;
	}
	
	/**
	* set item amount.
	* @param amount (int) 
	*/
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	* toString() for item.
	* @return string containing item name, item price and item amount (String) 
	*/
	@Override
	public String toString() {
		return itemName + " - " + "$" + price + " x" + amount; 
	}

}
