package kalendar_projekt;

public class InputValidation {

	public static boolean monthInputValidation(int month) {
		// Metoda koja provjerava da li je unos mjeseca ispravan
		if ((month > 12) || (month <= 0)) {
			return false;
		} else {

			return true;
		}
	}

	public static String getMonthName(int month) {
		// Metoda koja pronalazi ime mjeseca na osnovu unosa
		String monthName = "";
		switch (month) {
		case 1:
			monthName = "January";
			break;
		case 2:
			monthName = "February";
			break;
		case 3:
			monthName = "March";
			break;
		case 4:
			monthName = "April";
			break;
		case 5:
			monthName = "May";
			break;
		case 6:
			monthName = "June";
			break;
		case 7:
			monthName = "July";
			break;
		case 8:
			monthName = "August";
			break;
		case 9:
			monthName = "September";
			break;
		case 10:
			monthName = "October";
			break;
		case 11:
			monthName = "November";
			break;
		case 12:
			monthName = "December";
		}
		return monthName;
	}

	public static boolean dateValidation(String date) {
		// Metoda provjerva da li je datum upisan u fromatu dd.mm.yyyy
		if (date.length() != 10) {
			return false;
		}
		if ((date.charAt(2) != '/') || (date.charAt(5) != '/')) {
			return false;

		}
		return true;

	}

	public static boolean isLeapYear(int year) {
		// Metoda koja provjerava da li je godina prijestupna
		if (((year % 100 != 0) && (year % 4 == 0) || (year % 400 == 0))) {
			return true;

		}
		return false;

	}

	public static boolean isDayValid(int numberInMonth, int numberInput) {
		// Metoda provjerava da li je dan validan
		if ((numberInput > numberInMonth) || (numberInput <= 0)) {
			return false;
		}

		return true;
	}

	public static int numberOfDaysInMonth(int month, int year) {
		//Metoda koja vraca broj dana u mjesecu
		if ((month == 1) || (month == 3) || (month == 5) || (month == 7)
				|| (month == 8) || (month == 10) || (month == 12)) {
			return 31;
		} else if (month == 2) {
			//Pozivanje metode za provjeru da li je godina prijestupna
			if (isLeapYear(year)) {
				return 29;
			} else {
				return 28;
			}
		} else if ((month == 4) || (month == 6) || (month == 9) || (month == 1)) {
			return 30;
		} else {
			return 0;
		}

	}
}
