package hangman_game;

import java.util.ArrayList;

public class Word {

	private String wordString;
	private int size;

	public Word(String sWord) {
		// Const word as object
		this.wordString = sWord;
		this.size = sWord.length();
	}

	public ArrayList<Character> returnChars() {
		ArrayList<Character> listOfChars = new ArrayList<>();
		for (int i = 0; i < this.wordString.length(); i++) {
			listOfChars.add(wordString.charAt(i));

		}

		return listOfChars;

	}

	public String toString() {
		return this.wordString;
	}
}
