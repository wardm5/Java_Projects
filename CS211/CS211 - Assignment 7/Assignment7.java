package assignment7;
import assignment7.ArrayIntList;

/** 
 * Michael Ward, CS211 OBS, 05/26/2017
 * This program runs the three test methods for the assignments upToNowTotal, isPairSorted, and removeLast. 
 **/

public class Assignment7 {  
	public static void main(String[] args){
		upToNowTotalTest();  // runs upToNowTotal test method
		isPairSortedTest();  // runs isPairSorted test method
		removeLastTest();  // runs removeLast test method
	}
	public static void upToNowTotalTest(){  // this method performs tests for upToNowTotal() with different array values.
		System.out.println("Test for upToNowTotal:");
		ArrayIntList list1 = new ArrayIntList();
		System.out.println("expected output: [],    actual output: \t\t\t\t\t" + list1.upToNowTotal());
		
		ArrayIntList list2 = new ArrayIntList(2);
		System.out.println("expected output: [2],    actual output: \t\t\t\t" + list2.upToNowTotal());
		
		ArrayIntList list3 = new ArrayIntList(2, 4);
		System.out.println("expected output: [2, 6],    actual output: \t\t\t\t" + list3.upToNowTotal());
		
		ArrayIntList list4 = new ArrayIntList(2, 4, -1);
		System.out.println("expected output: [2, 6, 5],    actual output: \t\t\t\t" + list4.upToNowTotal());
		
		ArrayIntList list5 = new ArrayIntList(2, 4, 3, 7, 0, 1, -1);
		System.out.println("expected output: [2, 6, 9, 16, 16, 17, 16],    actual output: \t\t" + list5.upToNowTotal());
		
		ArrayIntList list6 = new ArrayIntList(2, 3, 5, 4, 7, 15, 20, 7);
		System.out.println("expected output: [2, 5, 10, 14, 21, 36, 56, 63],    actual output: \t" + list6.upToNowTotal());
		
		System.out.println();
	}
	public static void isPairSortedTest(){  // this method performs tests for isPairSorted() with different array values.
		System.out.println("Test for isPairSorted:");
		ArrayIntList list1 = new ArrayIntList();
		System.out.println("expected output: true, actual output: \t" + list1.isPairSorted());
		
		ArrayIntList list2 = new ArrayIntList(0);
		System.out.println("expected output: true, actual output: \t" + list2.isPairSorted());
		
		ArrayIntList list3 = new ArrayIntList(4, 6);
		System.out.println("expected output: true, actual output: \t" + list3.isPairSorted());
		
		ArrayIntList list4 = new ArrayIntList(6, 4);
		System.out.println("expected output: false, actual output: \t" + list4.isPairSorted());
		
		ArrayIntList list5 = new ArrayIntList(6, 6);
		System.out.println("expected output: true, actual output: \t" + list5.isPairSorted());
		
		ArrayIntList list6 = new ArrayIntList(3, 8, 2, 5, 19, 24, -3, 0, 4, 4, 8, 205, 42);
		System.out.println("expected output: true, actual output: \t" + list6.isPairSorted());
		
		ArrayIntList list7 = new ArrayIntList(1, 9, 3, 17, 4, 28, -5, -3, 0, 42, 308, 409, 19, 17, 2, 4);
		System.out.println("expected output: false, actual output: \t" + list7.isPairSorted());
		
		System.out.println();
	}
	public static void removeLastTest(){  // this method performs tests for removeLast() with remove values.
		System.out.println("Test for removeLast:");
		ArrayIntList list1 = new ArrayIntList(2, 4, 3, 7, 0, 1, -1);
		list1.removeLast(0);
		System.out.println("expected output: [2, 4, 3, 7, 0, 1, -1],    actual output: \t" + list1);
		ArrayIntList list2 = new ArrayIntList(2, 4, 3, 7, 0, 1, -1);
		list2.removeLast(1);
		System.out.println("expected output: [2, 4, 3, 7, 0, 1],    actual output: \t\t" + list2);
		ArrayIntList list3 = new ArrayIntList(2, 4, 3, 7, 0, 1, -1);
		list3.removeLast(4);
		System.out.println("expected output: [2, 4, 3],    actual output: \t\t\t" + list3);
		ArrayIntList list4 = new ArrayIntList(2, 4, 3, 7, 0, 1, -1);
		list4.removeLast(-1);
		System.out.println("expected output: [2, 4, 3, 7, 0, 1, -1],    actual output: \t" + list4);
		ArrayIntList list5 = new ArrayIntList(2, 4, 3, 7, 0, 1, -1);
		list5.removeLast(7);
		System.out.println("expected output: [],    actual output: \t\t\t\t" + list5);

		System.out.println();
	}
}
