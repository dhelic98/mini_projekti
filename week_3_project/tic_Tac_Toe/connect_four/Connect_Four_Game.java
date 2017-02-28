package connect_four;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Connect_Four_Game {

	public static void main(String[] args) {
		// Connect four simple game
		Scanner uInput = new Scanner(System.in);

		// Initializing array(board) filling it with spaces
		String[][] gameBoard = new String[6][7];
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				gameBoard[i][j] = " ";

			}

		}
		// Variable for counting moves
		int moveCounter = 0;
		// Method for printing out board
		printBoard(gameBoard);

		while (true) {
			try {
				moveCounter++;
				int userOption = 0;
				boolean turn = true;
				int row = 5;
				// Move for red
				if (moveCounter % 2 != 0) {
					System.out.println("Drop a red disk at column (0–6):");
					userOption = uInput.nextInt();
					while (userOption < 0 || userOption > 6) {
						System.out.println("Drop a red disk at column (0–6):");
						userOption = uInput.nextInt();

					}

					while (turn) {
						if ((row == 0) && (gameBoard[row][userOption] != " ")) {
							System.out.println("This place is used try again");
							userOption = uInput.nextInt();
							while (userOption < 0 || userOption > 6) {
								System.out
										.println("Drop a yellow disk at column (0–6):");
								userOption = uInput.nextInt();
							}
							row = 5;
							continue;

						}

						else if (gameBoard[row][userOption] != " ") {
							row--;
							continue;

						}

						else {
							gameBoard[row][userOption] = "X";

						}
						turn = false;
					}

				} else {
					// Move for yellow
					System.out.println("Drop a yellow disk at column (0–6):");
					userOption = uInput.nextInt();
					while (userOption < 0 || userOption > 6) {
						System.out
								.println("Drop a yellow disk at column (0–6):");
						userOption = uInput.nextInt();
					}
					while (turn) {
						if ((row == 0) && (gameBoard[row][userOption] != " ")) {
							System.out.println("This place is used try again");
							userOption = uInput.nextInt();
							while (userOption < 0 || userOption > 6) {
								System.out
										.println("Drop a yellow disk at column (0–6):");
								userOption = uInput.nextInt();
							}
							row = 5;
							continue;

						}

						else if (gameBoard[row][userOption] != " ") {
							row--;
							continue;

						}

						else {
							gameBoard[row][userOption] = "O";

						}
						turn = false;
					}

				}
				// Printing board
				printBoard(gameBoard);
				if (isWon(row, userOption, gameBoard)) {
					System.out.println(gameBoard[row][userOption]
							+ " won the game");
					break;
				} else {
					// Calling method for draw as condition
					if (isDraw(gameBoard)) {
						System.out
								.println("Game is draw!!!\nWant to play again?? (1)Yes (0)No");
						int exitOption = uInput.nextInt();
						if (exitOption == 1) {
							continue;
						} else if (exitOption == 0) {
							System.out.println("Good bye.");
							break;

						} else {
							System.out.println("Wrong input");
							break;
						}

					}
				}

			} catch (InputMismatchException ex) {
				System.out.println("Exception");
				moveCounter = 0;
				uInput.nextLine();
			}

		}
		uInput.close();

	}

	public static void printBoard(String[][] gameBoard) {
		// Printing game board

		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (j == gameBoard[i].length - 1) {

					System.out.print("|" + gameBoard[i][j] + "|");

				} else {

					System.out.print("|" + gameBoard[i][j]);
				}

			}
			System.out.println();
		}
		System.out.println("--------------- ");

	}

	public static boolean isDraw(String[][] board) {
		// Method that checks if game is draw
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == " ") {
					return false;
				}

			}

		}

		return true;
	}

	public static boolean isWon(int row, int col, String[][] board) {
		// Method that check if game is over

		if (row >= 3) {
			// column win
			if ((board[row][col] == board[row - 1][col])
					&& (board[row - 1][col] == board[row - 2][col])
					&& (board[row - 2][col] == board[row - 3][col])) {
				return true;

			}
			if (col >= 3) {
				// Diagonal win
				if ((board[row][col] == board[row - 1][col - 1])
						&& (board[row - 1][col - 1] == board[row - 2][col - 2])
						&& (board[row - 2][col - 2] == board[row - 3][col - 3])) {
					return true;

				} else if ((board[row][col] == board[row - 1][col - 1])
						&& (board[row - 1][col - 1] == board[row - 2][col - 2])
						&& (board[row - 2][col - 2] == board[row - 3][col - 3])) {
					return true;

				}

			}
			if (col < 4) {
				// Diagonal win
				if ((board[row][col] == board[row - 1][col + 1])
						&& (board[row - 1][col + 1] == board[row - 2][col + 2])
						&& (board[row - 2][col + 2] == board[row - 3][col + 3])) {
					return true;

				}

			}

		}
		if (row < 3) {
			// Column win
			if ((board[row][col] == board[row + 1][col])
					&& (board[row + 1][col] == board[row + 2][col])
					&& (board[row + 2][col] == board[row + 3][col])) {
				return true;
			}
			if (col >= 3) {
				// Diagonal win
				if ((board[row][col] == board[row + 1][col - 1])
						&& (board[row + 1][col - 1] == board[row + 2][col - 2])
						&& (board[row + 2][col - 2] == board[row + 3][col - 3])) {
					return true;

				}
				// Diagonal win
				if ((board[row][col] == board[row + 1][col - 1])
						&& (board[row + 1][col - 1] == board[row + 2][col - 2])
						&& (board[row + 2][col - 2] == board[row + 3][col - 3])) {
					return true;

				}

			}
			if (col < 4) {
				// Diagonal win
				if ((board[row][col] == board[row + 1][col + 1])
						&& (board[row + 1][col + 1] == board[row + 2][col + 2])
						&& (board[row + 2][col + 2] == board[row + 3][col + 3])) {
					return true;

				}

			}

		}
		// Row win
		if (col < 4) {
			if ((board[row][col] == board[row][col + 1])
					&& (board[row][col + 1] == board[row][col + 2])
					&& (board[row][col + 2] == board[row][col + 3])) {
				return true;
			}
		} else if (col > 3) {
			// Row win
			if ((board[row][col] == board[row][col - 1])
					&& (board[row][col - 1] == board[row][col - 2])
					&& (board[row][col - 2] == board[row][col - 3])) {
				return true;
			}
		}

		return false;
	}

}
