package battle_ship;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle_ship_game {
	// Constant values
	final static int AIRCRAFTCARRIER_LENGTH = 5;
	final static int BATTLESHIP_LENGTH = 4;
	final static int FRIGATE_LENGTH = 3;
	final static int SUBMARINE_LENGTH = 3;
	final static int MINESWEEPER_LENGTH = 2;

	final static char AIRCRAFTCARRIER = 'A';
	final static char BATTLESHIP = 'B';
	final static char FRIGATE = 'F';
	final static char SUBMARINE = 'S';
	final static char MINESWEEPER = 'M';

	public static void main(String[] args) {
		Scanner uInput = new Scanner(System.in);
		Random rand = new Random();
		Display_Battleship.printHeader();

		// create ship groups for game
		ArrayList<Ship> playerShipGroup = new ArrayList<>();
		ArrayList<Ship> computerShipGroup = new ArrayList<>();

		// creating tables for player
		char[][] playerShipTable = new char[10][10];
		char[][] playerGameTable = new char[10][10];

		// create tables for computer
		char[][] computerShipTable = new char[10][10];
		char[][] computerGameTable = new char[10][10];
		// Calling methods for ship placement
		placePlayerShipsOnTable(uInput, playerShipTable, playerGameTable,
				playerShipGroup);

		placeComputerShipsOnTable(computerShipTable, computerGameTable,
				computerShipGroup, rand);

		boolean isHit = true;
		boolean isPreviousHit = true;

		// Playing game
		while (!User_Input.checkPlayerShipsIsDestoryed(playerShipGroup)
				&& (!User_Input.checkPlayerShipsIsDestoryed(computerShipGroup))) {

			// taking shot from player
			getPlayerShot(uInput, computerShipTable, computerGameTable,
					computerShipGroup);

			// computer
			if (User_Input.checkPlayerShipsIsDestoryed(computerShipGroup)) {
				break;
			}

			computerTurn(playerShipTable, playerGameTable, playerShipGroup,
					rand, isHit, isPreviousHit);
		}
	}

	public static void placePlayerShipsOnTable(Scanner uInput,
			char[][] playerShipTable, char[][] playerGameTable,
			ArrayList<Ship> playerShipGroup) {
		// method that place all ships from player on table

		System.out.println("Player place your ships!");

		User_Input.getStartPosition(uInput, "AIRCRAFTCARRIER", AIRCRAFTCARRIER,
				AIRCRAFTCARRIER_LENGTH, playerShipTable);

		Ship aircraftcarrier = new Ship("Aircraftcarrier",
				AIRCRAFTCARRIER_LENGTH);
		playerShipGroup.add(aircraftcarrier);

		User_Input.getStartPosition(uInput, "BATTLESHIP", BATTLESHIP,
				BATTLESHIP_LENGTH, playerShipTable);

		Ship battleship = new Ship("Battleship", BATTLESHIP_LENGTH);
		playerShipGroup.add(battleship);

		User_Input.getStartPosition(uInput, "FRIGATE", FRIGATE, FRIGATE_LENGTH,
				playerShipTable);

		Ship frigate = new Ship("FRIGATE", FRIGATE_LENGTH);
		playerShipGroup.add(frigate);

		User_Input.getStartPosition(uInput, "SUBMARINE", SUBMARINE,
				SUBMARINE_LENGTH, playerShipTable);

		Ship sumbarine = new Ship("Sumbarine", SUBMARINE_LENGTH);
		playerShipGroup.add(sumbarine);

		User_Input.getStartPosition(uInput, "DESTROYER", MINESWEEPER,
				MINESWEEPER_LENGTH, playerShipTable);

		Ship minesweeper = new Ship("MINESWEEPER", MINESWEEPER_LENGTH);
		playerShipGroup.add(minesweeper);

		System.out.println("\nYour ships have been deployed!");
		Display_Battleship.printTable(playerShipTable);
	}

	public static void placeComputerShipsOnTable(char[][] playerShipTable,
			char[][] playerGameTable, ArrayList<Ship> playerShipGroup,
			Random rand) {
		// Method for placing computer controlled ships

		User_Input.getStartPositionForComputer(rand, "AIRCRAFTCARRIER",
				AIRCRAFTCARRIER, AIRCRAFTCARRIER_LENGTH, playerShipTable);

		Ship aircraftcarrier = new Ship("Aircraftcarrier",
				AIRCRAFTCARRIER_LENGTH);
		playerShipGroup.add(aircraftcarrier);

		User_Input.getStartPositionForComputer(rand, "BATTLESHIP", BATTLESHIP,
				BATTLESHIP_LENGTH, playerShipTable);

		Ship battleship = new Ship("Battleship", BATTLESHIP_LENGTH);
		playerShipGroup.add(battleship);

		User_Input.getStartPositionForComputer(rand, "FRIGATE", FRIGATE,
				FRIGATE_LENGTH, playerShipTable);

		Ship frigate = new Ship("FRIGATE", FRIGATE_LENGTH);
		playerShipGroup.add(frigate);

		User_Input.getStartPositionForComputer(rand, "SUBMARINE", SUBMARINE,
				SUBMARINE_LENGTH, playerShipTable);

		Ship sumbarine = new Ship("Sumbarine", SUBMARINE_LENGTH);
		playerShipGroup.add(sumbarine);

		User_Input.getStartPositionForComputer(rand, "DESTROYER", MINESWEEPER,
				MINESWEEPER_LENGTH, playerShipTable);

		Ship minesweeper = new Ship("MINESWEEPER", MINESWEEPER_LENGTH);
		playerShipGroup.add(minesweeper);

	}

	// Method for getting shot from user
	public static void getPlayerShot(Scanner uInput,
			char[][] computerShipTable, char[][] computerGameTable,
			ArrayList<Ship> computerShipGroup) {

		boolean isPlayerGoodShot = true;

		while (isPlayerGoodShot) {
			System.out.println("Computer table");
			Display_Battleship.printTable(computerGameTable);

			// get hit position from player
			int[] playerHitPosition = User_Input.getHitPositionFromUser(uInput,
					computerGameTable);

			int row = playerHitPosition[0];
			int column = playerHitPosition[1];

			// check if player hit one of the ships
			if (User_Input.isGoodShot(row, column, computerShipTable)) {
				playerHitShip(row, column, computerShipTable,
						computerGameTable, computerShipGroup);
			} else {
				playerMissShip(row, column, computerGameTable);

				isPlayerGoodShot = false;
			}

			if (User_Input.checkPlayerShipsIsDestoryed(computerShipGroup)) {
				// check if enemy's ships are all destroyed, display
				// corresponding message and finish the game
				Display_Battleship.printTable(computerGameTable);

				System.out
						.println("\nAll ships from computer have been destroyed!");
				System.out.println("*** YOU WIN! ***");
				break;
			}
		}

	}

	// method that perform operations when one of the ship is hitted
	public static void playerHitShip(int row, int column,
			char[][] computerShipTable, char[][] computerGameTable,
			ArrayList<Ship> computerShipGroup) {

		// get index of the ship that was hit
		int indexOfShip = getIndexOfShip(row, column, computerShipTable,
				computerShipGroup);
		// hit that ship, increase hit counter by 1
		computerShipGroup.get(indexOfShip).hit();

		char shipFirstLetter = getShipFirstLetterFromIndex(indexOfShip);

		computerGameTable[row][column] = shipFirstLetter;

		System.out.println("\nGood shot!");

		if (computerShipGroup.get(indexOfShip).getNumberOfHits() == computerShipGroup
				.get(indexOfShip).getShipLength()) {
			System.out.println("*** You have destroyed enemy's "
					+ computerShipGroup.get(indexOfShip).getShipName()
					+ "! ***");
			computerShipGroup.get(indexOfShip).destroyed();
			;
		}
	}

	// method that perform operation when player miss the ship
	public static void playerMissShip(int row, int column,
			char[][] computerGameTable) {
		// if player missed a ship, write 'X' in the enemy's table on
		// that position
		computerGameTable[row][column] = 'X';

		System.out.println("\nYou missed!");
	}

	// method that get first letter of ship name from index of that ship in ship
	// group
	public static char getShipFirstLetterFromIndex(int indexOfShip) {
		char shipFirstLetter = ' ';

		switch (indexOfShip) {
		case 0:
			shipFirstLetter = 'A';
			break;
		case 1:
			shipFirstLetter = 'B';
			break;
		case 2:
			shipFirstLetter = 'F';
			break;
		case 3:
			shipFirstLetter = 'S';
			break;
		case 4:
			shipFirstLetter = 'M';
		}

		return shipFirstLetter;
	}

	// method that get index of ship from ship group
	public static int getIndexOfShip(int row, int column,
			char[][] playerMainTable, ArrayList<Ship> shipGroup) {
		int indexOfShip = 0;

		if (playerMainTable[row][column] == 'A') {
			indexOfShip = 0;
		} else if (playerMainTable[row][column] == 'B') {
			indexOfShip = 1;
		} else if (playerMainTable[row][column] == 'F') {
			indexOfShip = 2;
		} else if (playerMainTable[row][column] == 'S') {
			indexOfShip = 3;
		} else if (playerMainTable[row][column] == 'M') {
			indexOfShip = 4;
		}

		return indexOfShip;
	}

	public static void computerTurn(char[][] playerShipTable,
			char[][] playerGameTable, ArrayList<Ship> playerShipList,
			Random rand, boolean isHit, boolean isPreviousHit) {
		// Method for computer shot

		int row = rand.nextInt(10);
		int column = rand.nextInt(10);
		while (true) {
			System.out.println("Player table");
			Display_Battleship.printTable(playerGameTable);
			if (isHit) {
				// if computer hits he will randomly hit 1 of 4 next tiles

				int orientation = rand.nextInt(4);
				if (orientation == 0) {
					row = row - 1;

				} else if (orientation == 1) {
					column++;
				} else if (orientation == 2) {
					row++;
				} else {
					column--;
				}

			}
			if (row < 0 || row > 9 || column < 0 || column > 9) {
				continue;
			}
			try {
				if (!User_Input.isGoodShot(row, column, playerShipTable)) {
					isHit = false;
					isPreviousHit = false;
					playerMissShip(row, column, playerGameTable);

				} else {

					playerHitShip(row, column, playerShipTable,
							playerGameTable, playerShipList);
					isHit = true;

					isPreviousHit = true;

				}

				if (User_Input.checkPlayerShipsIsDestoryed(playerShipList)) {
					// check if enemy's ships are all destroyed, display
					// corresponding message and finish the game
					Display_Battleship.printTable(playerGameTable);

					System.out
							.println("\nAll ships from player have been destroyed!");
					System.out.println("*** COMPUTER WIN! ***");
					break;
				}
				if (!isHit) {
					break;
				}
			} catch (Exception e) {
				System.out.println("Exception");
			}
		}

	}
}
