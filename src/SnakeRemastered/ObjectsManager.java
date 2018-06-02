package SnakeRemastered;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectsManager {
	Snake snake;
ArrayList<Snake> snakes = new ArrayList<Snake>();
ArrayList<Food> food = new ArrayList<Food>();
int foodAmount = 0;
int randX;
int randY;
boolean isFood = false;
ArrayList<Integer> xPos = new ArrayList<Integer>();
ArrayList<Integer> yPos = new ArrayList<Integer>();
	ObjectsManager(Snake s) {
		snake = s;

	}

	void draw(Graphics g) {
		snake.draw(g);
		for (int i = 0; i < food.size(); i++) {
			food.get(i).draw(g);
		}
	}

	void update() {
		for (int i = 0; i < 1919; i += 20) {
			xPos.add(i);
		}
		for (int i = 0; i < 950; i += 20) {
			yPos.add(i);
		}
		randX = xPos.get(new Random().nextInt(xPos.size()));
		randY = yPos.get(new Random().nextInt(yPos.size()));
		
		for (int i = 0; i < food.size(); i++) {
			food.get(i).update();
		}
		snake.update();
		checkCollision();
		if (isFood == false) {

			food.add(new Food(randX, randY, 19, 19));

			foodAmount = foodAmount + 1;

		}
		if (foodAmount == 3) {
			isFood = true;
		}
		if (foodAmount < 3) {
			isFood = false;
		}
	}

	void checkCollision() {

		for (int i = 0; i < food.size(); i++) {
			if (snake.collisionBox.intersects(food.get(i).collisionBox)) {
				food.remove(i);
				snake.size = snake.size + 2;
				foodAmount = foodAmount - 1;
			}
		}
		for (int i = 0; i < snake.tail.size(); i++) {
		
			if(snake.collisionBox.intersects(snake.tail.get(i).collisionBox)) {
				System.out.println("Hit");
			}
		}
	}
}
