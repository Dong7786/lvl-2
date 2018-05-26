package SnakeRemastered;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class PlayerSnake extends GameObject {

	ArrayList<Tail> tail = new ArrayList<Tail>();
ArrayList<Food> food = new ArrayList<Food>();
ArrayList<Integer> xPos = new ArrayList<Integer>();
ArrayList<Integer> yPos = new ArrayList<Integer>();
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
	boolean isFood = false;
	int randX;
	int randY;
int foodAmount = 0 ;
	PlayerSnake(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor
		speed = 20;
		for(int i = 0 ; i < 1919; i += 20) {
			xPos.add(i);
		}
		for(int i = 0 ; i < 950; i += 20) {
			yPos.add(i);
		}
	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
		randX= xPos.get(new Random().nextInt(xPos.size()));
		randY = yPos.get(new Random().nextInt(yPos.size()));
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
			
			food.add(new Food(randX , randY, 19, 19));
			
			foodAmount = foodAmount + 1;
			
		}
		if(foodAmount == 3) {
			isFood = true;
		}
		if(foodAmount < 3) {
			isFood = false;
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
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);

	}

	
}
