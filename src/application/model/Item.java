package application.model;

public class Item {
	
	private String itemName;
	private double price;
	private int amount;
	
	public Item (final String itemName, final double price, final int amount) {
		this.itemName = itemName;
		this.price = price;
		this.amount = amount;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	// @return 
	public int getAmount() {
		return amount;
	}
	// @ param an int amount 
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return itemName + " - " + "$" + price + " x" + amount; 
	}

}
