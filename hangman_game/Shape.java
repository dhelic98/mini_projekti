package hangman_game;

public class Shape {

	// method that prints out hanger
	public static void printHanger() {
		System.out.println("\n ________");
		System.out.println(" |      |  ");
		System.out.println(" |         ");
		System.out.println(" |         ");
		System.out.println(" |         ");
		System.out.println(" |         ");
		System.out.println(" |_________");
	}

	// method that prints out hanger and head
	public static void print1stmiss() {
		System.out.println("\n ________");
		System.out.println(" |      |  ");
		System.out.println(" |      O  ");
		System.out.println(" |         ");
		System.out.println(" |         ");
		System.out.println(" |         ");
		System.out.println(" |_________");
	}

	// method that prints out hanger after 2nd miss
	public static void print2ndmiss() {
		System.out.println("\n ________");
		System.out.println(" |      |  ");
		System.out.println(" |      O  ");
		System.out.println(" |      |  ");
		System.out.println(" |         ");
		System.out.println(" |         ");
		System.out.println(" |_________");
	}

	// method that prints out hanger after 3rd miss
	public static void print3rdmiss() {
		System.out.println("\n ________");
		System.out.println(" |      |  ");
		System.out.println(" |      O   ");
		System.out.println(" |     /|   ");
		System.out.println(" |         ");
		System.out.println(" |         ");
		System.out.println(" |_________");
	}

	// method that prints out hanger after 4th miss
	public static void print4thmiss() {
		System.out.println("\n ________");
		System.out.println(" |      |  ");
		System.out.println(" |      O   ");
		System.out.println(" |     /|\\    ");
		System.out.println(" |         ");
		System.out.println(" |         ");
		System.out.println(" |_________");
	}

	// method that prints out hanger after 5th miss
	public static void print5thmiss() {
		System.out.println("\n ________");
		System.out.println(" |      |  ");
		System.out.println(" |      O  ");
		System.out.println(" |     /|\\");
		System.out.println(" |     /   ");
		System.out.println(" |         ");
		System.out.println(" |_________");
	}

	// method that prints out hanger after last miss
	public static void printlastmiss() {
		System.out.println("\n ________");
		System.out.println(" |      |  ");
		System.out.println(" |      O  ");
		System.out.println(" |     /|\\");
		System.out.println(" |     / \\");
		System.out.println(" |         ");
		System.out.println(" |_________");
	}
}
