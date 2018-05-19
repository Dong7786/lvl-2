package SnakeRemastered;

import java.awt.Graphics;

public class Food extends GameObject {

	Food(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
	}

	void draw(Graphics g) {
g.fillRect(x, y, width, height);
	}

}
