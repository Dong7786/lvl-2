package SnakeRemastered;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class ObjectsManager implements MouseListener{

	ArrayList<Snake> snakes = new ArrayList<Snake>();
	static ArrayList<Food> food = new ArrayList<Food>();
	int foodAmount = 0;
	int randX;
	int randY;

	boolean isFood = false;
	int[][] arr = new int[94][45];
	ArrayList<Integer> xPos = new ArrayList<Integer>();
	ArrayList<Integer> yPos = new ArrayList<Integer>();

	ObjectsManager(Snake s, Snake sn) {
		for (int i = 0; i < 1900; i += 20) {
			xPos.add(i);
		}
		for (int i = 0; i < 920; i += 20) {
			yPos.add(i);
		}

		randX = xPos.get(new Random().nextInt(xPos.size()));
		randY = yPos.get(new Random().nextInt(yPos.size()));
		food.add(new Food(randX, randY, 19, 19));

		randX = xPos.get(new Random().nextInt(xPos.size()));
		randY = yPos.get(new Random().nextInt(yPos.size()));
		food.add(new Food(randX, randY, 19, 19));

		randX = xPos.get(new Random().nextInt(xPos.size()));
		randY = yPos.get(new Random().nextInt(yPos.size()));
		food.add(new Food(randX, randY, 19, 19));

		foodAmount = foodAmount + 3;

		snakes.add(s);
		snakes.add(sn);

		snakes.get(1).closestFood();
		System.out.println(snakes.get(1).foodX);
		System.out.println(snakes.get(1).foodY);
		System.out.println(yPos);

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
		g.drawString("Snake 1 = " + (snakes.get(0).size + 1), 10, 40);
		g.drawString("Snake 2 = " + (snakes.get(1).size + 1), 200, 40);
	}

	void update() {

		randX = xPos.get(new Random().nextInt(xPos.size()));
		randY = yPos.get(new Random().nextInt(yPos.size()));

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

			food.add(new Food(randX, randY, 19, 19));

			foodAmount = foodAmount + 1;

		}
		snakes.get(1).closestFood();
		snakes.get(1).AI();
		checkPosition();
	}

	void checkPosition() {
		for (int i = 0; i < 1900; i += 20) {
			xPos.add(i);
		}
		for (int i = 0; i < 920; i += 20) {
			yPos.add(i);
		}
		for (int i = 0; i < snakes.size(); i++) {
			int xPosition = snakes.get(i).x / 20;
			int y = snakes.get(i).y / 20;
//			if (xPosition >= 0 && y >= 0) {
//
//				xPos.remove(xPosition);
//				yPos.remove(y);
//			}
			for (int x = 0; x < snakes.get(i).tail.size(); x++) {
				if (snakes.get(i).tail.get(x).x / 20 >= 0 && snakes.get(i).tail.get(x).y / 20 >= 0) {
					if (xPos.contains(snakes.get(i).tail.get(x).x)) {
						xPos.remove(snakes.get(i).tail.get(x).x / 20);
					}
					if (yPos.contains(snakes.get(i).tail.get(x).y)) {
						yPos.remove(snakes.get(i).tail.get(x).y / 20);
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

				if (randX == snakes.get(o).x && randY == snakes.get(o).y
						|| randX == snakes.get(o).tail.get(s).x && randY == snakes.get(o).tail.get(s).y) {
					randX = xPos.get(new Random().nextInt(xPos.size()));
					randY = yPos.get(new Random().nextInt(yPos.size()));
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
