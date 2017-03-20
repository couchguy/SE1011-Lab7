/**
 * SE 1011
 * Winter 2010-2011
 * Lab 6
 * Dan Kass
 * 2/3/11
 */
package kassd;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Lab7 {
	/*
	 * Keep Running while the user didn't hit cancel 
	 * 		Set The First Fraction with a random Numerator and Denominator 
	 * 		Set The Second Fraction with a randoM Numerator and Denominator 
	 * 		Set a random Value to determine which Math operation is used 
	 * 		ask the user the question Fraction one "math operation" fraction two 
	 * 			if the answer isn't null set it to Fraction Answer 
	 * 			if it is null tell the program to stop running and 
	 * 				tell the user how they got correct and incorrect 
	 * 			compare Fraction Answer to Correct Answer 
	 * 				if it is correct add one to the correct count 
	 * 				if it is incorrect add one to the incorrect count
	 */

	public static void main(String[] args) {
		// makes the program work in Fractions not decimals
		Fraction.setDecimalFormatSelected(false);
		// allows the program to run
		boolean go = true;
		// counts the correct and incorrect answers
		int correct = 0;
		int incorrect = 0;
		while (go) {
			// sets the random numbers for fraction one and two
			double num = (Math.random()) * 50;
			double denom = (Math.random()) * 50;
			double num2 = (Math.random()) * 50;
			double denom2 = (Math.random()) * 50;

			Fraction fractionOne = new Fraction((int) num, (int) denom);
			Fraction fractionTwo = new Fraction((int) num2, (int) denom2);
			// picks the random number to choose the math operation
			double chooserTemp = (Math.random()) * 4;
			int chooser = (int) chooserTemp;

			Fraction answer;
			int answerNum = 0;
			int answerDenom = 0;
			Fraction correctAnswer;
			// shows the user what math operation to use and sets the correct answer
			if (chooser == 0) {
				JOptionPane.showMessageDialog(null, "Add " + fractionOne
						+ " with " + fractionTwo);
				Fraction sum = fractionOne.add(fractionTwo);
				correctAnswer = sum;
			} else if (chooser == 1) {
				JOptionPane.showMessageDialog(null, "Subtract " + fractionOne
						+ " by " + fractionTwo);
				Fraction difference = fractionOne.subtract(fractionTwo);
				correctAnswer = difference;
			} else if (chooser == 2) {
				JOptionPane.showMessageDialog(null, "Multiply " + fractionOne
						+ " with " + fractionTwo);
				Fraction product = fractionOne.multiply(fractionTwo);
				correctAnswer = product;
			} else {
				JOptionPane.showMessageDialog(null, "Divide " + fractionOne
						+ " by " + fractionTwo);
				Fraction quotient = fractionOne.divide(fractionTwo);
				correctAnswer = quotient;
			}
			// asks the user for thier answer
			String userAnswer = JOptionPane
					.showInputDialog("Please enter your answer \n"
							+ "(Please seperate the numerator and denominator with a space)"
							+ "\n To exit hit cancel");
			// gets the numbers
			if (userAnswer != null) {
				Scanner scan = new Scanner(userAnswer);
				boolean first = true;
				while (scan.hasNextInt()) {
					if (first) {
						answerNum = scan.nextInt();
						first = false;
					} else {
						answerDenom = scan.nextInt();
					}
				}//sets the number to a Fraction
				answer = new Fraction(answerNum, answerDenom);
				// when you get it correct
				if (answer.equals(correctAnswer)) {
					correct++;
					JOptionPane.showMessageDialog(null,
							"Good Job!! You are correct!");
				} // when you get it wrong
				else {
					JOptionPane
							.showMessageDialog(null,"Sorry that answer is incorrect the answer is "
											+ correctAnswer.toString()
											+ "\nMake sure that you are typeing in with a space and not a Slash.");
					incorrect++;
				}
			} // when it leaves the program
			else {
				go = false;
				JOptionPane.showMessageDialog(null,
						"Thank you for Playing \n You got " + correct
								+ " correct. \n You got " + incorrect
								+ " incorrect.");
			}
		}
	}
}