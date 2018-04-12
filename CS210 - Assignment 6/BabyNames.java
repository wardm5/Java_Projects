// CS210 Assignment #6 "baby names"
// Michael Ward

//Imports java libraries
import java.io.*;
import java.util.*;
import java.awt.*;

//This program allows the user to search a text file, then tells the user the popularity of the name (if possible).
//It also presents a graph to the user if the name is correct.

// Main method, gives intro into the program, sets up variables, and calls methods
public class BabyNames {
    public static void main(String[] args) 
    		throws FileNotFoundException {
    	giveIntro();
    	Scanner console = new Scanner(System.in);
    	System.out.print("name? ");
    	String name = console.next();
    	name = name.substring(0,1).toUpperCase() + name.substring(1, name.length()).toLowerCase() ;
    	Scanner input = new Scanner(new File("names.txt"));
    	
    	String temp = find(name , input);
    	printStats(temp);
    	if (!temp.equals("name not found.")){
    		outputStats(temp, name);
    		graphics(name , temp);
    	}
    }
    
    //Gives a brief intro into for the user.
    public static void giveIntro(){
    	System.out.println("** Popularity of a baby name since year 1920 **");
    }
    
    //This method searches the user's computer for a match for the user inputed name, then returns
    // the string of popularity rankings.
    public static String find(String name, Scanner input) {
    	while (input.hasNextLine()) {
    		String babyName = input.next(); 
    		int i = 0;
    		name = name.toUpperCase();
    		babyName = babyName.toUpperCase();
    		if (name.equals(babyName)) {
    			return input.nextLine();
    		} else input.nextLine();
    		
    	}
    	return "name not found.";
    }
    
    //This method prints the popularity statistics from the string which was produced from the "find" method.
    public static void printStats(String temp){
    	Scanner input = new Scanner(temp);
    	int i = 0;
		while (input.hasNextInt()){
			int rank = input.nextInt();
			System.out.println(1920 + (i * 10) + " : " + rank);
			i++;
		} 
    	if (i == 0) {
    		System.out.println("name not found.");
    	}
    }
    
    //This method, when a name appears in the data, will produce an output file with the user name and stats.
    public static void outputStats(String temp, String name)
			throws FileNotFoundException{
    	PrintStream output = 
    			new PrintStream(new File(name + ".txt"));
    	Scanner input = new Scanner(temp);
    	int i = 0;
    	output.println(name + ",");
		while (input.hasNextInt()){
			int rank = input.nextInt();
			output.print(1920 + (i * 10) + " : " + rank);
			i++;
			if ( input.hasNextInt()) {
				output.println(",");
			}
		} 
    }
    //This code creates the graph and then calls on "graphicsData" to draw the data for the graph.
    public static void graphics(String name , String temp) {
    	DrawingPanel panel = new DrawingPanel(520, 590);
    	Graphics g = panel.getGraphics();
    	g.drawString(name, 240, 20);
    	for (int i = 0; i <= 8; i++){
    		g.drawRect( 10 + (i * (500/9)), 30, (500/9), 545);
    	}
    	for (int i = 0; i <= 8; i++){
    		g.drawString( "" + (1920 + (i * 10)), 20 + (i * (55)) , 560 );
    	}
    	g.drawRect(10, 30, 495, 500);	
    	graphicsData(temp, g);
    }
    //Finally, this code draws the statistics from the data onto the graph using parameters.
    public static void graphicsData(String temp, Graphics g){
    	Scanner input = new Scanner(temp);
    	int i = 0;
    	int rank = -1;
    	int prevx = -1;
    	while (input.hasNextInt()){
    		int rank2 = input.nextInt(); 
    	    if (rank !=-1) {  // if not the first dot, then draw line from previous dot and current dot.
    	    	if (rank2 == 0) {  // if the data point is equal to 0, then plot at zero point (530)
        	    	g.drawLine( 35 + (i * (55))  , prevx,  35 + ( (i + 1) * (55)) , 530);
        	    	prevx = 530;
        	    	i++;
    	    	} else {     // if the dot is drawn between the previous dot and the current dot.
	    	    	g.drawLine( 35 + (i * (55))  , prevx,  35 + ( (i + 1) * (55)) , (rank2/2) + 30);
	    	    	i++;
	    	    	prevx = (rank2/2) + 30;
    	    	}	
    	    }
    	    rank = rank2;    //updating rank value for loop.
    	    if (rank == 0) {     // if rank = 0, then set value to 530
    	    	if (prevx == -1){    // if first rank has no value, set it to 0 value (530)
    	    		prevx = 530;
    	    	}
    	    	g.drawOval(35 + (i * (55)) -5, 530 - 5, 10, 10);
        	    g.drawString("" + (rank), 35 + (i * (55)) + 10, 530 - 5);
    	    } else {        // if not zero, draw the circle and data point.
    	    	if (prevx == -1){
    	    		prevx = (rank/2) + 30 - 5;
    	    	}
	    	    g.drawOval(35 + (i * (55)) -5, (rank/2) + 30 - 5, 10, 10);
	    	    g.drawString("" + (rank), 35 + (i * (55)) + 10, (rank/2) + 30 - 5);
    	    } 
    	}
    }
}
