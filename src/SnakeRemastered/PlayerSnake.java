package SnakeRemastered;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class PlayerSnake extends GameObject {

	ArrayList<Tail> tail = new ArrayList<Tail>();
ArrayList<Food> food = new ArrayList<Food>();
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
	int size = 10;
	boolean isFood = false;
Random rand = new Random();
	PlayerSnake(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor
		speed = 20;
	}

	void update() {
		super.update();

		for (int i = 0; i < tail.size(); i++) {
			tail.get(i).update();

		}
		for(int i = 0; i < food.size(); i ++) {
			food.get(i).update();
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
		tail.add(new Tail(x, y, 19, 19));
		if(isFood == false) {
			food.add(new Food(rand.nextInt(1900), rand.nextInt(952), 19, 19));
		}
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
		for(int i = 0; i < food.size(); i ++) {
			food.get(i).draw(g);
		}
		g.fillRect(x, y, width, height);

	}
}
