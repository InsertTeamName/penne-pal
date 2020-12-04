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
	 * Get items by user and list name
	 * @param user
	 * @param listName
	 * @return
	 */
	public static List<Item> getItemsByUserAndListName(final User user, final String listName) {
		List<Item> items = new ArrayList<>();
		
		final File file = new File("items.csv");

		try {
			Scanner scan = new Scanner(file);
			
			while(scan.hasNextLine()) { 
				
				String line = scan.nextLine();
				String[] data = line.split(",");
				if(data[0].equals(listName) && data[4].equals(user.getUsername())) {
					String itemName = data[1];
					double itemPrice = Double.parseDouble(data[2]);
					int amount = Integer.parseInt(data[3]);
					
					Item item = new Item(itemName, itemPrice, amount);
					items.add(item);
					
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return items;
	}
	
	public static void removeItems(final User user, final String listName) throws IOException {
		File tempFile = new File("../itemsTemp.csv");
		tempFile.createNewFile();
		FileWriter fw = new FileWriter(tempFile, false);
		BufferedWriter bw = new BufferedWriter(fw);
		
		try {
			Scanner scan = new Scanner(new File("items.csv"));
			
			while(scan.hasNext()) {
				String line = scan.nextLine();
				String [] data = line.split(",");
				if(data[0].equals(listName) && data[4].equals(user.getUsername())) {
					continue;
				}
				else {
					bw.write(data[0]);
					bw.write(",");
					bw.write(data[1]);
					bw.write(",");
					bw.write(data[2]);
					bw.write(",");
					bw.write(data[3]);
					bw.write(",");
					bw.write(data[4]);
					bw.newLine();
				}
			}
			scan.close();
			File f = new File("items.csv");
			f.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		bw.close();
		fw.close();
		tempFile.renameTo(new File("items.csv"));
		
	}
	
	public static void addItemToCsv(final String listName, final String itemName, final double price, final int amount, final String username) throws IOException {
		File file = new File("items.csv");
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		try {			
			bw.write(listName);
			bw.write(",");
			bw.write(itemName);
			bw.write(",");
			bw.write(String.valueOf(price));
			bw.write(",");
			bw.write(String.valueOf(amount));
			bw.write(",");
			bw.write(username);
			bw.write(",");
			bw.newLine();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		System.out.println("Item has been added!");
		bw.close();
		fw.close();
	}
	
	/**
	 * gets item name
	 * @return
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
	* @return string containing item name, item price, and item amount (String) 
	*/
	@Override
	public String toString() {
		return itemName + " - " + "$" + price + " x" + amount; 
	}

}
