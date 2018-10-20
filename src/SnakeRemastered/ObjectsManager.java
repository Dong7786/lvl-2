package SnakeRemastered;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ObjectsManager{

	ArrayList<Snake> snakes = new ArrayList<Snake>();
	static ArrayList<Food> food = new ArrayList<Food>();
	int foodAmount = 0;
	int randX;
	int randY;

	boolean isFood = false;
	int[][] arr = new int[94][48];
	int Mode = 0;
	
	

	ObjectsManager(Snake s, Snake sn) {
		for(int i = 0; i < 48 ; i ++) {
			arr[0][i] = 1; 
		}
		for(int i = 0; i < 94 ; i ++) {
			arr[i][0] = 1; 
		}

		randX = new Random().nextInt(94);
		randY = new Random().nextInt(48);
		while(arr[randX][randY] == 1) {
			randX = new Random().nextInt(94);
			randY = new Random().nextInt(48);
			
		}
		food.add(new Food(randX * 20, randY * 20, 19, 19));

		randX = new Random().nextInt(94);
		randY = new Random().nextInt(48);
		while(arr[randX][randY] == 1) {
			randX = new Random().nextInt(94);
			randY = new Random().nextInt(48);
			
		}
		food.add(new Food(randX * 20, randY * 20, 19, 19));

		randX = new Random().nextInt(94);
		randY = new Random().nextInt(48);
		while(arr[randX][randY] == 1) {
			randX = new Random().nextInt(94);
			randY = new Random().nextInt(48);
			
		}
		food.add(new Food(randX * 20, randY * 20, 19, 19));

		foodAmount = foodAmount + 3;

		snakes.add(s);
		snakes.add(sn);

		snakes.get(1).closestFood();
		

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
		if(Mode == 0) {
			g.drawString("Score = " + (snakes.get(0).size + 1), 10, 40);
			
			g.drawString("Score = " + (snakes.get(1).size + 1), 150, 40);
			
		}
		if( Mode == 2 || Mode == 3) {
			
			g.drawString("Blue = " + (snakes.get(0).size + 1), 10, 40);
		
			g.drawString("Red = " + (snakes.get(1).size + 1), 150, 40);
			
		}else if(Mode == 1) {
			g.drawString("Score = " + (snakes.get(0).size + 1), 10, 40);
			
		}
		start(g);
			
	}
	
	
	void start(Graphics g) {
		Font f = new Font("TRUETYPE_FONT", Font.BOLD, 15);
		if(Mode == 0) {
			snakes.get(0).color = 3;
			snakes.get(1).color = 3;
			snakes.get(0).AI();
			snakes.get(1).AI();
		}else if(Mode == 1) {
			snakes.get(0).color = 3;
			snakes.get(1).x = 2000;
			
		}else if(Mode == 2) {
			snakes.get(1).AI();
			snakes.get(0).color = 2;
			snakes.get(1).color = 1;
			
			
		}else if(Mode == 3) {
			snakes.get(0).color = 2;
			snakes.get(1).color = 1;
			
			
			
		}
	
		
		if(Mode == 0) {
			g.setFont(f);
			g.fillRect(710, 320, 480, 280);
			g.setColor(Color.GRAY);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(5));
			g2.drawRect(710, 320, 480, 280);
			g.setColor(Color.RED);
			
			g.drawString("SnakeRemastered", 885, 340);
			g.drawString("Choose your Perfered Game style:", 735, 380);
			g.setColor(Color.BLACK);
			g.drawString("Press 1 for OG Snake", 735, 420);
			g.drawString("Press 2 For Multiplayer", 735, 460);
			g.drawString("Controls; Red W A S D, Blue Arrow Keys", 735, 480);
			g.drawString("Press 3 to play a Bot", 735, 520);
			g.drawString("You are blue, Controls: Arrow Keys", 735, 540);
		
			
		}if(Mode == 4) {
			snakes.get(0).color = 1;
			snakes.get(1).color = 2;
			snakes.get(0).AI();
			snakes.get(1).AI();
			System.out.println("Red Snake X: " + snakes.get(0).x + " Y:" + snakes.get(0).y );
			System.out.println("Blue Snake X: " + snakes.get(1).x + " Y:" + snakes.get(1).y );
			
		}
		
		
		
		
		
	
	}
	void update() {

		randX = new Random().nextInt(94);
		randY = new Random().nextInt(48);

		for (int i = 0; i < food.size(); i++) {
			food.get(i).update();
		}
		for (int i = 0; i < snakes.size(); i++) {
			snakes.get(i).update();

		}

		checkCollision();
		if (foodAmount >= 3) {
			isFood = true;
		}
		if (foodAmount < 3) {
			isFood = false;
		}

		if (isFood == false) {

			
			while(arr[randX][randY] == 1) {
				randX = new Random().nextInt(94);
				randY = new Random().nextInt(48);
				
			}
			food.add(new Food(randX * 20, randY * 20, 19, 19));

			foodAmount = foodAmount + 1;

		}
		snakes.get(1).closestFood();
		snakes.get(1).closestFood();
		checkPosition();
	}

	void checkPosition() {
		
		for (int i = 0; i < snakes.size(); i++) {
			int xPosition = snakes.get(i).x / 20;
			int yPosition = snakes.get(i).y / 20;
			 if(xPosition >= 0 && yPosition >= 0) {
 if(xPosition < 94 && yPosition < 48) {
	 arr[xPosition][yPosition] = 1;
	 
 }
			 }
			for (int x = 0; x < snakes.get(i).tail.size(); x++) {
				if (snakes.get(i).tail.get(x).x / 20 >= 0 && snakes.get(i).tail.get(x).y / 20 >= 0) {
					if(snakes.get(i).tail.get(x).x / 20 < 94 && snakes.get(i).tail.get(x).y / 20 < 48) {
						arr[snakes.get(i).tail.get(x).x / 20][snakes.get(i).tail.get(x).y / 20] = 1;
						
					}

				}
			}
		}
}

	

	void checkCollision() {

		if (snakes.get(0).collisionBox.intersects(snakes.get(1).collisionBox)) {
			snakes.get(1).x = 460;
			snakes.get(1).y = 240;
			snakes.get(1).size = 0;
			snakes.get(1).up = false;
			snakes.get(1).down = false;
			snakes.get(1).right = false;
			snakes.get(1).left = false;

			snakes.get(0).x = 940;
			snakes.get(0).y = 480;
			snakes.get(0).size = 0;
			snakes.get(0).up = false;
			snakes.get(0).down = false;
			snakes.get(0).right = false;
			snakes.get(0).left = false;
		}
		for (int i = 0; i < snakes.get(0).tail.size(); i++) {
			if (snakes.get(1).collisionBox.intersects(snakes.get(0).tail.get(i).collisionBox)) {
				snakes.get(1).x = 460;
				snakes.get(1).y = 240;
				snakes.get(1).size = 0;
				snakes.get(1).up = false;
				snakes.get(1).down = false;
				snakes.get(1).right = false;
				snakes.get(1).left = false;

			}
		}
		for (int i = 0; i < snakes.get(1).tail.size(); i++) {
			if (snakes.get(0).collisionBox.intersects(snakes.get(1).tail.get(i).collisionBox)) {
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
					
						snakes.get(1).closestFood();
					
				}

			}
		}

		for (int o = 0; o < snakes.size(); o++) {
			for (int s = 1; s < snakes.get(o).tail.size(); s++) {

				if (snakes.get(o).tail.get(0).collisionBox.intersects(snakes.get(o).tail.get(s).collisionBox)) {
					if (o == 0) {
						snakes.get(0).x = 940;
						snakes.get(0).y = 480;
						snakes.get(0).size = 0;
						snakes.get(0).up = false;
						snakes.get(0).down = false;
						snakes.get(0).right = false;
						snakes.get(0).left = false;
					} else {
						snakes.get(1).x = 460;
						snakes.get(1).y = 240;
						snakes.get(1).size = 0;
						snakes.get(1).up = false;
						snakes.get(1).down = false;
						snakes.get(1).right = false;
						snakes.get(1).left = false;
					}
				}
			}
		}

		for (int o = 0; o < snakes.size(); o++) {
			for (int s = 0; s < snakes.get(o).tail.size(); s++) {

				if (randX * 20 == snakes.get(o).x && randY * 20 == snakes.get(o).y
						|| randX * 20 == snakes.get(o).tail.get(s).x && randY * 20 == snakes.get(o).tail.get(s).y) {
					randX = new Random().nextInt(94);
					randY = new Random().nextInt(48);
					while(arr[randX][randY] == 1) {
						randX = new Random().nextInt(94);
						randY = new Random().nextInt(48);
						
					}
				}
			}
		}
		for(int i = 0; i < snakes.size(); i++) {
			for(int t = 0; t < snakes.get(i).tail.size(); t++) {
				for(int s = 0; s < snakes.get(i).tail.size() ; s ++ ) {
					if(snakes.get(i).tail.get(t) != snakes.get(i).tail.get(s)) {
						
						if(snakes.get(i).tail.get(t).collisionBox.intersects(snakes.get(i).tail.get(s).collisionBox)) {
							
							if(i == 0) {
								snakes.get(0).x = 940;
								snakes.get(0).y = 480;
								snakes.get(0).size = 0;
								snakes.get(0).up = false;
								snakes.get(0).down = false;
								snakes.get(0).right = false;
								snakes.get(0).left = false;
							}else if(i == 1) {
								snakes.get(1).x = 460;
								snakes.get(1).y = 240;
								snakes.get(1).size = 0;
								snakes.get(1).up = false;
								snakes.get(1).down = false;
								snakes.get(1).right = false;
								snakes.get(1).left = false;
							}
							
							
						}
						
					}
				}
				
				
			}
			
		}
	}
}
