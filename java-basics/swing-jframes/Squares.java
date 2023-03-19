package jframes;

import javax.swing.*;
import java.awt.*;

public class Squares {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(500, 500);
		frame.setVisible(true);

		JPanel red = new JPanel();
		red.setBackground(Color.red);
		red.setBounds(0, 0, 250, 250);
		frame.add(red);

		JPanel blue = new JPanel();
		blue.setBackground(Color.blue);
		blue.setBounds(250, 0, 250, 250);
		frame.add(blue);

		JPanel green = new JPanel();
		green.setBackground(Color.green);
		green.setBounds(0, 250, 250, 250);
		frame.add(green);

		JPanel yellow = new JPanel();
		yellow.setBackground(Color.yellow);
		yellow.setBounds(250, 250, 250, 250);
		frame.add(yellow);
	}
}
