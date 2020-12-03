package application.model;

import java.util.List;

public class ShoppingList {
	
	private String listName;
	private List<Item> items;
	
	public static List<Item> getItemLists() {
		
		return null;
	}
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}


}
