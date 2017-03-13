package battle_ship;

public class Display_Battleship {

	// Method for printing header
	public static void printHeader() {
		System.out.println("Welcome to Battleship console app.");

	}

	// method that prints the table
	public static void printTable(char[][] table) {
		System.out.println("\n---------------------------------------------");
		System.out.println("|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |");
		System.out.println("---------------------------------------------");

		for (int i = 0; i < table.length; i++) {
			System.out.print("| " + (i + 1) + " |");

			for (int j = 0; j < table[0].length; j++) {
				System.out.print(" " + table[i][j] + " |");
			}

			System.out
					.println("\n---------------------------------------------");
		}
	}

}
