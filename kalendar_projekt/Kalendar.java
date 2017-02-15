package kalendar_projekt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kalendar {

	public static void main(String[] args) throws IOException {
		// Deklarisanje skenera, arrayliste
		Scanner uInput = new Scanner(System.in);
		ArrayList<Reminder> reminderList = new ArrayList<>();
		// Pozivanje metode za kopiranje iz fajla u arrayListu
		File_handling.copyFromFileToList(reminderList);

		do {
			try {
				// Pozivamo metodu koja printa glavni meni
				Display.displayMainMenu();
				int mainMenuOption = uInput.nextInt();

				while (mainMenuOption != 0) {

					if (mainMenuOption == 1) {
						// Opcija za ispis kalendara
						// Pozivanje metode iz Display klase koja ispisuje
						// mjesec
						Display.displayMonth(uInput, reminderList);

						break;
					} else if (mainMenuOption == 2) {
						// Opcija za dodavanje remindera
						uInput.nextLine();
						// Pozivanje metode koja kreira reminder
						Display.addReminder(uInput, reminderList);

						break;
					} else if (mainMenuOption == 3) {
						// Metoda koja printa remindere
						Display.displayReminder(uInput, reminderList);

						break;

					}
				
					uInput.nextLine();
				}
				if (mainMenuOption == 0) {
					break;
				}

			} catch (InputMismatchException ex) {
				System.out.println("Your input is wrong");
				uInput.nextLine();
			} catch (Exception ex) {
				System.out.println("Exception");
				uInput.nextLine();
			}

		} while (true);
//Zatvaramo unos
		uInput.close();
	}

}
