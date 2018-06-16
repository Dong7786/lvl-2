package SnakeRemastered;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectsManager {
	
	ArrayList<Snake> snakes = new ArrayList<Snake>();
	ArrayList<Food> food = new ArrayList<Food>();
	int foodAmount = 0;
	int randX;
	int randY;
	boolean isFood = false;
	ArrayList<Integer> xPos = new ArrayList<Integer>();
	ArrayList<Integer> yPos = new ArrayList<Integer>();

	ObjectsManager(Snake s, Snake sn) {
		
		
snakes.add(s);
snakes.add(sn);
}

	void draw(Graphics g) {
		for(int i = 0; i < snakes.size(); i ++) {
			snakes.get(i).draw(g);
		}
		for (int i = 0; i < food.size(); i++) {
			food.get(i).draw(g);
			
		}
		Font font = new Font("TRUETYPE_FONT",Font.BOLD, 25);
		g.setFont(font);
		g.drawString("Score = " + (snakes.get(0).size+1), 10, 40);
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
		for(int i = 0; i < snakes.size(); i ++) {
			snakes.get(i).update();
		}
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
for(int j = 0; j < snakes.size(); j ++) {
		for (int i = 0; i < food.size(); i++) {
			if (snakes.get(j).collisionBox.intersects(food.get(i).collisionBox)) {
				food.remove(i);
				snakes.get(j).size = snakes.get(j).size + 2;
				foodAmount = foodAmount - 1;
			}
		}
		for (int i = 0; i < snakes.get(j).tail.size() - 1; i++) {

			if (snakes.get(j).tail.get(snakes.get(j).tail.size() - 1).collisionBox.intersects(snakes.get(j).tail.get(i).collisionBox)) {
			
				
				snakes.get(j).size = 0;
				if(j == 0) {
				snakes.get(j).x = 940;
				snakes.get(j).y = 480;
				}else if(j == 1) {
					snakes.get(j).x = 460;
					snakes.get(j).y = 240;
				}
				snakes.get(j).up = false;
				snakes.get(j).down = false;
				snakes.get(j).right = false;
				snakes.get(j).left = false;
break;
			}
		}
	}
}
}
