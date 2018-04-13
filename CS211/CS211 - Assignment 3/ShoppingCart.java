import java.util.ArrayList;

/**
* NAME:   Michael Robert Ward
* DATE:   4/13/2017
* CLASS:  CS212 Spring
* 
* This program was created to be the "back end" of a shopping site and utilizes arrays, loops, and if statements to keep track of orders and items.
*/

public class ShoppingCart {
	// declares variables
	double totalPrice;
	ArrayList<ItemOrder> list;
	boolean value;
	
	//initializes variables
	public ShoppingCart() {
		this.totalPrice = 0.0;
		list = new ArrayList<ItemOrder>();
	}
	
	// this method checks to see if a name for an item has already been placed, if so, it replaces the item with the updated order, otherwise, it adds the order.
	public void add(ItemOrder item){
		int count = 0;
		while (list.size() > count ){
			if (list.get(count).getItem().name == item.getItem().name) { // uses a while loop to go through the items in the array and compares the current item's name
																		 // and compares it to the other item's name. If they are the same, then the order is replaced with the current.
																		 //otherwise, you add the current order.
				list.set(count, item);
				return ;
			} 
		count++;
		}
		list.add(item);
	}
	
	// This method takes in a boolean and then setting it to a variable.
	public void setDiscount(boolean value){
		this.value = value;
	}
	
	// this method returns the total cost of the order by using loops and if statement.
	public double getTotal() {
		int count = 0;
		double sum = 0;
		while (list.size() > count ){
			sum = list.get(count).getPrice() + sum;  // this while loop goes through the array and gets the cost for each order, then adds them up.
			count++;
		} 
		if (value) {
			sum = sum * .9;  // if the checkbox for the discount is activated (true), then this will provide a 10% discount to the value, otherwise, it would produce the cost at 100%.
		}
		return sum;
	}
	

	
}
