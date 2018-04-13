/**
* NAME:   Michael Robert Ward
* DATE:   4/13/2017
* CLASS:  CS212 Spring
* 
* * This program was created to be the "back end" of a shopping site and utilizes arrays, loops, and if statements to keep track of orders and items.
*/

import java.text.*;

public class Item {
	//Declaring variables
	public String name;
	private double price;
	private int bulkQty;
	private double bulkPrice;

	
	// this method instantiates variables
	public Item (String name, double price) {
		this.name = name;
		this.price = price;
		this.bulkQty = -1;
		this.bulkPrice =  -1.0;
		if (this.price < 0.0) {
			throw new IllegalArgumentException ("Price is negative, enter again.");
		}
	}
	
	// The method for item, which holds information for the item name, price, bulk quantity, and bulk price. 
	public Item (String name, double price, int bulkQty, double bulkPrice) {
		this.name = name;
		this.price = price;		
		this.bulkQty = bulkQty;
		this.bulkPrice = bulkPrice;
		if (this.bulkPrice < 0.0 || this.price < 0 || bulkQty < 0 ) {
			throw new IllegalArgumentException ("Number is negative (check price, bulk quantity, or bulk price).");
		}
	}
	
	// This method will allow the user to get the total price of the item based on quantity and the price.
	public double priceFor(int quantity) {
		double totalPrice = 0.0;
		if (bulkQty == -1 || bulkPrice == -1.0) {
			totalPrice = quantity * price;
		} else {
			totalPrice = ((quantity / bulkQty) * bulkPrice ) + ((quantity % bulkQty) * price);
		}
		return totalPrice;
	}
	
	// this method creates a string showing the item name, price, and if bulk is applicable, the bulk quantity and price.
	public String toString() {		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String bulkText = nf.format(bulkPrice);
		String priceText = nf.format(price);
		
		if (bulkQty != -1 && bulkPrice != -1.0) {
			return name + ", " + priceText + " (" + bulkQty + " for " + bulkText + ")";
		}
		return name + ", " + priceText;
	}
}
