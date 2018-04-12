// CS210 Assignment #7 "Personality Test"
// Michael Ward

import java.io.*;
import java.util.*;

// This program scans a file, then parses the data into arrays and  
// then provides the user statistics on personalities for the characters within the file.
public class PersonalityTest {
    public static void main(String[] args) 
			throws FileNotFoundException {
    	String name = "";
    	String data = "";
		giveIntro();
		Scanner input = new Scanner(new File("personality.txt"));
    	arrayMethod(input, name, data);
    }
    
    // This method provides the introduction.
    public static void giveIntro(){
    	System.out.println("** This program reports the results for Keirsey Personality Test **");
    }
    
    // This method scans the data file and provides the strings for which the arrays will be based on.
    public static void arrayMethod( Scanner input, String name, String data) {
		while (input.hasNextLine()) {
    		name = input.nextLine();
    		data = input.nextLine();
    		char[] data1 = new char[70];
    		for (int k = 0; k <= data.length()-1; k++){
    			data1[k] = data.charAt(k);
    		}
    		analyze(data1, name);
		}
    }
    
    // This method declares the main arrays for the program which will contain the counts of A's, B's and percent of B, and type of personality.
    public static void analyze(char[] data, String name){
    	int [] sumDataA = new int[4];
    	int [] sumDataB = new int[4];
    	int [] percentData = new int[4]; 
    	String[] type = new String[4];
    	
    	System.out.println(name + ":");
    	// This code creates the sumDataA and B arrays which keep track of the amount of A's and B's
    	for (int j = 0; j <= 3; j++){
    		if (j == 0) {
            	for (int i = 0; i <= 70 -1 ; i++){
            		if( i % (7) == 0) {
                		if ( data[i] == 'A' || data[i] == 'a'){
               			 sumDataA[j] += 1;
                		}
                		if ( data[i ] == 'B' || data[i] == 'b'){
               			 sumDataB[j] += 1;
                		}
            		}
            	}
    		} else {
            	for (int i = 0; i <= 70 -1 ; i++){
            		if( i % (7) == j *2 -1  || i % (7) == j *2) {
                		if ( data[i] == 'A' || data[i] == 'a'){
               			 sumDataA[j] += 1;
                		}
                		if ( data[i ] == 'B' || data[i] == 'b'){
               			 sumDataB[j] += 1;
                		}
            		}
            	}
    		} 
    	}
    	// This code calculates the percent of B's by using a loop.
    	for (int i = 0; i <= 3; i++){
    		int tempInt = 0;
    		double temp = Math.round((sumDataB[i] * 100 + 0.0) / (sumDataA[i] + sumDataB[i] +0.0));
    		tempInt = (int) temp;
    		percentData[i] = tempInt ;
    	}
    	// This code determines the personality type by using loops and if statements.
    	for (int i = 0; i <= 3; i++){
    		if (i == 0){
    			if (percentData[i] == 50){
    				type[i] = "X";
    			} else if (percentData[i] > 50){
    				type[i] = "I";
    			} else {
    				type[i] = "E";
    			}
    		}
    		if (i == 1){
    			if (percentData[i] == 50){
    				type[i] = "X";
    			} else if (percentData[i] > 50){
    				type[i] = "N";
    			} else {
    				type[i] = "S";
    			}
    		}
    		if (i == 2){
    			if (percentData[i] == 50){
    				type[i] = "X";
    			} else if (percentData[i] > 50){
    				type[i] = "F";
    			} else {
    				type[i] = "T";
    			}
    		}
    		if (i == 3){
    			if (percentData[i] == 50){
    				type[i] = "X";
    			} else if (percentData[i] > 50){
    				type[i] = "P";
    			} else {
    				type[i] = "J";
    			}
    		}	
    	}
    	report(sumDataA, sumDataB , percentData, type);
    }
    
    // This method creates much of the report to the user by passing in the arrays.
    public static void report(int[] dataA, int[] dataB, int[]percentData, String[] type){	
    	System.out.print("answers: ");
    	answers(dataA, dataB);
    	System.out.print("percent B: ");
    	System.out.println(Arrays.toString(percentData));
    	System.out.print("type: ");
    	type(type);
    	System.out.println("");
    	
    }
    // This method organizes the information regarding A's and B's by using if and loops (fence post problem).
    public static void answers(int[] dataA, int[] dataB){
    	if (dataA.length == 0){
    		System.out.println("[]");
    	} else {
    		System.out.print("["+  dataA[0 ] + "A" + "-" + dataB[0 ] + "B");
    		for (int i = 1; i <= 3; i ++ ){
    			System.out.print( ", " +  dataA[  i  ] + "A" + "-" + dataB[ i] + "B" );
    		}
    		System.out.println("]");
    	}
    }
    // This method organizes the information regarding A's and B's by using if and loops (fence post problem).
    public static void type(String[] data){
    	for (int i = 0; i <= 3; i++){
    		System.out.print(data[i]);
    	}
    	System.out.println("");
    }
}