package CreditCardValidation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreditCardValidation {

	public static boolean isValid(long number) {
		// Method that checks if card number is valid
		int sum = sumOddPlaces(number) + sumOfDoubleEvenPlaces(number);
		if ((getPrefix(number, 4) == 4) || (getPrefix(number, 5) == 5)
				|| (getPrefix(number, 6) == 6) || (getPrefix(number, 37) == 37)) {
			if (sum % 10 == 0) {
				return true;
			}

		}
		return false;
	}

	public static int sumOddPlaces(long cardNumber) {
		// Method that adds and returns digits on odd places
		int oddPlacesSum = 0;
		String reverseCardNumber = "";
		String sNumber = cardNumber + "";
		for (int i = sNumber.length() - 1; i >= 0; i--) {
			reverseCardNumber += sNumber.charAt(i);
		}

		for (int i = 0; i < reverseCardNumber.length(); i += 2) {
			int digit = Integer.parseInt(reverseCardNumber.charAt(i) + "");
			oddPlacesSum += digit;

		}
		return oddPlacesSum;

	}

	public static int sumOfDoubleEvenPlaces(long number) {
		// Method that sums up digits on even places
		int evenPlacesSum = 0;
		String reverseCardNumber = "";
		String sNumber = number + "";
		for (int i = sNumber.length() - 1; i >= 0; i--) {
			reverseCardNumber += sNumber.charAt(i);
		}

		for (int i = 1; i < reverseCardNumber.length(); i += 2) {
			int digit = Integer.parseInt(reverseCardNumber.charAt(i) + "");
			evenPlacesSum += getDigit(digit);
		}
		return evenPlacesSum;

	}

	public static int getDigit(int number) {
		// Method that returns 2*digit or sum of digits if digit is larger than
		// 10
		int doubleNumber = number * 2;
		if (doubleNumber < 10) {
			return doubleNumber;
		} else {

			int sum = 0;
			for (int i = 0; i < 2; i++) {
				sum += doubleNumber % 10;
				doubleNumber /= 10;

			}

			return sum;

		}
	}

	public static int getSize(long d) {
		// Method that returns size
		return (d + "").length();
	}

	public static boolean prefixMatched(long number, int d) {
		// Checks if prefix is correct
		String sNumber = number + "";
		String prefix = d + "";
		String inputPrefix = "";
		if (prefix.length() == 2) {
			inputPrefix = sNumber.charAt(0) + sNumber.charAt(1) + "";
		} else if (prefix.length() == 1) {
			inputPrefix = sNumber.charAt(0) + "";
		}
		if (inputPrefix.equals(prefix)) {
			return true;
		} else {
			return false;
		}

	}

	public static long getPrefix(long number, int k) {
		// returns prefix if prefix is correct if not returns card number
		if (prefixMatched(number, k)) {
			return (long) k;
		} else {
			return number;
		}
	}
}
