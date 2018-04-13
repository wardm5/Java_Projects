/**
* NAME:   Michael Robert Ward
* DATE:   4/13/2017
* CLASS:  CS212 Spring
*
* * This program was created to be the "back end" of a shopping site and utilizes arrays, loops, and if statements to keep track of orders and items.
*/

public class ItemOrder {
	// declares variables
	private Item item;
	private int quantity;

	//initializes variables
	public ItemOrder(Item item, int quantity){
		this.item = item;
		this.quantity = quantity;
	}
	
	// this method returns the cost of the item based on the quantity.
	public double getPrice(){
		return item.priceFor(quantity);
	}
	
	// this method returns the item.
	public Item getItem() {
		return item;
	}	

}
