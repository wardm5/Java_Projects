
/** 
 * Michael Ward, CS211 OBS, 06/07/2017
 * This program creates the HuffmanTree and other methods which are critical to ensuring the GUI to work when compressing and decompressing the file text data. 
 **/

import java.util.*;
import java.io.*;

public class HuffmanTree { 						// class variables in constructor
	private Map<Character, Integer> counts;
	private HuffmanNode root;
	public HuffmanTree(Map<Character, Integer> counts){		// initialization of constructors
		this.counts = counts;
		this.root = createTree();
	}
	public StringBuilder compress(FileInputStream inputFile) throws IOException{ // inputFile is a text file
		StringBuilder j = new StringBuilder();  // new StringBuilder
		j.append("");  // new StringBuilder string with nothing in it
		Map<Character, StringBuilder> map = new HashMap<Character, StringBuilder>();   // new map
		compressionMap(this.root, j, map);    // calls the comrpessionMap method
		int content;   // loops through input file
		while ((content = inputFile.read()) != -1){
			// convert to char and display it       ***GOT THIS 'CONTENT' LOOP FROM THE INTERNET***
			//System.out.print((char) content);  
			char letter = (char) content;
			j.append(map.get(letter));
		}
		return j;  // returns StringBuilder string
	}
	
	private void compressionMap(HuffmanNode node, StringBuilder acc, Map<Character, StringBuilder> map){   // compressionMap method which does most of the work for creating the map for compressed string
		if (node != null) {    // if node is not null
			if (node.isLeaf()) {
				char letter = node.character;  // and the node is a leaf...
				map.put(letter, acc);   // add the letter and the accumulated string
			} else {
				compressionMap(node.right, new StringBuilder(acc).append(0), map);  // use recursion and run through the right branches of the tree nodes
				compressionMap(node.left, new StringBuilder(acc).append(1), map);   // use recursion and run through the left branches of the tree nodes
			}
		}
	}
		
	private HuffmanNode createTree(){     // creates the HuffmanTree Method
		PriorityQueue<HuffmanNode> test = new PriorityQueue<HuffmanNode>();  // creates new PriorityQueue
		for(Character key : counts.keySet()) {    // loops through the map
		    Integer value = counts.get(key);      // sets value to the frequency of that node
		    HuffmanNode node = new HuffmanNode(value, key, null, null);  // sets the HuffmanNode values and character
		    test.add(node);  // adds the node to the PriorityQueue
		}
		while(test.size() > 1){  // Loops through the PriorityQueue.
			HuffmanNode node1 = test.poll();    // sets the first node variable to the first PriorityQueue item
			HuffmanNode node2 = test.poll();    // sets the second node variable to the second PriorityQueue item
			int value1 = node1.frequency;		// set the first node value variable to the first node frequency value
			int value2 = node2.frequency;		// set the second node value variable to the second node frequency value
			HuffmanNode node = new HuffmanNode((value1 + value2), (char) 0, node1, node2);  // creates the branches of the HuffmanTree using the two nodes and adding the values
			test.add(node);   // adds the new node (tree) back to the queue
		}
		return test.remove();  // returns the last item from the queue as the root
	}

	public StringBuilder decompress(StringBuilder inputString){ //inputString 1’s & 0’s 
		StringBuilder test = new StringBuilder();   // new StringBuilder
		HuffmanNode node = this.root;     // sets node to the root
		for (int i = 0; i <= inputString.length(); i++){   // loops through the StringBuilder input
			if (node.isLeaf()){  // checks if the node is a leaf
				test.append(node.character);    // adds the character to the string
				i = i - 1;  // if the node is a leaf, lowers i by one
				node = this.root;   // sets the node back to the root
				if (i >= inputString.length() - 1){  // if i is equal or greater than the length - 1 of the StringBuilder, then...
					return test;   // return the String
				}
			} else if (inputString.charAt(i) - '0' == 1){  // else check to see if the input char at that point is a 1
				node = node.left;   // then set node to the left branch
			} else {
				node = node.right;  // else set node to the right branch
			}
		}
		return test;  // return the StringBuilder
	}

	public String printSideways() {    // printSidways method call
		StringBuilder test = new StringBuilder("");  // sets up a new StringBuilder
		printSideways(this.root, 0, test);   // selects the root and calls the private method that does most of the work
		return test.toString();  // returns the string
	}
	
	private void printSideways(HuffmanNode node, int level, StringBuilder j) {   // private method that does most of the work for printSideways call
		if (node !=null){   // if the node is not null, then....
			printSideways(node.right, level +1, j);    // call the method using recursion 
			for (int i = 0; i < level; i ++){  // loops through the level
				j.append("    ");  // adds the spacing to the print tree
			}
			if (node.isLeaf()) {  // if the node is a leaf, then...  
				j.append(node.frequency + "=char(" + (int)node.character + ")\n\n");   // add to the StringBuilder the node Frequency, and character
			} else {	  // else...
				j.append(node.frequency + "=count\n\n");  // add to the StringBuilder the frequency and the "=count"
			}
			printSideways(node.left, level + 1, j);   // finally, if the node is going to the left, do recursion and call the method again
		}
	}
}
