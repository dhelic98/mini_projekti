package hangman_game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHandling {

	public static void copyFromFileToList(ArrayList<Word> listOfWords)
			throws IOException {
		//Method for copying words from file to list
		Path path = Paths.get("hangman_words.txt");
		if (!Files.exists(path)) {
			Files.createFile(path);
		}

		BufferedReader reader = Files.newBufferedReader(path);
		try {
			String line = "";
			while ((line = reader.readLine()) != null) {
				Word word = new Word(line);
				listOfWords.add(word);

			}
		} catch (Exception ex) {
			System.out.println("Exception");
		}

		reader.close();

	}

	public static void copyFromListToFile(ArrayList<Word> listOfWords)
			throws IOException {
		//Method for copying from arrayList to file
		Path path = Paths.get("hangman_words.txt");
		if (!Files.exists(path)) {
			Files.createFile(path);
		}

		BufferedWriter writer = Files.newBufferedWriter(path);
		try {
			for (int i = 0; i < listOfWords.size(); i++) {
				writer.write(listOfWords.get(i).toString());
				writer.newLine();

			}
		} catch (Exception ex) {
			System.out.println("Exception");
		}

		writer.close();

	}
}
