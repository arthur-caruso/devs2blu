package jframes;

import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class Main {
	public static void main(String[] args) {

		JFrame frame= new JFrame();
		frame.setTitle("Minha Janela");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JPanel headingPanel = new JPanel();
		JLabel headingLabel = new JLabel("Concorra a um gorilhão de dólares: ");
		headingPanel.add(headingLabel);
		JPanel panel = new JPanel(new GridBagLayout());

		GridBagConstraints constr = new GridBagConstraints();
		constr.insets = new Insets(5, 5, 5, 5);
		constr.anchor = GridBagConstraints.WEST;

		constr.gridx=0;
		constr.gridy=0;

		JLabel nameLabel = new JLabel("Nome :");
		JLabel emailLabel = new JLabel("Email :");
		JLabel phoneLabel = new JLabel("Telefone :");

		JTextField nameInput = new JTextField(20);
		JTextField emailInput = new JTextField(20);
		JTextField phoneInput = new JTextField(20);

		panel.add(nameLabel, constr);
		constr.gridx=1;
		panel.add(nameInput, constr);
		constr.gridx=0;
		constr.gridy=1;
		panel.add(emailLabel, constr);
		constr.gridx=1;
		panel.add(emailInput, constr);
		constr.gridx=0;
		constr.gridy=2;
		panel.add(phoneLabel, constr);
		constr.gridx=1;
		panel.add(phoneInput, constr);
		constr.gridx=0;
		constr.gridy=3;

		constr.anchor = GridBagConstraints.CENTER;

		JButton button = new JButton("Enviar");
		button.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					headingLabel.setText("Seu tolo! esse programa não faz nada.");
					nameInput.setText("");
					emailInput.setText("");
					phoneInput.setText("");
				}
			}
		);

		panel.add(button, constr);
		mainPanel.add(headingPanel);
		mainPanel.add(panel);
		frame.add(mainPanel);
		frame.pack();
		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
