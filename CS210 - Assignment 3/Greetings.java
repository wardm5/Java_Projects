// CS210 Assignment #3 "Greetings"
// Michael Ward

//Importing classes from a package utilities
import java.util.*;

/*This code will ask an user 3 basic questions, then provide a greeting statement combining the user's responses.
  This code also includes a method called a constructor for console input.*/
public class Greetings {
    public static void main(String[] args) {        
        Scanner s = new Scanner(System.in);
        System.out.println(getGreetings(s));
    }

//This method contains the feedback questions and response print return statement
    private static String getGreetings(Scanner console) {        
        System.out.print("Please enter your first name: ");
        String FirstName = console.nextLine();
        FirstName = FirstName.substring(0, 1).toUpperCase() + ".";
        System.out.print("Please enter your last name: ");
        String LastName = console.nextLine();
        LastName = LastName.substring(0, 1).toUpperCase() +  LastName.substring(1/*, LastName.indexOf(" ")*/);
        System.out.print("Please enter your year of birth: ");
        int Age = console.nextInt();
        Age = getCurrentYear() - Age;

    	return "Greetings " + FirstName + " " + LastName + "! You are about " + Age + " years old.";
    }

    // Get the current year
    //   you may find this method useful when calculating the age -- feel free to use it - Definitely was useful, thank you.
    private static int getCurrentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}

