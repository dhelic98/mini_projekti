package kalendar_projekt;

public class Reminder {
	private int day;
	private int month;
	private int year;
	private String reminderNote;
	private String date;

	// No args konstruktor
	public Reminder() {

	}

	// Deklarisani kontstruktor za objekat reminder(podsjetnik)
	public Reminder(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;

		// Datum u obliku Stringa za laksi ispis
		this.date = day + "." + month + "." + year;
	}

	// Getter i Setter metode za data-fieldove
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getReminderNote() {
		return reminderNote;
	}

	public void setReminderNote(String reminderNote) {
		this.reminderNote = reminderNote;
	}

	public String getDate() {
		return date;
	}

	// Metoda kojom ispisujemo reminder za odredjeni dan

	public String toString() {
		return "Reminder for: " + this.date + " is " + this.reminderNote;
	}

}
