package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Aliens extends GameObject {

	Aliens(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
		collisionBox.setBounds(x, y, width, height);
		y++;
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.aliensImg, x, y, width, height, null);
	}
}
