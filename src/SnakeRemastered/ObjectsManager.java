package SnakeRemastered;

import java.awt.Graphics;

public class ObjectsManager {
	PlayerSnake snake;

	ObjectsManager(PlayerSnake s) {
		snake = s;

	}

	void draw(Graphics g) {
		snake.draw(g);
		
	}

	void update() {
		snake.update();
		for(int i = 0; i < snake.food.size(); i++) {
			if(snake.collisionBox.intersects(snake.food.get(i).collisionBox)) {
				snake.food.remove(i);
				snake.size = snake.size + 2;
				snake.foodAmount = snake.foodAmount - 1;
			}
		}

	}
	void checkCollision() {
		
	}
}
