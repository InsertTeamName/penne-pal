package application.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ShoppingList class contains constructor for ShoppingList object as well as any associated methods.
 * 
 * @author Brynna watring, Christina Zhang, Zain Momin, Steven Luong, Chris Rademacher 
 * UTSA CS3443-001
 * Fall 2020
 */
public class ShoppingList {
	
	private LocalDate date;
	private String listName;
	private List<Item> items;
	
	final private static String shoppingListPath = "shopping_lists.csv";
	
	public static List<ShoppingList> getShoppingListByUser(final User user) {
		
		List<ShoppingList> shoppingLists = new ArrayList<>();
		
		final File file = new File(shoppingListPath);
		try {
			final Scanner scan = new Scanner(file);
			
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] data = line.split(",");
				if(data[0].equals(user.getUsername())) {
					
					ShoppingList shoppingList = new ShoppingList();
					String listName = data[1];
					shoppingList.setListName(listName);
					
					String [] dateValues = data[2].split("/");
					int month = Integer.parseInt(dateValues[0]);
					int day = Integer.parseInt(dateValues[1]);
					int year = Integer.parseInt(dateValues[2]);
					
					shoppingList.setDate(LocalDate.of(year, month, day));
					
					shoppingList.setItems(Item.getItemsByUserAndListName(user, listName));
					System.out.println("Got shopping list: " + listName);
					System.out.println("Number of items =  " + shoppingList.getItems().size());
					
					shoppingLists.add(shoppingList);
				}
			}
			
			scan.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return shoppingLists;
	}
	
	public static void addShoppingListToCSV(final User user, final String listName, final LocalDate date) throws IOException {
		File file = new File(shoppingListPath);
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		try {
			final String localDate = date.getMonth().getValue() + "/" + date.getDayOfMonth() + "/" + date.getYear();
			
			bw.write(user.getUsername());
			bw.write(",");
			bw.write(listName);
			bw.write(",");
			bw.write(localDate);
			bw.write(",");
			bw.newLine();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		System.out.println("Shopping List CSV has been added!");
		bw.close();
		fw.close();
	}
	
	public static void removeShoppingList(final User user, final String listName) throws IOException {
		File tempFile = new File("../shoppingListTemp.csv");
		tempFile.createNewFile();
		FileWriter fw = new FileWriter(tempFile, false);
		BufferedWriter bw = new BufferedWriter(fw);
		File file =new File(shoppingListPath);
		try {
			Scanner scan = new Scanner(file);
			
			while(scan.hasNext()) {
				String line = scan.nextLine();
				String [] data = line.split(",");
				if(data[0].equals(user.getUsername()) && data[1].equals(listName)) {
					System.out.println("Skip: " + line);
					continue;
				}
				else {
					System.out.println("Print: " + line);
					bw.write(data[0]);
					bw.write(",");
					bw.write(data[1]);
					bw.write(",");
					bw.write(data[2]);;
					bw.newLine();
				}
			}

			scan.close();
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		bw.close();
		fw.close();
		tempFile.renameTo(new File(shoppingListPath));
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	


}
