
/** 
 * Michael Ward, CS211 OBS, 06/07/2017
 * This program creates the nodes and supporting methods like getCounts for the HuffmanTree. 
 **/

import java.util.*;
import java.io.*;

public class HuffmanNode implements Comparable<HuffmanNode> {  // class variables in the constructor
	public int frequency;     // frequency of character occurring
	public char character;     // character that is in the text file
	public HuffmanNode left;     // left link to the node
	public HuffmanNode right;	 // right link to the node
	
	public HuffmanNode(int frequency, char character, HuffmanNode left,  HuffmanNode right){  // initialization of constructors
		this.frequency = frequency;  
		this.character = character;
		this.left = left;
		this.right = right;
	}
	public boolean isLeaf() {  // isLeaf method creates a boolean for if the node is a "leaf"
        if(right == null && left == null){
            return true;
         } else {
         	return false;
         }
	}
	public static Map<Character, Integer> getCounts(FileInputStream input) throws IOException{  // getCounts method that loops through the input from file and cretaes a map with the value and character
		 Map<Character, Integer> map = new HashMap<Character, Integer>();
		 int content;
		 while ((content = input.read()) != -1){  // loop through file
			 // convert to char and display it    ***GOT THIS 'CONTENT' LOOP FROM THE INTERNET***
			 //System.out.print((char) content);
			 char letter = (char) content; 
			 if(!map.containsKey(letter)){ 
				 map.put(letter, 1);  // add character from file to map with initial value 1
			 } else {
				 int value = map.get(letter) + 1;  // add character from file to map with value + 1
				 map.put(letter, value ); 
			 }
		 }
		 map.put((char)4, 1);   // add end of file character (seems to not work with my test file). Choose four since it did not seem to match with any character that I could find.
		 return map;      // returns map
	}
	public int compareTo(HuffmanNode node){   // compareTo method
		if(this.frequency < node.frequency){   // checks if frequency of the current node is lower than another node
			return -1;
		} if(this.frequency == node.frequency){  // if this node is the same, then return 0
			return 0;
		} else {    // else return that it is higher in value
			return 1;
		}
	}
}
