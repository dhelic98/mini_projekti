package CreditCardValidation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Display extends JFrame {
	// Initializing content
	private JLabel title = new JLabel("Credit Card Number goes here:");
	private JTextField cardNumberInput = new JTextField();
	private JButton validButton = new JButton("Validate");

	public Display() {
		// Creating panel with data
		JPanel dataPanel = new JPanel(new GridLayout(2, 2, 16, 8));
		dataPanel.add(title);
		dataPanel.add(cardNumberInput);

		// Creating panel with button
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(validButton);
		Container c = getContentPane();
		c.add(dataPanel, BorderLayout.CENTER);
		c.add(buttonPanel, BorderLayout.EAST);
		// Calling action listener
		validButton.addActionListener(new ValidateListener());

	}

	private class ValidateListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			while (true) {
				try {
					// Input by user
					String cardNumber = cardNumberInput.getText();
					if ((cardNumber.length() < 13)
							|| (cardNumber.length() > 16)) {
						JOptionPane.showMessageDialog(null,
								"Lenght must be between 13 and 16 chars");
						break;

					}
					// Converting to long
					long cardNumberLong = Long.parseLong(cardNumber);
					// Condition for validation
					if (CreditCardValidation.isValid(cardNumberLong)) {
						JOptionPane.showMessageDialog(null,
								"Your credit card number is valid");
						break;
					} else if (!CreditCardValidation.isValid(cardNumberLong)) {
						JOptionPane.showMessageDialog(null,
								"Your credit card number is NOT VALID");
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
		// Creating JFrame
		Display display = new Display();
		display.setTitle("Credit Card Number Validation");
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.pack();
		display.setVisible(true);

	}

}
