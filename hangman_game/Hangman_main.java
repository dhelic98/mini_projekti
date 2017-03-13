package hangman_game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Hangman_main {

	public static void main(String[] args) throws IOException {

		Scanner uInput = new Scanner(System.in);
		// Initializing arrayList and loading words from file

		ArrayList<Word> listOfWords = new ArrayList<>();
		FileHandling.copyFromFileToList(listOfWords);
		if (listOfWords.isEmpty()) {
			System.out.println("Enter words into file please");
			System.exit(0);
		}
		// ArrayList for letter
		ArrayList<Character> letters = new ArrayList<>();
		// Declaring random and getting random word from arrayList
		Random r = new Random();
		int wordIndex = r.nextInt(listOfWords.size());
		String gameWord = listOfWords.get(wordIndex).toString();

		// Variable for tracking game progress
		int missCounter = 0;

		Character[] wordIntoChar = new Character[gameWord.length()];
		for (int i = 0; i < wordIntoChar.length; i++) {
			wordIntoChar[i] = gameWord.charAt(i);
		}
		Character[] asteriks = new Character[wordIntoChar.length];
		for (int i = 0; i < asteriks.length; i++) {
			asteriks[i] = '*';
		}

		System.out.println("Good luck!!!");
		// Loop for game
		while (true) {
			try {
				// Calling method that checks if game is won/over
				if (isGameWon(asteriks, wordIntoChar)) {
					printOutWordArray(asteriks);
					System.out.println("\nGood job.You won");
					break;
				}
				// Miss counting
				if (missCounter == 0) {
					Shape.printHanger();
					printOutWordArray(asteriks);
					char letter = printGuess(uInput);
					if (letters.contains(letter)) {
						System.out.println("\nLetter already tried");
						continue;
					}
					letters.add(letter);
					if (checkingLetter(wordIntoChar, asteriks, letter)) {

						continue;
					} else {
						System.out.println("Bad luck");
						missCounter++;
					}

				} else if (missCounter == 1) {
					Shape.print1stmiss();
					printOutWordArray(asteriks);
					char letter = printGuess(uInput);
					if (letters.contains(letter)) {
						System.out.println("\nLetter already tried");
						continue;
					}
					letters.add(letter);
					if (checkingLetter(wordIntoChar, asteriks, letter)) {

						continue;
					} else {
						System.out.println("Bad luck");
						missCounter++;
					}
				} else if (missCounter == 2) {
					Shape.print2ndmiss();
					printOutWordArray(asteriks);
					char letter = printGuess(uInput);
					if (letters.contains(letter)) {
						System.out.println("\nLetter already tried");
						continue;
					}
					letters.add(letter);
					if (checkingLetter(wordIntoChar, asteriks, letter)) {

						continue;
					} else {
						System.out.println("Bad luck");
						missCounter++;
					}
				} else if (missCounter == 3) {
					Shape.print3rdmiss();
					printOutWordArray(asteriks);
					char letter = printGuess(uInput);
					if (letters.contains(letter)) {
						System.out.println("\nLetter already tried");
						continue;
					}
					letters.add(letter);
					if (checkingLetter(wordIntoChar, asteriks, letter)) {

						continue;
					} else {
						System.out.println("Bad luck");
						missCounter++;
					}
				} else if (missCounter == 4) {
					Shape.print4thmiss();
					printOutWordArray(asteriks);
					char letter = printGuess(uInput);
					if (letters.contains(letter)) {
						System.out.println("\nLetter already tried");
						continue;
					}
					letters.add(letter);
					if (checkingLetter(wordIntoChar, asteriks, letter)) {

						continue;
					} else {
						System.out.println("Bad luck");
						missCounter++;
					}
				} else if (missCounter == 5) {
					Shape.print5thmiss();
					printOutWordArray(asteriks);
					char letter = printGuess(uInput);
					if (letters.contains(letter)) {
						System.out.println("\nLetter already tried");
						continue;
					}
					letters.add(letter);
					if (checkingLetter(wordIntoChar, asteriks, letter)) {

						continue;
					} else {
						System.out.println("Bad luck");
						missCounter++;
					}
				} else if (missCounter >= 6) {
					// If misscounter is 6 or bigger game is over
					Shape.printlastmiss();
					printOutWordArray(wordIntoChar);
					System.out.println("\nGame lost.Better luck next time");
					break;

				}

			} catch (InputMismatchException ex) {
				System.out.println("Wrong input");
				uInput.nextLine();
			} catch (Exception e) {
				System.out.println("Exception");
				uInput.nextLine();
			}
		}

	}

	public static void printOutWordArray(Character[] c) {
		// Method for printing out array
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
		}

	}

	public static boolean checkingLetter(Character[] word, Character[] ast,
			char letter) {
		// Letter that checks if word contains user inputed letter
		boolean doesContain = false;
		for (int i = 0; i < word.length; i++) {
			if (word[i] == letter) {
				ast[i] = letter;
				doesContain = true;

			}

		}

		return doesContain;

	}

	public static Character printGuess(Scanner uInput) {
		// User input method
		while (true) {
			try {
				System.out.println("\nGuess letter");
				char letter = uInput.nextLine().charAt(0);
				while (!Character.isLetter(letter)) {
					System.out
							.println("Wrong input!!!You can only input letters");
					letter = uInput.nextLine().charAt(0);
				}
				return letter;

			} catch (InputMismatchException ex) {
				System.out.println("Wrong input");
				uInput.nextLine();
			} catch (Exception e) {
				System.out.println("Exception");
				uInput.nextLine();
			}

		}

	}

	public static boolean isGameWon(Character[] ast, Character[] word) {
		for (int i = 0; i < word.length; i++) {
			if (ast[i] != word[i]) {
				return false;
			}

		}

		return true;
	}

}
