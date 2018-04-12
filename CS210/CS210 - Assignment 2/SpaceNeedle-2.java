// CS210 Assignment #2 "Space Needle"
// Michael Ward
// This code uses methods and for loops (sometimes nested) to create the Space Needle.
public class SpaceNeedle {
    public static void main(String[] args) {
        drawSpaceNeedle();  
    }

// This sets the constant "test" to an integer value which modifies the output.
final static int test = 4;

// This method draws each other methods part, and will be called by the main method.
    public static void drawSpaceNeedle() {  
    	Needle();
    	Top();
    	Line();
    	Bottom();
    	Needle();
    	Base();
    	Top();
    	Line();
    	System.out.println();	
    }
    
//This method draws the needle of the Space Needle.
    public static void Needle() {
        for ( int i = 1; i <= test; i ++) {
        	for ( int k = 1; k <= (test * 3); k++) {
        		System.out.print(" ");
        	}
        	System.out.println("||");
        }
    }

//This code constructs the top of the Space Needle.
    public static void Top() {
    	for (int x = 1; x <= test; x++) {
    		for (int i = 1; i <= ((test-x) * 3); i++) {
    			System.out.print(" ");	
    		}
    		System.out.print("__/");
        	for (int i = 1; i < (x * 3) -2; i++) {
        		System.out.print(":");
        	}
    		System.out.print("||");
    		for (int i = 1; i < (x * 3) -2; i++) {
        		System.out.print(":");
        	}
    		System.out.print("\\__");	
        	System.out.println();
    	}
    }

// This method creates the bottom of the Space Needle.
    public static void Bottom() {
    	for ( int i = 1; i <= test; i++) {
    		for (int j = 1; j <= (i * 2) - 2; j++) {
    			System.out.print(" ");
    		}
    		System.out.print("\\_");
    		for (int k = 1; k <= ((test * 3) + 1) - (i * 2); k++) {
    			System.out.print("/\\");
    		}
    		System.out.print("_/");
    	
    		System.out.println();	
    	}
    }

//This method creates the base of the Space Needle (base meaning base of the tower, not the stand of the building.
    public static void Base(){
    	for (int i = 1; i <= test * test; i++){
    		for (int k = 1; k <= (test * 2) +1; k++) {
    			System.out.print(" ");
    		}
	    	System.out.print("|");
	    	for (int m = 1; m < (test - 1); m++) {
	    		System.out.print("%");
	    	//System.out.println();
	    	}
	    	System.out.print("||");
	    	for (int m = 1; m < (test - 1); m++) {
	    		System.out.print("%");
	    	//System.out.println();
	    	}	    	
	    	System.out.print("|");
	    	System.out.println();
    	}
    }
    
// This code draws the line at the bottom and in-between the top and bottom of the Space Needle.
    public static void Line() {
    	System.out.print("|");
    	for (int i = 1; i <= (test * 6) ; i++) {
    		System.out.print("\"");
    	}
    	System.out.println("|");
    }
}