// This program reads an input file of preferences and find a stable marriage
// scenario.  The algorithm gives preference to either men or women depending
// upon whether this call is made from main:
//      makeMatches(men, women);
// or whether this call is made:
//      makeMatches(women, men);

import java.io.*;
import java.util.*;

public class StableMarriage {
    public static final String LIST_END = "END";
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("What is the input file? ");
        String fileName = console.nextLine();
        Scanner input = new Scanner(new File(fileName));
        System.out.println();

        List<Person> men = readHalf(input);
        List<Person> women = readHalf(input);
        makeMatches(men, women);
        writeList(men, women, "Matches for men");
        writeList(women, men, "Matches for women");
    }

    public static Person readPerson(String line) {
        int index = line.indexOf(":");
        Person result = new Person(line.substring(0, index));
        Scanner data = new Scanner(line.substring(index + 1));
        while (data.hasNextInt()) {
            result.addChoice(data.nextInt());
        }
        return result;
    }

    public static List<Person> readHalf(Scanner input) {
        List<Person> result = new ArrayList<Person>();
        String line = input.nextLine();
        while (!line.equals(LIST_END)) {
            result.add(readPerson(line));
            line = input.nextLine();
        }
        return result;
    }

//------------------------------------------------------------------------------------
    /**
    * NAME:   Michael Ward
    * DATE:   4/28/2017
    * CLASS:  CS212 Spring
    * 
    * This code was written to solve the "stable marriage problem" using array lists, loops, and if statements.
    */
    public static void makeMatches(List<Person> list1, List<Person> list2) {
    	List<Person> menList = new ArrayList<Person>();  // creates new list for keeping track of men with a non empty preference list that is free
		List<List<Integer> > menPref = new ArrayList<List<Integer> >();  // creates new list for keeping track of the lists of men's preferences
    	Iterator<Person> itr = list1.iterator(); // creates iterator to run through the array list.
    	while (itr.hasNext()){  // this loop goes through each person and places their preferences into the men's preference and men lists.
    		Person personObj = itr.next();
    		menPref.add(personObj.getChoices());
    		menList.add(personObj);
    	}
		List<List<Integer> > womenPref = new ArrayList<List<Integer> >(); // this code creates a women's preference list.
    	Iterator<Person> itr1 = list2.iterator();  // creates a new iterator for the women's preference list.
    	while (itr1.hasNext()){  // this while loop adds the women's preferences to the women list.
    		Person personObj = itr1.next();
    		womenPref.add(personObj.getChoices());
    	}
    	while (!menList.isEmpty()){  // if the men's list is not empty, run through the following code:
    		Person currentMan = menList.get(0);  // current man will be set to the first item in the list.
    		if (menPref.get(list1.indexOf(currentMan)).isEmpty()){  // if the men's preference is empty, then remove the man.
    			menList.remove(0);
    		} else { // else run the following code:
	    		Integer W = currentMan.getFirstChoice();  // set W to the index of the woman that is the man's first choice.
	    		if (list2.get(W).hasPartner()) {    // if the woman has a partner...
	    			int manNumber = list2.get(W).getPartner();  // declare variable for the women's current partner.
	    			Person failedLove = list1.get(manNumber);  // set failed love as the person who needs to be un-engaged.
	    			menList.add(failedLove);  // add the man back to the list of men looking to be engaged.
	    			failedLove.erasePartner();  // erase the partner for the man.
	    			List<Integer> failedManPreferences = menPref.get(manNumber);  // this sets the man's preference to a list.
	    			failedManPreferences.remove(failedManPreferences.indexOf(W));   // this will remove the preference from the list of women who he got un-engaged. 
	    		}
	    		currentMan.setPartner(W);  // this will set the partner of the current man to the women
	    		list2.get(W).setPartner(list1.indexOf(currentMan));  // this sets the women's partner to the current man.
	    		List<Integer> wPrefs = womenPref.get(W);  // this creates a new list of women preferences based on the current engaged women.
	    		for (int i = wPrefs.size() - 1; list2.get(W).getPartnerRank() <  i; i-- ){  // this loop will delete any other man that is less desirable than the current engagement.
	    			int manValue = wPrefs.get(i); // this sets the index of the man that is less desirable
	    			womenPref.get(W).remove(i);  //   this will remove that man from her preference list.
	    			int womanValue = menPref.get(manValue).indexOf(W);  // womanValue is the index of the woman in the man's preference list
	    			if	(womanValue != -1){  // if the woman value does exist in the man's preference list
	    				menPref.get(manValue).remove(womanValue); // then remove the women value from the man's preferences.
	    			}
	    		}
	    		menList.remove(0); // finally, remove the man from the list of free men.
	    	}
        }
    }
//------------------------------------------------------------------------------------
    
    public static void writeList(List<Person> list1,  List<Person> list2,
                                 String title) {
        System.out.println(title);
        System.out.println("Name           Choice  Partner");
        System.out.println("--------------------------------------");
        int sum = 0;
        int count = 0;
        for (Person p : list1) {
            System.out.printf("%-15s", p.getName());
            if (!p.hasPartner()) {
                System.out.println("  --    nobody");
            } else {
                int rank = p.getPartnerRank();
                sum += rank;
                count++;
                System.out.printf("%4d    %s\n", rank,
                                  list2.get(p.getPartner()).getName());
            }
        }
        System.out.println("Mean choice = " + (double) sum / count);
        System.out.println();
    }
}