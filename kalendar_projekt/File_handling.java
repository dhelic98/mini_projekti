package kalendar_projekt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class File_handling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void copyFromListToReminderFile(
			ArrayList<Reminder> listOfReminders) throws IOException {
		// Metoda koja ispisuje podtake iz arrayListe u fajl
		Path path = Paths.get("remindersList.txt");
		if (!Files.exists(path)) {
			Files.createFile(path);
		}

		BufferedWriter writer = Files.newBufferedWriter(path);

		try {
			// Petljom prolazimo kroz arrayList i upisujemo u fajl za svaki
			// objekat iz liste
			for (int i = 0; i < listOfReminders.size(); i++) {
				writer.write(listOfReminders.get(i).getDay() + ";;"
						+ listOfReminders.get(i).getMonth() + ";;"
						+ listOfReminders.get(i).getYear() + ";;"
						+ listOfReminders.get(i).getReminderNote());

				// Prelazimo u novi red
				writer.newLine();
			}
			writer.close();

		} catch (Exception ex) {
			System.out.println("Exception");

		}

	}

	public static void copyFromFileToList(ArrayList<Reminder> list)
			throws IOException {
		// Metoda koja prepisuje podatke iz fajla u arrayListu
		Path path = Paths.get("remindersList.txt");
		if (!Files.exists(path)) {
			Files.createFile(path);
		}

		BufferedReader reader = Files.newBufferedReader(path);

		// Deklarisanje varijabli
		String line = "";
		int day = 0;
		int month = 0;
		int year = 0;
		String reminder = "";

		try {
			while ((line = reader.readLine()) != null) {
				String[] remInfo = line.split(";;");
				if (remInfo.length != 4) {
					break;
				} else {
					day = Integer.parseInt(remInfo[0]);
					month = Integer.parseInt(remInfo[1]);
					year = Integer.parseInt(remInfo[2]);
					reminder = remInfo[3];
					// Kreiranje objekta i postavljanje poruke
					Reminder reminderObject = new Reminder(day, month, year);
					reminderObject.setReminderNote(reminder);
					list.add(reminderObject);
				}

			}

			reader.close();
		} catch (Exception ex) {
			System.out.println("There was an exception");
		}

	}

}
