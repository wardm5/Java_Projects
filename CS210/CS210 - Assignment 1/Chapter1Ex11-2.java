// CS210 Winter 2017 Section OAS
// Michael Ward
// Prints two rockets blasting off using static methods for structure and reduce redundancy.

public class Chapter1Ex11 {
    public static void main(String[] args) {
    	cone();
    	box();
    	words();
    	box();
    	cone();
    }
    //Draws the cones of the rockets/fire from the rocket engines
    public static void cone() {
    	System.out.println("   /\\        /\\");
    	System.out.println("  /  \\      /  \\");    		
    	System.out.println(" /    \\    /    \\");     		
    }
    //Draws the boxes of the rocket ships.
    public static void box() {
    	System.out.println("+------+  +------+");
    	System.out.println("|      |  |      |");
    	System.out.println("|      |  |      |");
    	System.out.println("+------+  +------+");
    }
    //Draws and writes the words on the rocket ships.
    public static void words() {
    	System.out.println("|United|  |United|");
    	System.out.println("|States|  |States|");
    }
 }

