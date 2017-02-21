package Game_Craps;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import jdk.nashorn.internal.scripts.JO;

public class Craps extends JFrame {
	// Initializing object
	private CrapsData craps = new CrapsData();

	// Creating frame contenct
	private JLabel moneyLabel = new JLabel("Total Money");
	private JLabel betLabel = new JLabel("Bet Amount");
	private JLabel moneyField = new JLabel(craps.getMoney() + "");
	private JTextField betField = new JTextField("Enter here:$$$");
	private JButton rollButton = new JButton("Roll");

	public Craps() {

		// creating panel with data/text fields
		JPanel dataPanel = new JPanel(new GridLayout(2, 2, 12, 6));
		dataPanel.add(moneyLabel);
		dataPanel.add(betLabel);
		dataPanel.add(moneyField);
		dataPanel.add(betField);

		// button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(rollButton);
		Container c = getContentPane();
		c.add(dataPanel, BorderLayout.CENTER);
		c.add(buttonPanel, BorderLayout.SOUTH);
		// Calling action listener
		rollButton.addActionListener(new RollListener());

	}

	private class RollListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// variables for tracking the game
			int play = 0;
			boolean playAgain = true;
			// condition for game
			while (playAgain && play == 0) {
				try {
					// Initializing point/rolled
					int point = 0;
					// Input by user
					double money = craps.getMoney();
					String input = betField.getText();
					double bet = Double.parseDouble(input);
					// Condition for bet
					if (bet > money) {
						JOptionPane
								.showMessageDialog(
										null,
										"Bet is greater than ammount of money in account",
										"ERROR", JOptionPane.ERROR_MESSAGE);
						break;

					}
					// infinite loop
					for (int i = 1; i >= 1; i++) {
						// Calling random from util
						Random random = new Random();
						// getting random
						int diceSum = random.nextInt(12) + 1;
						// condition for vicotry
						if (diceSum == 7 || diceSum == 11) {

							JOptionPane.showMessageDialog(null,
									"You Win!!!\n You rolled: " + diceSum);
							play++;
							craps.setMoney(money + bet);
							moneyField.setText(craps.getMoney() + "");
							break;

						} else if (diceSum == 2 || diceSum == 3
								|| diceSum == 12) {
							// condition for loss

							JOptionPane.showMessageDialog(null,
									"You lost :( Better luck next time\nYou rolled: "
											+ diceSum);
							play++;
							craps.setMoney(money - bet);
							moneyField.setText(craps.getMoney() + "");

							if (money == 0)
								JOptionPane.showMessageDialog(null,
										"Out of Money", "ERROR",
										JOptionPane.WARNING_MESSAGE);

							break;

						} else {
							// setting point and rolling again
							point = diceSum;
							diceSum = random.nextInt(12) + 1;
							JOptionPane.showMessageDialog(null, "You rolled "
									+ point + "\nNew point is: " + point);
							// loop that rolls till user wins or loses
							while (true) {
								// condition for vicotry
								if (diceSum == point) {

									JOptionPane.showMessageDialog(null,
											"WIN!!! \n" + "You rolled a "
													+ diceSum);
									play++;

									craps.setMoney(money + bet);
									moneyField.setText(craps.getMoney() + "");

									break;
								} else if (diceSum == 7) {
									// condition for loss

									JOptionPane.showMessageDialog(null,
											"You lost :( Better luck next time\nYou rolled: "
													+ diceSum);
									play++;
									craps.setMoney(money - bet);
									moneyField.setText(craps.getMoney() + "");
									if (money < bet)
										JOptionPane.showMessageDialog(null,
												"Out of Money", "ERROR",
												JOptionPane.WARNING_MESSAGE);

									break;
								} else {
									diceSum = random.nextInt(12) + 1;

								}
							}

						}
						break;

					}

				} catch (Exception ex) {
					// exception
					JOptionPane.showMessageDialog(null, "Wrong input");
					break;
				}

			}

		}
	}

	public static void main(String[] args) {
		// Initializing JFrame and making it visible
		Craps craps = new Craps();
		craps.setTitle("Craps_Game");
		craps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		craps.pack();
		craps.setVisible(true);

	}

}
