package kassd;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class lab7redo {
	/*
	 * Keep Running while the user didn't hit cancel Set The First Fraction with
	 * a random Numerator and Denominator Set The Second Fraction with a random
	 * Numerator and Denominator Set a random Value to determine which Math
	 * operation is used` ask the user the question Fraction one
	 * "math operation" fraction two if the answer isn't null set it to Fraction
	 * Answer if it is null tell the program to stop running and tell the user
	 * how they got correct and incorrect compare Fraction Answer to Correct
	 * Answer if it is correct add one to the correct count if it is incorrect
	 * add one to the incorrect count
	 */

	public static void main(String[] args) {
		Fraction.setDecimalFormatSelected(false);
		boolean go = true;
		int correct = 0;
		int incorrect = 0;
		while (go) {
			double num = (Math.random()) * 50;
			double denom = (Math.random()) * 50;
			double num2 = (Math.random()) * 50;
			double denom2 = (Math.random()) * 50;

			Fraction fractionOne = new Fraction((int) num, (int) denom);
			Fraction fractionTwo = new Fraction((int) num2, (int) denom2);

			double chooserTemp = (Math.random()) * 4;
			int chooser = (int) chooserTemp;

			Fraction answer;
			int answerNum = 0;
			int answerDenom = 0;
			Fraction correctAnswer;

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

			String userAnswer = JOptionPane
					.showInputDialog("Please enter your answer \n"
							+ "(Please seperate the numerator and denominator with a space)"
							+ "\n To exit hit cancel");

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
				}
				answer = new Fraction(answerNum, answerDenom);
				if (answer.equals(correctAnswer)) {
					correct++;
					JOptionPane.showMessageDialog(null,
							"Good Job!! You are correct!");
				} else {
					JOptionPane
							.showMessageDialog(null,"Sorry that answer is incorrect the answer is "
											+ correctAnswer.toString()
											+ "\nMake sure that you are typeing in with a space and not a Slash.");
					incorrect++;
				}
			} else {
				go = false;
				JOptionPane.showMessageDialog(null,
						"Thank you for Playing \n You got " + correct
								+ " correct. \n You got " + incorrect
								+ " incorrect.");
			}
		}
	}
}
