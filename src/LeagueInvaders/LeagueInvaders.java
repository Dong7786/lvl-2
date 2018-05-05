package LeagueInvaders;

import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {

	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	JFrame frame;
	GamePanel panel;

	public static void main(String[] args) {
		LeagueInvaders league = new LeagueInvaders();
	}

	LeagueInvaders() {
		panel = new GamePanel();
		frame = new JFrame();
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
