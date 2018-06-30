
package SnakeRemastered;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Snake extends GameObject {

	ArrayList<Tail> tail = new ArrayList<Tail>();

	Random rand = new Random();
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
	int size = 0;

	Snake(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor
		speed = 20;

	}

	void update() {

		collisionBox.setBounds(x, y, width, height);

		super.update();

		for (int i = 0; i < tail.size(); i++) {
			tail.get(i).update();

		}

		while (tail.size() > size) {
			tail.remove(0);
		}

		if (down == true) {
			downTail = true;
			y = y + speed;
		
			upTail = false;
			rightTail = false;
			leftTail = false;
			GamePanel.keyPressed = false;
			GamePanel.pressedKey = false;
		}
		
		if (up == true) {
			upTail = true;
			y = y - speed;
			downTail = false;
			leftTail = false;
			rightTail = false;
			GamePanel.keyPressed = false;
			GamePanel.pressedKey = false;
		}
		if (left == true) {
			leftTail = true;
			x = x - speed;
			rightTail = false;
			upTail = false;
			downTail = false;
			GamePanel.keyPressed = false;
			GamePanel.pressedKey = false;
		}
		if (right == true) {
			rightTail = true;
			x = x + speed;
			leftTail = false;
			upTail = false;
			downTail = false;
			GamePanel.keyPressed = false;
			GamePanel.pressedKey = false;
		}
		
		tail.add(new Tail(x, y, 19, 19));

		if (up == true || down == true || right == true || left == true) {
			isMoving = true;

		} else {
			isMoving = false;
		}

	}

	void draw(Graphics g) {
	
		
		for (int i = 0; i < tail.size(); i++) {
			tail.get(i).draw(g);

		}

		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);

	}

}
