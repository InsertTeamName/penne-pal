package application.model;

import java.util.List;

/**
 * ShoppingList class contains constructor for ShoppingList object as well as any associated methods.
 * 
 * @author Brynna watring, Christina Zhang, Zain Momin, Steven Luong, Chris Rademacher 
 * UTSA CS3443-001
 * Fall 2020
 */
public class ShoppingList {
	
	private String listName;
	private List<Item> items;
	
	public static List<Item> getItemLists() {
		
		return null;
	}
	
	/**
	* get items for a list.
	* @return items (String) 
	*/
	public List<Item> getItems() {
		return items;
	}
	
	/**
	* set items for a list.
	* @param items (String) 
	*/
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	/**
	* get list name for a list.
	* @return listName (String) 
	*/
	public String getListName() {
		return listName;
	}
	
	/**
	* set list name for a list.
	* @param listName (String) 
	*/
	public void setListName(String listName) {
		this.listName = listName;
	}


}
