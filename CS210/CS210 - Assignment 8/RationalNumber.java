// CS210 Assignment #8 "Rational Number"
// Michael Ward

// This code produces a class that can be called which produces a fraction when given the inputs for a denominator and numerator.
public class RationalNumber {
	private int numerator;		// creates a private field numerator
	private int denominator; 	// creates a private field denominator
		
	// pulls in both the numerator an denominator and constructs them (C). 
	public RationalNumber(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	// If there is no numbers provided by the user, the default is set to 0/1 (C). 
	public RationalNumber() {
		this.numerator = 0;
		this.denominator = 1;
	}
	
	// This returns the denominator when called (D). 
	public int getDenominator() {
		return this.denominator;
	}
	
	// This returns the numerator when called (D).
	public int getNumerator() {	
		return this.numerator;
	}

	// This returns the String form that the fraction will show as when called (E).
	public String toString() {
		if (this.denominator == 1) {
			return this.numerator + "";
		} else if (this.numerator == 0) {
			return 0 + "";
		} else {
			return this.numerator + "/" + this.denominator;
		}
		
	}
	
	// This will produce the addition of two different fractions of which the user inputed using if/else statements (F).
	public RationalNumber add(RationalNumber other) {
		int numeratorTotal;
		int denmoniatorTotal;
		
		if (this.getDenominator() == other.getDenominator()) {
			numeratorTotal = this.getNumerator() + other.getNumerator();
			denmoniatorTotal = this.getDenominator();
		} else {
			denmoniatorTotal = this.getDenominator() * other.getDenominator();
			numeratorTotal = (this.getNumerator() * other.getDenominator()) + (other.getNumerator() * this.getDenominator());
		}
		RationalNumber addition = new RationalNumber(numeratorTotal,denmoniatorTotal); 
		
		return addition;
	}

	// This will produce the subtraction of two different fractions of which the user inputed using if/else statements (F).
	//***I did not change "other" as the method signature since it is what was in the orginal file.***
	public RationalNumber subtract(RationalNumber other) {
		int numeratorTotal;
		int denmoniatorTotal;
		
		if (this.getDenominator() == other.getDenominator()) {
			numeratorTotal = this.getNumerator() - other.getNumerator();
			denmoniatorTotal = this.getDenominator();
		} else {
			denmoniatorTotal = this.getDenominator() * other.getDenominator();
			numeratorTotal = (this.getNumerator() * other.getDenominator()) - (other.getNumerator() * this.getDenominator());
		}
		RationalNumber subtraction = new RationalNumber(numeratorTotal,denmoniatorTotal); 
		
		return subtraction;
	}

	// This will produce the multiplication of two different fractions of which the user inputed using variables (F).
	public RationalNumber multiply(RationalNumber other) {
		int numeratorTotal;
		int denmoniatorTotal;
		
		numeratorTotal = this.getNumerator() * other.getNumerator();
		denmoniatorTotal = this.getDenominator() * other.getDenominator();
		
		RationalNumber mult = new RationalNumber(numeratorTotal,denmoniatorTotal); 
		
		return mult;
	}

	// This will produce the division of two different fractions of which the user inputed using variables and passing the results through
	// the multiply method (F).
	public RationalNumber divide(RationalNumber other) {
		int newNumerator;
		int newDenominator;
		
		newNumerator = other.getDenominator() ;
		newDenominator = other.getNumerator() ;
		
		RationalNumber newNumber = new RationalNumber(newNumerator,newDenominator); 
		RationalNumber division = newNumber.multiply(this);
		
		return division;
	}
}
