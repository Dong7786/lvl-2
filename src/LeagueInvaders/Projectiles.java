package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectiles extends GameObject {
	int speed = 10;

	Projectiles(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
		collisionBox.setBounds(x, y, width, height);
		y = y - speed;
		if (y <= 0) {
			isAlive = false;
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.bulletsImg, x, y, width, height, null);
		
	}

}
