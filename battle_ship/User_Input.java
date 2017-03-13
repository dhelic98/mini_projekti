package battle_ship;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class User_Input {

	public static void getStartPosition(Scanner uInput, String shipName,
			char shipChar, int shipLength, char[][] playerShipTable) {
		// Method for placing ships by user
		Display_Battleship.printTable(playerShipTable);
		while (true) {
			try {
				System.out
						.println("Would you like to place ship vertically(1) or horizontally(2)");
				int sideOption = uInput.nextInt();
				if (sideOption == 1) {
					System.out.println("Enter column 1-10");
					int row = uInput.nextInt();
					while (row < 1 || row > 10) {
						System.out.println("Enter column 1-10");
						row = uInput.nextInt();
					}

					System.out
							.println("Enter starting position.Ship lenght is "
									+ shipLength + " so careful");

					int startRow = uInput.nextInt();
					while ((startRow - 1) + shipLength > 10) {
						System.out.println("Can't put there enter again");
						startRow = uInput.nextInt();
					}

					if (checkShipPosition((startRow - 1), (row - 1), 1,
							shipLength, playerShipTable)) {
						System.out.println("Position occupied try again");
						continue;

					}

					for (int i = startRow - 1; i < ((startRow - 1) + shipLength); i++) {
						playerShipTable[i][(row - 1)] = shipChar;

					}

				} else if (sideOption == 2) {
					System.out.println("Enter row 1-10");
					int row = uInput.nextInt();
					while (row < 1 || row > 10) {
						System.out.println("Enter row 1-10");
						row = uInput.nextInt();
					}

					System.out
							.println("Enter starting position.Ship lenght is "
									+ shipLength + " so careful");

					int startColumn = uInput.nextInt();
					while ((startColumn - 1) + shipLength > 10) {
						System.out.println("Can't put there enter again");
						startColumn = uInput.nextInt();
					}
					if (checkShipPosition((row - 1), (startColumn - 1), 2,
							shipLength, playerShipTable)) {
						System.out.println("Position occupied try again");
						continue;
					}

					for (int i = (startColumn - 1); i < ((startColumn - 1) + shipLength); i++) {
						playerShipTable[(row - 1)][i] = shipChar;

					}

				} else {
					System.out.println("Wrong option");
					continue;
				}
				break;

			} catch (Exception ex) {
				System.out.println("Exception");
				uInput.nextLine();
			}

		}

	}

	public static void getStartPositionForComputer(Random rand,
			String shipName, char shipChar, int shipLength,
			char[][] computerShipTable) {
		// Method for placing ships by computer

		while (true) {
			int orientation = rand.nextInt(2);
			if (orientation == 0) {
				int row = rand.nextInt(10);
				int startColumn = rand.nextInt(7);
				if (checkShipPosition(row, startColumn, 2, shipLength,
						computerShipTable)) {
					continue;
				}
				for (int i = startColumn; i < (startColumn + shipLength); i++) {
					computerShipTable[row][i] = shipChar;

				}
			} else if (orientation == 1) {
				int startRow = rand.nextInt(7);
				int column = rand.nextInt(10);
				if (checkShipPosition(startRow, column, 1, shipLength,
						computerShipTable)) {
					continue;
				}
				for (int i = startRow; i < (startRow + shipLength); i++) {
					computerShipTable[i][column] = shipChar;

				}

			}
			break;
		}

	}

	// method that checks for a free position to place ship in the table
	public static boolean checkShipPosition(int row, int column,
			int orientation, int shipLength, char[][] playerShipTable) {

		if (orientation == 2) {
			for (int j = column; j < column + shipLength; j++) {
				if (j == playerShipTable[0].length) {
					return true;
				} else {
					if (playerShipTable[row][j] == 'A'
							|| playerShipTable[row][j] == 'B'
							|| playerShipTable[row][j] == 'F'
							|| playerShipTable[row][j] == 'S'
							|| playerShipTable[row][j] == 'M') {
						return true;
					}
				}
			}
		} else if (orientation == 1) {
			for (int i = row; i < row + shipLength; i++) {
				if (i == playerShipTable.length) {
					return true;
				} else {
					if (playerShipTable[i][column] == 'A'
							|| playerShipTable[i][column] == 'B'
							|| playerShipTable[i][column] == 'F'
							|| playerShipTable[i][column] == 'S'
							|| playerShipTable[i][column] == 'M') {
						return true;
					}
				}
			}
		}

		return false;
	}

	// method that checks for a free position to hit in the table
	public static boolean checkHitPosition(int row, int column,
			char[][] playerShowTable) {

		if (playerShowTable[row][column] == 'A'
				|| playerShowTable[row][column] == 'B'
				|| playerShowTable[row][column] == 'F'
				|| playerShowTable[row][column] == 'S'
				|| playerShowTable[row][column] == 'M'
				|| playerShowTable[row][column] == 'X') {
			return true;
		}

		return false;
	}

	// method that returns true if a player hit one of the ships
	public static boolean isGoodShot(int row, int column,
			char[][] playerMainTable) {

		if (playerMainTable[row][column] == 'A'
				|| playerMainTable[row][column] == 'B'
				|| playerMainTable[row][column] == 'F'
				|| playerMainTable[row][column] == 'S'
				|| playerMainTable[row][column] == 'M') {
			return true;
		}

		return false;
	}

	// method that returns true if a player have at least one ship not destroyed
	public static boolean checkPlayerShipsIsDestoryed(
			ArrayList<Ship> playerShipGroup) {
		int counter = 0;
		for (int i = 0; i < playerShipGroup.size(); i++) {
			if (playerShipGroup.get(i).isDestroyed()) {
				counter++;

			}
		}
		if (counter == playerShipGroup.size()) {
			return true;
		}

		return false;
	}

	public static int[] getHitPositionFromUser(Scanner uInput,
			char[][] computerGameTable) {
		// Method for getting hit position from player

		int[] position = new int[2];
		boolean wrongPosition = true;

		while (wrongPosition) {
			System.out.println("Your turn.Shoot!!!");
			int column = 0;
			int row = 0;
			while (true) {
				try {
					System.out.println("Enter column 1-10");
					column = uInput.nextInt();
					if (column > 10 || column < 1) {
						continue;
					}
					System.out.println("Enter row 1-10");
					row = uInput.nextInt();
					if (row > 10 || row < 1) {
						continue;
					}
					break;

				} catch (Exception ex) {
					System.out.println("Exception");
				}
			}

			uInput.nextLine();

			position[0] = (row - 1);
			position[1] = (column - 1);

			wrongPosition = false;

			if (checkHitPosition(row - 1, column - 1, computerGameTable)) {
				System.out
						.println("You've already hit that position. Choose another one!");
				wrongPosition = true;
			}
		}

		return position;
	}

}
