package SnakeRemastered;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake {
	// max height 972
	// max width 1920
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 992;
	JFrame frame;
GamePanel panel;
	public static void main(String[] args) {
Snake snake = new Snake();
	}

	Snake() {
		frame = new JFrame();
		panel = new GamePanel();
setup();
	}
	void setup() {
		
		frame.add(panel);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.startGame();
		frame.addKeyListener(panel);
	}
	
}
