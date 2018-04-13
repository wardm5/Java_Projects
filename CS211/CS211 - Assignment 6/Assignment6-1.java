import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/** Michael Ward, CS211 OBS, 05/17/2017
 * This program completes the three assignments for week 6 (seeingThree, twoStacksAreEqual, and isMirrored). 
 **/

public class Assignment6 {
	public static void main(String[] args) {
		testSeeingThreeMethod();
		testTwoStacksAreEqualMethod();
		testIsMirrored();
	}
	public static void seeingThree(Stack<Integer> s) {
		Queue<Integer> test = new LinkedList<Integer>();  // creates a new Queue "test"
		int stackLength = s.size() - 1; // saves the stack length
		for (int i = 0; i <= stackLength; i++){ 
			int number = s.pop();  // saves the stack value
			for (int k = 1; k <= 3; k++){ // loops through the stack
				test.add(number); // adds the saved value to the new stack list.
			}
		}
		int testLength = test.size() - 1; // saves the Queue "test" length
		for(int i = 0; i <= testLength; i++){
			int number = test.remove();  // loops through the test queue and removes the value and adds them to the stack
			s.push(number);
		}
		stackLength = s.size() - 1;  // saves the stack length
		for (int i = 0; i <= stackLength; i++){
			int number = s.pop();  // goes through the stack and removes the values and adds them to the queue
			test.add(number);
		}
		testLength = test.size() - 1; // saves the queue length
		for(int i = 0; i <= testLength; i++){
			int number = test.remove();  // removes the values from the queue and into the stack to insure values are in the correct order
			s.push(number);
		}
    }
	public static boolean twoStacksAreEqual(Stack<Integer> s1, Stack<Integer> s2) {
		boolean isEqualStacks = true;  // boolean value for if these are equal stacks
		if(s1.size() != s2.size()){  // checks if the size of the first stack matches the second
			 return false; // if they do not match, it returns false.
		} else {
			Stack<Integer> test = new Stack<Integer>();  // creates new stack
			while (isEqualStacks && !s1.isEmpty()) { // loops through the first stack and if the boolean value is still true.
				int number1 = s1.pop();  // sets variable as the first stacks removed value
				int number2 = s2.pop();  // sets variable as the second stacks removed value
				if (number1 != number2) {  // compares the two values
					isEqualStacks = false;  // if they are not equal, then it switches the boolean value to false.
				} 
				test.push(number1);  // adds the first saved value to the new stack
				test.push(number2);  // adds the second saved value to the new stack
			}
			while (!test.isEmpty()) {  // loops through until no more values
				s2.push(test.pop());  // pushes the last value from the temporary stack to the top of the second stack
				s1.push(test.pop());  // pushes the last value from the temporary stack to the top of the first stack
			}
		}
		return isEqualStacks;  // returns if the stacks are equal or not.
	}
	public static boolean isMirrored(Queue<Integer> q) {
		boolean isPalindrome = true;  // sets isPalindrome to true as default
		Stack<Integer> test  = new Stack<Integer>();  // creates a new stack
		if (q == null || q.isEmpty()){  // checks to see if the queue is null or empty
			return true; // return true if empty or null.
		} else {
			int queueLength = q.size() -1;  // sets queue length
			for (int i = 0; i <= queueLength; i++) { // loops through queue
				int num = q.remove(); //  sets variable to removed queue value
				test.push(num);  //  pushes value from queue to stack
				q.add(num);  //  adds the value to the end of the queue
			}
			for (int i = 0; i <= queueLength; i++) {  // loops through the queue
				int num1 = q.remove();  // sets variable 1 to the removed value from the queue
				int num2 = test.pop();  // sets variable 2 to the removed value from the stack
				if (num1 != num2){  // if the numbers do not equal each other...
					isPalindrome = false; // change isPalindrome to false
				}
				q.add(num1);  // add values from queue back to queue to reverse order.
			}
		}
		return isPalindrome; // returns the boolean value
	}


	private static void testIsMirrored() {

		Queue<Integer> myQueueP  = new LinkedList<Integer>();;
	
		for (int i = 0; i < 5; i++)
		{
		
			System.out.print(i);
			myQueueP.add(i);
			
		}
		for (int i = 3; i >= 0 ; i--)
		{
			
			System.out.print(i);
			myQueueP.add(i);
				
		}
		
		
		System.out.println();
		
		System.out.println(isMirrored(myQueueP) + " isMirrord");	
	}
	

	private static void testTwoStacksAreEqualMethod() {
		Stack<Integer> myStack1  = new Stack<Integer>();	
		Stack<Integer> myStack2  = new Stack<Integer>();
		Stack<Integer> myStack3  = new Stack<Integer>();
		Stack<Integer> myStack4  = new Stack<Integer>();
	
		for (int i = 0; i < 5; i++)
		{
			myStack1.push(i);
			myStack2.push(i);
			myStack4.push(i);
		
		}
		for (int i = 0; i < 6; i++)
		{
			myStack3.push(i);
		
		}
	
		System.out.println(twoStacksAreEqual(myStack1,myStack2) + " Same Stack ");
		
		System.out.println(twoStacksAreEqual(myStack3, myStack4) + " Not Same Stack");
		
	}


	private static void testSeeingThreeMethod() {
		Stack<Integer> myStack  = new Stack<Integer>();	
		
		for (int i = 0; i < 5; i++)
		{
			myStack.push(i);

		}
		
		
		System.out.println();
		print(myStack);
		
		seeingThree(myStack);
	
		print(myStack);
		
	}

	private static void print(Stack<Integer> s) {
		Enumeration<Integer> e = s.elements();

		 while ( e.hasMoreElements() )
		      System.out.print( e.nextElement() + " " );
		    System.out.println();

	
	}

} //end of Assignment6 
