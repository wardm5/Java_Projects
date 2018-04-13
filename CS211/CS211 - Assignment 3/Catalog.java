/**
* NAME:   Michael Robert Ward
* DATE:   4/13/2017
* CLASS:  CS212 Spring
* 
* * This program was created to be the "back end" of a shopping site and utilizes arrays, loops, and if statements to keep track of orders and items.
*/

import java.util.*;

public class Catalog {
	//declaring variables
	private String name;
	ArrayList<Item> list;
	
	//this method initializes the variables.
	public Catalog (String name) {
		this.name = name;
		list = new ArrayList<Item>();
	}
	
	// this method adds an item to the Item array. 
	public void add(Item item) {
		list.add(item);
	}
	
	// this method returns an integer that describes how many items are in the array.
	public int size() {
		return list.size();
	}
	
	//this method returns the item from the array based on the integer parameter.
	public Item get(int index) {
		return list.get(index);
	}
	
	//this method returns the name of the catalog.
	public String getName() {
		return this.name;
	}
	
}
