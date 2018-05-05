package SnakeRemastered;

import java.awt.Graphics;

public class PlayerSnake extends GameObject {
	int speed;
	boolean up;
	boolean down;
	boolean left;
	boolean right;

	PlayerSnake(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 20;
	}

	void update() {
		
		super.update();
		if (down == true) {
		System.out.println("down");
			y = y + speed;
		}
		if (up == true) {
			System.out.println("up");
			y = y - speed;
		}
		if (left == true) {
			System.out.println("left");
			x = x - speed;
		}
		if (right == true) {
			System.out.println("right");
			x = x + speed;
		}
	}
	void draw(Graphics g) {
		System.out.println("1");
		g.fillRect(x, y, width, height);
	}
}
