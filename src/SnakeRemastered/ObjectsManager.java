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
		for (int i = 0; i < snakes.size(); i++) {
			snakes.get(i).draw(g);
		}
		for (int i = 0; i < food.size(); i++) {
			food.get(i).draw(g);

		}
		Font font = new Font("TRUETYPE_FONT", Font.BOLD, 25);
		g.setFont(font);
		g.drawString("Score = " + (snakes.get(0).size + 1), 10, 40);
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
		for (int i = 0; i < snakes.size(); i++) {
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
		
		if(snakes.get(0).collisionBox.intersects(snakes.get(1).collisionBox)){
			snakes.get(1).x = 940;
			snakes.get(1).y = 480;
			snakes.get(1).size = 0;
			snakes.get(1).up = false;
			snakes.get(1).down = false;
			snakes.get(1).right = false;
			snakes.get(1).left = false;
			
			snakes.get(0).x = 460;
			snakes.get(0).y = 240;
			snakes.get(0).size = 0;
			snakes.get(0).up = false;
			snakes.get(0).down = false;
			snakes.get(0).right = false;
			snakes.get(0).left = false;
		}
		for(int i = 0; i < snakes.get(0).tail.size(); i++) {
			if(snakes.get(1).collisionBox.intersects(snakes.get(0).tail.get(i).collisionBox)) {
				snakes.get(1).x = 940;
				snakes.get(1).y = 480;
				snakes.get(1).size = 0;
				snakes.get(1).up = false;
				snakes.get(1).down = false;
				snakes.get(1).right = false;
				snakes.get(1).left = false;
				
			}
		}
		for(int i = 0; i < snakes.get(1).tail.size();i++) {
			if(snakes.get(0).collisionBox.intersects(snakes.get(1).tail.get(i).collisionBox)) {
				snakes.get(0).x = 460;
				snakes.get(0).y = 240;
				snakes.get(0).size = 0;
				snakes.get(0).up = false;
				snakes.get(0).down = false;
				snakes.get(0).right = false;
				snakes.get(0).left = false;
			}
		}
		
		
		
		for (int j = 0; j < snakes.size(); j++) {
			for (int i = 0; i < food.size(); i++) {
				if (snakes.get(j).collisionBox.intersects(food.get(i).collisionBox)) {
					food.remove(i);
					snakes.get(j).size = snakes.get(j).size + 2;
					foodAmount = foodAmount - 1;
				}
				
			}
		}
	}

}
