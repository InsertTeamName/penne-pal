package application.model;

import java.util.List;

public class ShoppingList {
	
	private String listName;
	private List<Item> items;
	
	public static List<Item> getItemLists() {
		
		return null;
	}
	// @author Brynna watring, Christina Zhang, Zain Momin, Steven Luong, Chris Rademacher 
	public List<Item> getItems() {
		return items;
	}
	// @param a list of items from the user input 
	public void setItems(List<Item> items) {
		this.items = items;
	}
	// @return string listName that contains list of names 
	public String getListName() {
		return listName;
	}
	// @param a string of list names 
	public void setListName(String listName) {
		this.listName = listName;
	}


}
