// CS210 Assignment #4 "Birthdays"
// Michael Ward

import java.util.Scanner;

// This code asks users for a date and birthdays to determine statistics and fun facts regarding the inputted data.
public class Birthdays {
    public static void main(String[] args) {
        
		Scanner console = new Scanner(System.in); 
		
		/* This code runs the console for the current date and saves the string as TEST1 which then passes TEST1 
		through absoluteday to get the abosolute value for the date and prints that info. */
		String TEST1 = currDate( console);
		int dayOfYear = absoluteday(monthNum(TEST1) , dayNum(TEST1));
		
		//System.out.println(absoluteday(12 ,2));  // This code runs the absoluteday() method to get the total days in a year given the input (month, day)
		
		System.out.println("Today is " + shortDate(TEST1) + ", day #" +  dayOfYear + " of the year.");
		System.out.println();

		/* This code runs the console for person 1's birthday and saves the string as TEST2 which then passes TEST2 
		through absoluteday to get the total days and prints that info along with additional information that is determined by if statements. */
		String TEST2 = BDay(console, 1);
		System.out.println(shortDate(TEST2) + " falls on day #" +  absoluteday(monthNum(TEST2) , dayNum(TEST2)) + " of 365.");
		if( nextBDay( dayOfYear , absoluteday(monthNum(TEST2) , dayNum(TEST2)) ) == 0) {
			System.out.println("Happy Birthday! :)");
		} else {
			System.out.println("Your next birthday is in " + nextBDay( dayOfYear, absoluteday(monthNum(TEST2) , dayNum(TEST2)) ) + " day(s).");	
		}
		int firstperson = nextBDay( dayOfYear, absoluteday(monthNum(TEST2) , dayNum(TEST2)) );
		System.out.println();
		
		/* This code runs the console for person 2's birthday and saves the string as TEST3 which then passes TEST3 
		through absoluteday to get the total days and prints that info along with additional information that is determined by if statements. */
		String TEST3 = BDay(console, 2);
		System.out.println(shortDate(TEST3) + " falls on day #" +  absoluteday(monthNum(TEST3) , dayNum(TEST3)) + " of 365.");
		if( nextBDay( dayOfYear , absoluteday(monthNum(TEST3) , dayNum(TEST3)) ) == 0) {
			System.out.println("Happy Birthday! :)");
		} else {
			System.out.println("Your next birthday is in " + nextBDay( dayOfYear ,  absoluteday(monthNum(TEST3) , dayNum(TEST3)) ) + " day(s).");	
		}
		int secondperson = nextBDay( dayOfYear ,  absoluteday(monthNum(TEST3) , dayNum(TEST3)) );
		
		/* This code runs a check on who's birthday is sooner based on the nextBDay result from the methods above 
		(which are varriables firstperson and secondperson). This also provides a fun fact regarding the author's birthday.*/ 
		System.out.println();
		if (firstperson == secondperson) {
			System.out.println("Wow, you share the same birthday! ^_^");
		} else if ( firstperson < secondperson) {
			System.out.println("Person #1's birthday is sooner.");
		} else {
			System.out.println("Person #2's birthday is sooner.");
		}
		System.out.println();
		System.out.println("Did you know that the first FORTRAN computer program ran on 9/20/1954? Looking back, Im glad I'm programming with Java. Also it is apparetnly \"National Punch Day\" so watch out!");
	}
	
    //This method asks for the user to input todays date using the console.
	public static String currDate(Scanner console){
		System.out.print("Please enter today's date (month day) : ");
		String date = console.nextLine(); 
		return date;
	}
    
    //This method asks for the user to input the first person's birthday using the console.
	public static String BDay(Scanner console, int person){
		System.out.print("Please enter person #" + person + "'s birhday (month day) : ");
		String date = console.nextLine(); 
		return date;
	}
    
    //This method asks for the user to input the second person's birthday using the console.
	public static String shortDate(String i){
		String shortDateTemp = i;
		shortDateTemp = shortDateTemp.replace(" ", "/") + "/2017";
    	return shortDateTemp;
    }
	
    /* This method uses the parameters (x = month, y = day) to calculate absolute days for the parameter date. This code uses a loop and if statements
	to get total days for each month and adds it to next months total depending on the month and then adds the days inputted by the user. */
	public static int absoluteday ( int x, int y ){
		int daysInYear = 0;
		for (int i = 1; i <= x; i++){
			
			if (i == 1){
				daysInYear = daysInYear + 0; // Jan - 0 days
			} else if (i == 2){
				daysInYear = daysInYear + 31; // Feb - 31 days
			} else if (i == 3){
				daysInYear = daysInYear + 28; // March - 59 days
			} else if (i == 4){
				daysInYear = daysInYear + 31; // April - 90
			} else if (i == 5){
				daysInYear = daysInYear + 30; // May - 120 days
			} else if (i == 6){
				daysInYear = daysInYear + 31; // June - 151 days
			} else if (i == 7){
				daysInYear = daysInYear + 30; // July - 181 days
			} else if (i == 8){
				daysInYear = daysInYear + 31; //August - 212 days
			} else if (i == 9){
				daysInYear = daysInYear + 31; //Sept - 243 days
			} else if (i == 10){
				daysInYear = daysInYear + 30; //Oct - 273 days
			} else if (i == 11){
				daysInYear = daysInYear + 31; //Nov - 304 days
			} else if (i == 12){
				daysInYear = daysInYear + 30; //Dec - 334 days
			}
		}
		int absoluteDayValue = daysInYear + y;
		return absoluteDayValue;
	}
	
	/* This code transfers the inputted string from the user into two numbers and adds them together based on loops, if statements and math logic.
	 This code is producing the day with the format int.
	 */
	public static int dayNum(String i) {
		String dayNum1 = i;
		dayNum1 = dayNum1.substring(dayNum1.indexOf(" ") + 1, dayNum1.length());
		int FinalNum = 0;
		int x = 0;
		int y = 0;
		for(int j = 0; j <= dayNum1.length() -1; j++){
			char stringtext;
			stringtext = dayNum1.charAt(j) ;
			int ward = Character.getNumericValue(stringtext);
			if ( (dayNum1.length() == 1) && (j == 0) ){
				x = ward;
				return x;
			} else if (j == 0){
				x = ward * 10;
			} else if (j == 1) {
				y = ward;
			}
			FinalNum = x + y;
		} 
		return FinalNum;
	} 	
	
	/* This code transfers the inputted string from the user into two numbers and adds them together based on loops, if statements and math logic.
	 This code is producing the month with the format int.
	 */
	public static int monthNum(String i) {
		String dayNum1 = i;
		dayNum1 = dayNum1.substring(0, dayNum1.indexOf(" "));
		int FinalNum = 0;
		int x = 0;
		int y = 0;
		for(int j = 0; j <= dayNum1.length() -1; j++){
			char misha;
			misha = dayNum1.charAt(j) ;
			int ward = Character.getNumericValue(misha);
			if ( (dayNum1.length() == 1) && (j == 0) ){
				x = ward;
			} else if (j == 0){
				x = ward * 10;
			} else if (j == 1) {
				y = ward;
			}
			FinalNum = x + y;
		} 
		return FinalNum;
	} 
	
	// Finally, this method produces the number of days for the users next birthday using if/else statements.
    public static int nextBDay( int dayofyear, int absoluteday){
    	int birthday = absoluteday;
    	int tempvalue = 0;
    	if ( birthday - dayofyear < 0){
    		tempvalue = birthday - dayofyear + 365;
    	} else {
    		tempvalue = birthday - dayofyear;
    	}
    	return tempvalue;
    }
}