import java.lang.reflect.Array;
import java.util.*;

// Header: Put your name, class,..etc here 

public class BogoSort { 
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis(); // recording start time (in milliseconds)
		int[] myArray = { 15,  4, 8, 66, 43, 54, 7, 3, 9, 73, 100, 42,  75}; // test array
		bogoSort(myArray);  	// calls the bogoSort method
		printArray(myArray); 	// prints out the sorted array
		long endTime = System.currentTimeMillis(); // recording end time (in milliseconds)
		System.out.println("Elapsed time (ms): " + (endTime - startTime)); // prints out ending statement of how many milliseconds the program took to sort the array.

	}
	// Places the elements of a into sorted order. 
	public static void bogoSort(int[] a) {
		while(!isSorted(a)){		// if the array is not sorted
			shuffle(a);				// then call shuffle method
		}
	} 
	// Returns true if a's elements are in sorted order. 
	public static boolean isSorted(int[] a) {
		for (int i = 1; i < a.length; i++){ 	// loops through array
			if (a[i] < a[i - 1]) {				// determines if the current array value is greater than the prior one.
				return false;					// if they are not in correct order, then return false
			}
		}
		return true;		// else return true showing the list is sorted.
	} 
	// Shuffles an array of ints by randomly swapping each 
	// element with an element ahead of it in the array. 
	public static void shuffle(int[] a) {
		Random rand = new Random();					// creates a new random number generator	
		for (int i = 0; i < a.length - 1; i++){		// loops through array
			int rando = rand.nextInt(a.length - i) + i ;		// saves the random number based on the length of the array
			swap(a , i, rando); 		// calls the swap method with the parameters of the array (a) current position (i), the random position (rando)
		}
	} 
	// Swaps a[i] with a[j]. 
	public static void swap(int[] a, int i, int j) {
		int oldVal = 0; // initializes the old value variable
		int newVal = 0; // initializes the new value variable
		oldVal = a[i];  // saves the current value
		newVal = a[j];  // saves the random value
		a[i] = newVal;	// swaps the old value with the new value
		a[j] = oldVal;	// swaps the new value with the old value
	}
	public static void printArray(int[] a) {  // loop provided
		for(int i=0; i < a.length; i++) { 
			System.out.println(a[i]);
		}
	}
}//end of BogoSort class