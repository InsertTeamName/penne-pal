package application.model;

import java.util.Date;
import java.util.List;

public class ShoppingList {
	
	private Date dateForList;
	private String listName;
	private List<Item> items;
	
	public static List<Item> getItemLists() {
		
		return null;
	}
	
	public Date getDateForList() {
		return dateForList;
	}
	public void setDateForList(Date dateForList) {
		this.dateForList = dateForList;
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
