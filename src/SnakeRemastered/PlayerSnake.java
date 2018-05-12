package SnakeRemastered;

import java.awt.Graphics;
import java.util.ArrayList;

public class PlayerSnake extends GameObject {
	Tail tail1 = new Tail(960, 480, 19, 19);
	ArrayList<Tail> tail = new ArrayList<Tail>();
	int speed;
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	boolean downTail;
	boolean upTail;
	boolean leftTail;
	boolean rightTail;
boolean isMoving;
	PlayerSnake(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor st
		speed = 20;
	}

	void update() {
tail1.update();
		super.update();
		
		if (down == true) {
			downTail = true;
			y = y + speed;
			upTail = false;
			rightTail = false;
			leftTail = false;
		}
		if (up == true) {
			upTail = true;
			y = y - speed;
			downTail = false;
			leftTail = false;
			rightTail = false;
		}
		if (left == true) {
			leftTail = true;
			x = x - speed;
			rightTail = false;
			upTail = false;
			downTail = false;
		}
		if (right == true) {
			rightTail = true;
			x = x + speed;
			leftTail = false;
			upTail = false;
			downTail = false;
		}
		
	}

	void draw(Graphics g) {
	tail1.draw(g);
		g.fillRect(x, y, width, height);



	}
}
