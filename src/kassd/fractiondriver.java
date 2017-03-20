/**
 * SE 1011
 * Winter 2010-2011
 * Lab 6
 * Dan Kass
 * 2/3/11
 */
package kassd;

public class fractiondriver {

	public static void main(String[] args) {

		Fraction.setDecimalFormatSelected(false);
		
		Fraction fractionOne = new Fraction(2, 4);
		Fraction fractionTwo = new Fraction(6, 12);
		
		System.out.println("Is it set to Return Fractions? " + Fraction.isDecimalFormatSelected());
		
		Fraction sum = fractionOne.add(fractionTwo);
		Fraction difference = fractionOne.subtract(fractionTwo);
		Fraction product = fractionOne.multiply(fractionTwo);
		Fraction divide = fractionOne.divide(fractionTwo);
		

		System.out.println("Your fisrt fraction is " + fractionOne.toString());
		System.out.println("Your second fraction is " + fractionTwo.toString());
		System.out.println("When you add those two togeather you get "
				+ sum.toString());
		System.out
				.println("When you subtract the first one to the second one you get "
						+ difference.toString());
		System.out.println("When you multiply them togeather you get "
				+ product.toString());
		System.out.println("when you divide them togeather you get " + divide.toString());
		System.out.println("Are your two Fractions Equal? " + fractionOne.equals(fractionTwo));
		
	}
}

