package tic_Tac_Toe;


import java.awt.Container;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Tic_Tac_Toe_Game extends JFrame {

	private JButton[][] buttons = new JButton[3][3];
	private int moveCounter = 0;

	public Tic_Tac_Toe_Game() {
		JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
		//loop that initializes buttons and adds action listeners
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton();
				buttonPanel.add(buttons[i][j]);
				buttons[i][j].addActionListener(new moveListener());

			}
		}

		//Creating container
		Container c = getContentPane();
		c.add(buttonPanel);

	}

	private void isGameOver(int row, int column) { 
		//Method that check if game is over
		if ((buttons[row][0].getText() == (buttons[row][1].getText()))
				&& (buttons[row][1].getText() == (buttons[row][2].getText()))
				&& (buttons[row][0].getText() != "")) {
			JOptionPane.showMessageDialog(null, "Game Over!!!\n"
					+ buttons[row][column].getText() + " won");
			reset();

		} else if ((buttons[0][column].getText() == (buttons[1][column]
				.getText()))
				&& (buttons[1][column].getText() == (buttons[2][column]
						.getText())) && (buttons[0][column].getText() != "")) {

			JOptionPane.showMessageDialog(null, "Game Over!!!\n"
					+ buttons[row][column].getText() + " won");
			reset();

		} else if ((buttons[0][0].getText() == (buttons[1][1].getText()))
				&& (buttons[1][1].getText() == (buttons[2][2].getText()))
				&& (buttons[1][1].getText() != "")) {
			JOptionPane.showMessageDialog(null, "Game Over!!!\n"
					+ buttons[row][column].getText() + " won");
			reset();

		} else if ((buttons[0][2].getText() == (buttons[1][1].getText()))
				&& (buttons[1][1].getText() == (buttons[2][0].getText()))
				&& (buttons[1][1].getText() != "")) {

			JOptionPane.showMessageDialog(null, "Game Over!!!\n"
					+ buttons[row][column].getText() + " won");
			reset();

		}

	}

	public void reset() {
		// reseting game
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j].setText("");
				buttons[i][j].setEnabled(true);
			}
		}
		moveCounter = 0;
	}

	public static void main(String[] args) {
		// Initializing game
		Tic_Tac_Toe_Game tic = new Tic_Tac_Toe_Game();
		tic.setVisible(true);
		tic.setSize(300, 300);
		tic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tic.setTitle("Tic-Tac-Toe");
		tic.setResizable(false);

	}

	private class moveListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			//counting moves
			moveCounter++;

			// getting source from action listener
			// and checking which button was pressed
			if (moveCounter % 2 != 0) {
				if (e.getSource() == buttons[0][0]) {
					buttons[0][0].setText("X");
					buttons[0][0].setEnabled(false);
					isGameOver(0, 0);

				} else if (e.getSource() == buttons[0][1]) {
					buttons[0][1].setText("X");
					buttons[0][1].setEnabled(false);
					isGameOver(0, 1);

				} else if (e.getSource() == buttons[0][2]) {
					buttons[0][2].setText("X");
					buttons[0][2].setEnabled(false);
					isGameOver(0, 2);

				} else if (e.getSource() == buttons[1][0]) {
					buttons[1][0].setText("X");
					buttons[1][0].setEnabled(false);
					isGameOver(1, 0);

				} else if (e.getSource() == buttons[1][1]) {
					buttons[1][1].setText("X");
					buttons[1][1].setEnabled(false);
					isGameOver(1, 1);

				} else if (e.getSource() == buttons[1][2]) {
					buttons[1][2].setText("X");
					buttons[1][2].setEnabled(false);
					isGameOver(1, 2);

				} else if (e.getSource() == buttons[2][2]) {
					buttons[2][2].setText("X");
					buttons[2][2].setEnabled(false);
					isGameOver(2, 2);

				} else if (e.getSource() == buttons[2][1]) {
					buttons[2][1].setText("X");
					buttons[2][1].setEnabled(false);
					isGameOver(2, 1);

				} else if (e.getSource() == buttons[2][0]) {
					buttons[2][0].setText("X");
					buttons[2][0].setEnabled(false);
					isGameOver(2, 0);

				}

			} else {
				if (e.getSource() == buttons[0][0]) {
					buttons[0][0].setText("O");
					buttons[0][0].setEnabled(false);
					isGameOver(0, 0);

				} else if (e.getSource() == buttons[0][1]) {
					buttons[0][1].setText("O");
					buttons[0][1].setEnabled(false);
					isGameOver(0, 1);

				} else if (e.getSource() == buttons[0][2]) {
					buttons[0][2].setText("O");
					buttons[0][2].setEnabled(false);
					isGameOver(0, 2);

				} else if (e.getSource() == buttons[1][0]) {
					buttons[1][0].setText("O");
					buttons[1][0].setEnabled(false);
					isGameOver(1, 0);

				} else if (e.getSource() == buttons[1][1]) {
					buttons[1][1].setText("O");
					buttons[1][1].setEnabled(false);
					isGameOver(1, 1);

				} else if (e.getSource() == buttons[1][2]) {
					buttons[1][2].setText("O");
					buttons[1][2].setEnabled(false);
					isGameOver(1, 2);

				} else if (e.getSource() == buttons[2][2]) {
					buttons[2][2].setText("O");
					buttons[2][2].setEnabled(false);
					isGameOver(2, 2);

				} else if (e.getSource() == buttons[2][1]) {
					buttons[2][1].setText("O");
					buttons[2][1].setEnabled(false);
					isGameOver(2, 1);

				} else if (e.getSource() == buttons[2][0]) {
					buttons[2][0].setText("0");
					buttons[2][0].setEnabled(false);
					isGameOver(2, 0);

				}

			}

			
			if (moveCounter == 9) {
				// Reseting game if it is a draw
				JOptionPane.showMessageDialog(null, "It was a draw");
				reset();
			}

		}
	}

}
