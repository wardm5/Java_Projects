// CS210 Assignment #4 "Word Count"
// Michael Ward

// This program uses parameters and methods which if called will determine how many words are within the string.
public class WordCount{
	public static void main(String[] args){
		wordCount("hello");
		wordCount("how are you?");
		wordCount("    how are you?");
		wordCount("how are you?    ");
		wordCount("how are you ?");
		wordCount("I am 3 years old");
		wordCount("3 x 4 = 12");
		wordCount("Characters !@#$%^&*");
		wordCount("    ");
	}
	
	//  This method uses loops and if/else statements to go through the string provided in the parameter 
	//  and determine the amount of words and return # of words..
    public static void wordCount(String inputString) {
	int sum = 0;
    	if (inputString.length() == 0)
    		sum = 0;
    	else {
		if (inputString.charAt(0) != ' ')
			sum = sum + 1;
	    	for (int letterNum = 0; letterNum <= inputString.length() - 1; letterNum++){
			if (inputString.charAt(letterNum) == ' ')
				sum = sum + 0;
			if (inputString.charAt(letterNum) != ' ' && inputString.charAt(Math.max(letterNum - 1, 0)) == ' ')
				sum++;
	    	}
    	} 
	System.out.println(sum);
    }
}
