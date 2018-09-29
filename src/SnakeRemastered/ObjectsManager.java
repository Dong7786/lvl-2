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

public class ObjectsManager implements MouseListener{

	ArrayList<Snake> snakes = new ArrayList<Snake>();
	static ArrayList<Food> food = new ArrayList<Food>();
	int foodAmount = 0;
	int randX;
	int randY;
int stage = 0;
	boolean isFood = false;
	int[][] arr = new int[94][45];
	int Mode = 0;
	
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
		snakes.get(0).color = 2;
		snakes.get(1).color = 1;
		g.setFont(font);
		if(Mode == 0 || Mode == 2 || Mode == 3) {
			
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
			snakes.get(0).AI();
			snakes.get(1).AI();
		}else if(Mode == 1) {
			snakes.remove(1);
			
		}else if(Mode == 2) {
			snakes.get(1).AI();
			
		}else if(Mode == 3) {
			
			
		}
		
		if(Mode == 0) {
			g.setFont(f);
			g.fillRect(710, 320, 480, 280);
			g.setColor(Color.GRAY);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(5));
			g2.drawRect(710, 320, 480, 280);
			g.setColor(Color.BLACK);
			
			g.drawString("SnakeRemastered", 885, 340);
			g.drawString("Choose your Perfered Game style by pressing the", 735, 380);
			g.drawString("button below. Original is just OG Snake. Double is to ", 735, 400);
			g.drawString("play with another person(Red controls are W A S D", 735, 420);
			g.drawString("Blue controls are the arrow keys). Single is to play", 735, 440);
			g.drawString("with an AI(Use Arrow keys to control the Blue snake).", 735, 460);
			
			
		}
		
		
		
		
		
	
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
		snakes.get(1).closestFood();
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
