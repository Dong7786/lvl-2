package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;
	boolean up;
	boolean down;
	boolean left;
	boolean right;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	}

	void update() {
		super.update();
		collisionBox.setBounds(x, y, width, height);
		if (down == true) {
			y = y + speed;
		}
		if (up == true) {
			y = y - speed;
		}
		if (left == true) {
			x = x - speed;
		}
		if (right == true) {
			x = x + speed;
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.rImg, x, y, width, height, null);
	}
}
