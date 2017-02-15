package kalendar_projekt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Display {

	public static void displayMainMenu() {
		// Metoda koja printa glavni meni
		System.out.println("--------------------");
		System.out.println("    Calendar app    ");
		System.out.println("--------------------");
		System.out.println("1.Display calendar");
		System.out.println("2.Add reminder");
		System.out.println("3.Read reminder");
		System.out.println("0.Exit");
	}

	public static void displayMonth(Scanner uInput, ArrayList<Reminder> list) {
		// Metoda koja printa kalendar po mjesecu
		do {
			try {
				// Unos od strane korisnika za ispis mjeseca
				System.out.println("Please enter month 1-12:");
				int month = uInput.nextInt();
				// Pozivanje metode za validaciju mjeseca
				while (!InputValidation.monthInputValidation(month)) {
					System.out.println("Month input must be between 1 and 12");
					month = uInput.nextInt();

				}
				// Unos godine
				System.out.println("Please enter year:");
				int year = uInput.nextInt();

				// Kreiramo gregorianski kalendar
				Calendar calendar = new GregorianCalendar();
				calendar.clear();
				// Postavimo vrijednosti za uneseni mjesec
				calendar.set(year, month - 1, 1);
				System.out.print("Calendar for: "
						+ InputValidation.getMonthName(month));

				System.out.println(", " + year);

				// Varijable za prvi dan i broj dana u mjesecu
				int firstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);
				int numberOfDaysInMonth = calendar
						.getActualMaximum(Calendar.DAY_OF_MONTH);
				uInput.nextLine();
				// Deklarisanje varijable koja prati printanje
				int printDay = 0;
				// Printamo header
				System.out.println("-----------------------------------");
				System.out.println(" Sun  Mon  Tue  Wed  Thu  Fri  Sat ");
				System.out.println("-----------------------------------");
				// Ova petlja printa prazne prostore do prvog dana u mjesecu
				for (int day = 1; day < firstDayOfMonth; day++) {
					System.out.print("     ");
					printDay++;
				}
				// Ova petlja ispisuje dane
				for (int day = 1; day <= numberOfDaysInMonth; day++) {
					// ako je dan jednocifren printat ce po 2 space sa obje
					// strane
					if (day < 10) {
						System.out.print("  " + day + "  ");
					} else {
						System.out.print(" " + day + "  ");
					}
					printDay++;

					// uslov za prelazak u novi red
					if (printDay % 7 == 0) {
						System.out.println();
					}

				}
				// Prelazak u novi red
				System.out.println();
				// Pozivanje i metode addreminder i dodavanje remindera
				System.out
						.println("Would you like to add reminder (1)Yes (0)No");
				int reminderOption = uInput.nextInt();
				if (reminderOption == 1) {
					// Pozivanje metode za kreiranje remindera
					uInput.nextLine();
					addReminder(uInput, list, month, year, numberOfDaysInMonth);
					break;
				} else if (reminderOption == 0) {
					break;

				} else {
					System.out.println("Wrong input");
					break;
				}
			} catch (InputMismatchException ex) {
				System.out.println("Your Input is wrong");
				uInput.nextLine();
			} catch (Exception ex) {
				System.out.println("There was an exception");
				uInput.nextLine();
			}

		} while (true);
		// Kraj displayMontMetode
	}

	public static void addReminder(Scanner uInput,
			ArrayList<Reminder> listOfReminders) throws IOException {
		// Metoda koja kreira objekat reminder tipa
		try {
			// Unos od strane korisnika
			System.out.println("Please enter date (format-dd/mm/yyyy)");

			String date = uInput.nextLine();
			// Pozivanje metode za validaciju formata
			while (InputValidation.dateValidation(date) != true) {
				System.out
						.println("Wrong format please input again(fromat-dd/mm/yyyy)");
				date = uInput.nextLine();
			}
			// podjela datuma koji nam omogucava da kreiramo
			// reminder-podsjetnik
			String[] dates = date.split("/");
			// Varijable za kreiranje remindera
			int month = Integer.parseInt(dates[1]);
			int day = Integer.parseInt(dates[0]);
			int year = Integer.parseInt(dates[2]);
			while (InputValidation.monthInputValidation(month) != true) {
				System.out
						.println("Your month input is wrong please enter month again");
				month = uInput.nextInt();

			}
			int numberOfDaysInMonth = InputValidation.numberOfDaysInMonth(
					month, year);
			while (true) {
				if ((day > 0) && (day <= numberOfDaysInMonth)) {
					break;
				} else {
					System.out
							.println("Day input is invalid please enter day again");
					day = uInput.nextInt();

				}
			}
			// Kreiramo novi reminder pretvarajuci stringove u brojeve
			Reminder reminder = new Reminder(day, month, year);
			uInput.nextLine();

			// Unos poruke u reminder
			String note = "";
			System.out
					.println("Please enter reminder note no longer than 100 characters");
			note = uInput.nextLine();

			// Uslov za poruku
			while (note.length() > 100) {
				System.out
						.println("Note can not be longer than 100 characters.Please input again");
				note = uInput.nextLine();
			}
			// Postavljamo poruku
			reminder.setReminderNote(note);
			// Dodavanje objekta u arrayList i kopiranje u fajl
			listOfReminders.add(reminder);
			File_handling.copyFromListToReminderFile(listOfReminders);

		} catch (InputMismatchException ex) {
			System.out.println("Your input is wrong");
			uInput.nextLine();
		} catch (Exception ex) {
			System.out.println("Exception");
			uInput.nextLine();
		}

		// vracamo arrayList sa reminderima

		// Kraj addReminder metode
	}

	public static void addReminder(Scanner uInput,
			ArrayList<Reminder> listOfReminders, int month, int year,
			int numberOfDaysInMonth) throws IOException {
		// Metoda koja kreira objekat reminder tipa
		try {
			// Unos od strane korisnika
			System.out.println("Please enter day");

			int day = uInput.nextInt();
			while (InputValidation.isDayValid(numberOfDaysInMonth, day) != true) {
				System.out
						.println("Your input is wrong please enter number(day) between 1 and "
								+ numberOfDaysInMonth);

				day = uInput.nextInt();
			}

			// Kreiramo novi reminder pretvarajuci stringove u brojeve
			Reminder reminder = new Reminder(day, month, year);
			uInput.nextLine();
			// Unos poruke u reminder
			String note = "";
			System.out
					.println("Please enter reminder note no longer than 100 characters");
			note = uInput.nextLine();

			// Uslov za poruku
			while (note.length() > 100) {
				System.out
						.println("Note can not be longer than 100 characters.Please input again");
				note = uInput.nextLine();
			}
			// Postavljamo poruku
			reminder.setReminderNote(note);
			// Dodavanje objekta u arrayList i kopiranje u fajl
			listOfReminders.add(reminder);
			File_handling.copyFromListToReminderFile(listOfReminders);

		} catch (InputMismatchException ex) {
			System.out.println("Your input is wrong");
			uInput.nextLine();
		} catch (Exception ex) {
			System.out.println("Exception");
			uInput.nextLine();
		}

		// vracamo arrayList sa reminderima

		// Kraj addReminder metode
	}

	public static void displayReminder(Scanner uInput, ArrayList<Reminder> list) {
		// Metoda koja ispisuje reminder za odredjeni datum

		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + ". " + list.get(i).toString());

		}
		try {
			// Upit za korisnika
			System.out.println("Would you like to remove reminder?");
			System.out.println("(1)Yes");
			System.out.println("(0)No");

			int removeOption = uInput.nextInt();
			if (removeOption == 1) {
				System.out
						.println("Enter index of reminder you want to delete");
				int removeIndex = uInput.nextInt();
				// Pozivanje metode za brisanje remindera
				removeReminder(list, removeIndex);
				File_handling.copyFromListToReminderFile(list);
				for (int i = 0; i < list.size(); i++) {
					System.out.println((i + 1) + ". " + list.get(i).toString());

				}
			} else if (removeOption == 0) {

			} else {
				System.out.println("Wrong input");
			}
		} catch (Exception ex) {
			System.out.println("Exception");
		}

	}

	public static void removeReminder(ArrayList<Reminder> list, int index) {
		// Metoda koja uklanja reminder iz liste
		list.remove(index - 1);

	}
}
