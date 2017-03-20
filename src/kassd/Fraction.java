/**
 * SE 1011
 * Winter 2010-2011
 * Lab 6
 * Dan Kass
 * 2/3/11
 */
package kassd;

public class Fraction {

	// Variables for Fraction class
	private int numerator;
	private int denominator;
	private static boolean decimalFormatSelected = true;

	public boolean setDeciamlFormatSelected() {
		return decimalFormatSelected;
	}

	public static void setDecimalFormatSelected(boolean decimalFormat) {
		Fraction.decimalFormatSelected = decimalFormat;
	}

	// sets the numerator and denominator for the new fraction
	public Fraction(int numerator, int denominator) {
		// if the denominator is 0 it will turn the fraction to be a zero number
		if (denominator == 0) {
			this.numerator = 0;
			this.denominator = 1;
		}// if the denominator is a negative number it moves the negative sign
			// to the Numerator
		else if (denominator < 0) {
			this.numerator = -numerator;
			this.denominator = -denominator;
		}// for the normal numbers to be set to a fraction
		else {
			this.numerator = numerator;
			this.denominator = denominator;
		}
	}

	/**
	 * Compute the sum of the current object and another Fraction.
	 * @param frac other fraction to be added to the current fraction
	 * @return a new Fraction object with a value equal to the sum.
	 */
	public Fraction add(Fraction frac) {
		int numAnswer;
		int denomAnswer;
		Fraction sum;
		// for the case when the denominators are equal
		if (this.denominator == frac.denominator) {
			numAnswer = this.numerator + this.denominator;
			denomAnswer = this.denominator;
			sum = new Fraction(numAnswer, denomAnswer);
		}// for when the denominators are different
		else {
			numAnswer = ((this.numerator * frac.denominator) + (frac.numerator * this.denominator));
			denomAnswer = (this.denominator * frac.denominator);
			sum = new Fraction(numAnswer, denomAnswer);
		}
		// returns a new fraction that is the sum
		return sum;

	}

	// Subtraction
	public Fraction subtract(Fraction frac) {
		int numAnswer;
		int denomAnswer;
		Fraction difference;
		// for the case when the denominators are equal
		if (this.denominator == frac.denominator) {
			numAnswer = this.numerator - frac.numerator;
			denomAnswer = this.denominator;
			difference = new Fraction(numAnswer, denomAnswer);
		}// for when the denominator are equal
		else {
			numAnswer = ((this.numerator * frac.denominator) - (frac.numerator * this.denominator));
			denomAnswer = (this.denominator * frac.denominator);
			difference = new Fraction(numAnswer, denomAnswer);
		}
		// returns a new fraction that is the difference
		return difference;
	}

	// Multiplication
	public Fraction multiply(Fraction frac) {
		int numAnswer = (this.numerator * frac.numerator);
		int denomAnswer = (this.denominator * frac.denominator);
		Fraction product = new Fraction(numAnswer, denomAnswer);
		return product;
	}
	
	//division
	public Fraction divide(Fraction frac) {
		Fraction quotient;
		int numAnswer;
		int denomAnswer;
		if(frac.numerator == 0){
			numAnswer = 0;
			denomAnswer = 1;
			quotient = new Fraction(numAnswer, denomAnswer);
		}else{
			numAnswer = (this.numerator * frac.denominator);
			denomAnswer =(this.denominator * frac.numerator);
			quotient = new Fraction(numAnswer, denomAnswer);
		}
		return quotient;
	}

	// the Equals method
	public boolean equals(Fraction frac) {
		boolean equals;
		if ((this.numerator * frac.denominator) == (frac.numerator * this.denominator)) {
			equals = true;
		} else {
			equals = false;
		}
		return equals;
	}
	
		// For the Greatest common divisor
		private static int gcd(int num, int denom){
			while(denom != 0){
				int temp = denom;
				denom = num % denom;
				num = temp;
		}
			return num;
		}// reduces the fractions to their simplest form
		public void reduce(){
			int temp = gcd(this.numerator, this.denominator);
			 int num = this.numerator;
			 int denom = this.denominator;
			 this.numerator = (num / temp);
			 this.denominator = (denom /temp);
			
		}
	

	public String toString() {
		String answer;
		// turns the fraction form into a string showing a fraction
		if (decimalFormatSelected == false) {
			Fraction temp = new Fraction (this.numerator, this.denominator);
			temp.reduce();
			int num = temp.numerator;
			int denom = temp.denominator;
			answer = (num + "/" + denom);
		} // turns the fraction form into a decimal
		else {
			double decimal = ((double) this.numerator / (double) this.denominator);
			answer = Double.toString(decimal);
		}
		return answer;
	}

	// determines if it is set to returns decimals or to return fractions
	public static boolean isDecimalFormatSelected() {
		return decimalFormatSelected;
	}
}
