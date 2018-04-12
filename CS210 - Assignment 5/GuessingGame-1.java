// CS210 Assignment #5 "GuessingGame"
// Michael Ward

import java.util.*;

// This program runs a game that uses a random number generator and asks the user to guess the number, then provides the user statistics on how they did.
public class GuessingGame {

    public static void main(String[] args) {

        // Starts with variable declarations for # of games, total guesses, min score, guess game ratio, and continue game (and scanner).
        Scanner console = new Scanner(System.in);
    	int gameTracker = 0;
    	int totalGuessTracker = 0;
    	int minScore = 10000;
    	double guessGameRatio = 1.0;
    	String continueGame =" ";
    	
    	// do loop to setup the random number (which will reset when the user starts a new game), ask the user for a number.
    	do {
            Random r = new Random();
            int number = r.nextInt(100) + 1;
            System.out.println("I'm thinking of a number between 1 and 100...");
        	System.out.print("Your guess? ");
        	int guess = console.nextInt();
        	int guessTracker = 1;
            
        	// the while loop runs through the game, asking the user for more numbers and gives hints if 
        	//not correct (while keeping track of how many guesses there were).
	    	while (guess != number) {
	    			if (number > guess) {
	    				System.out.println("It's higher.");
	    			} else {
	    				System.out.println("It's lower.");
	    			}
	    			System.out.print("Your Guess? ");
	    			guess = console.nextInt();
	    			guessTracker = guessTracker + 1;
	    			
	    	}
	    	//the end of the do while loop tells the user how many times he/she had to guess to get it right 
	    	//and if they want to play again (exits if they don't).
	    	totalGuessTracker = totalGuessTracker + guessTracker;
	    	
		    System.out.println("You guessed it in " + guessTracker + " guesses!");
		    System.out.print("Play again? ");
		    continueGame = console.next();
		    System.out.println();
		    continueGame = continueGame.toUpperCase();
		    if ( guessTracker < minScore){
		    	minScore = guessTracker;
		    } 
		    gameTracker = gameTracker +1;
	    	guessGameRatio = (double) totalGuessTracker / (double) gameTracker;
	    	
    	} while (continueGame.charAt(0) == 'Y');
    	
    	// Finally, once the game is over, the user will receive the statistics.
    	System.out.println("Your overall results: ");
    	System.out.println("Total games = " + gameTracker);
    	System.out.println("Total guesses = " + totalGuessTracker);
    	System.out.printf("Guesses/game = %.1f \n",  guessGameRatio );
    	System.out.println("Best game = " + minScore);
    }
}