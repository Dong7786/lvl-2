package SnakeRemastered;

import java.awt.Graphics;
import java.util.ArrayList;

public class PlayerSnake extends GameObject {
	ArrayList<Snake> tail = new ArrayList<Snake>();
	int speed;
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	boolean downTail;
	boolean upTail;
	boolean leftTail;
	boolean rightTail;

	PlayerSnake(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 20;
	}

	void update() {

		super.update();
		if (down == true) {
			downTail = true;

			upTail = false;
			rightTail = false;
			leftTail = false;
		}
		if (up == true) {
			upTail = true;

			downTail = false;
			leftTail = false;
			rightTail = false;
		}
		if (left == true) {
			leftTail = true;

			rightTail = false;
			upTail = false;
			downTail = false;
		}
		if (right == true) {
			rightTail = true;

			leftTail = false;
			upTail = false;
			downTail = false;
		}
	}

	void draw(Graphics g) {

		g.fillRect(x, y, width, height);
		if (rightTail == true) {
			g.drawRect(x + 20, y, width, height);
			x = x + 20;
		}
		if (leftTail == true) {
			g.drawRect(x - 20, y, width, height);
			x = x - 20;
		}
		if (upTail == true) {
			g.drawRect(x, y - 20, width, height);
			y= y - 20;
		}
		if (downTail == true) {
			g.drawRect(x, y + 20, width, height);
			y = y + 20;
		}
	}
}
