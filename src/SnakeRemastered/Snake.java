
package SnakeRemastered;

import java.awt.Color;
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
			up = false;
			right = false;
			left = false;

		
			y = y + speed;
			
			GamePanel.keyPressed = false;
			GamePanel.pressedKey = false;
		}

		if (up == true) {
			down = false;
			right = false;
			left = false;
			
			
			y = y - speed;
			
			GamePanel.keyPressed = false;
			GamePanel.pressedKey = false;
		}
		if (left == true) {
			up = false;
			down = false;
			right = false;
			
			
			x = x - speed;
			
			GamePanel.keyPressed = false;
			GamePanel.pressedKey = false;
		}
		if (right == true) {
			up = false;
			down = false;
			left = false;
			
			
			x = x + speed;
			
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

	int foodY;
	int foodX;

	void closestFood() {
		// System.out.println("find closest food foodX"+foodX + "foodY " + foodY );
		foodY = ObjectsManager.food.get(0).collisionBox.x;
		foodX = ObjectsManager.food.get(0).collisionBox.y;

		double shortDis = Math.sqrt(Math.pow(foodX - this.x, 2) + Math.pow(foodY - this.y, 2));

		for (int i = 0; i < ObjectsManager.food.size(); i++) {
			double currentDis = Math.sqrt(Math.pow(ObjectsManager.food.get(i).x - this.x, 2)
					+ Math.pow(ObjectsManager.food.get(i).y - this.y, 2));

			if (currentDis < shortDis) {
				shortDis = currentDis;
				foodX = ObjectsManager.food.get(i).collisionBox.x;
				foodY = ObjectsManager.food.get(i).collisionBox.y;

			}

		}
		// System.out.println("closest food found at: foodX: "+foodX + "foodY: " + foodY
		// );

	}

	void AI() {

		if (isMoving == false) {

			if (foodX > this.x && foodY <= this.y) {
				right = false;
				up = false;
				down = false;
				left = true;
			} else if (foodY < this.y && foodX >= this.x) {
				right = false;
				down = false;
				left = false;
				up = true;
			} else if (foodX > this.x && foodY >= this.y) {
				left = false;
				up = false;
				down = false;
				right = true;
			} else if (foodX <= this.x && foodY > this.y) {
				up = false;
				right = false;
				left = false;
				down = true;
			}
		}
		if (right == true) {

			if (foodX < this.x && foodY < this.y) {
				right = false;
				up = true;
				System.out.println("go up because Foody < snakeY and x > foodX");
			} else if (foodX < this.x && foodY == this.y) {
				right = false;
				up = true;
				System.out.println("go up because foodY == y and foodX < x");
			} else if (foodX < this.x && foodY > this.y) {
				right = false;
				down = true;
				System.out.println("go down because foodY > y and foodX < x");
			} else if (foodX > this.x && foodY < this.y) {
				right = false;
				up = true;
				System.out.println("4");
			} else if (foodX > this.x && foodY == this.y) {

				System.out.println("5");
			} else if (foodX > this.x && foodY > this.y) {
				right = false;
				down = true;
				System.out.println("6");
			} else if (foodX == this.x && foodY < this.y) {
				right = false;
				up = true;
				System.out.println("7");
			} else if (foodX == this.x && foodY > this.y) {
				right = false;
				down = true;
				System.out.println("8");
			}

		}
		if (left == true) {

			if (foodX < this.x && foodY < this.y) {
				left = false;
				up = true;
				System.out.println("11");
			} else if (foodX < this.x && foodY == this.y) {
				System.out.println("12");

			} else if (foodX < this.x && foodY > this.y) {
				left = false;
				down = true;
				System.out.println("13");
			} else if (foodX > this.x && foodY < this.y) {
				left = false;
				up = true;
				System.out.println("14");
			} else if (foodX > this.x && foodY == this.y) {
				left = false;
				up = true;
				System.out.println("Go up because foodX > x and foodY == y");

			} else if (foodX > this.x && foodY > this.y) {
				left = false;
				down = true;
				System.out.println("16");
			} else if (foodX == this.x && foodY < this.y) {
				left = false;
				up = true;
				System.out.println("17");
			} else if (foodX == this.x && foodY > this.y) {
				left = false;
				down = true;
				System.out.println("18");
			}

		}
		if (up == true) {

			if (foodX < this.x && foodY > this.y) {
				up = false;
				left = true;
				System.out.println("Up 1");
			} else if (foodX > this.x && foodY > this.y) {
				up = false;
				right = true;
				System.out.println("Up 2");
			} else if (foodX == this.x && foodY > this.y) {
				up = false;
				left = true;
				System.out.println("Up 3");
			} else if (foodX < this.x && foodY == this.y) {
				up = false;
				left = true;
				closestFood();
				System.out.println("go left because foodX < x and foodY == y");
			} else if (foodX > this.x && foodY == this.y) {
				up = false;
				right = true;
				closestFood();
				System.out.println("Go right because foodX > x and foodY == y");
			}
		}
		if (down == true) {

			if (foodX < this.x && foodY < this.y) {
				down = false;
				left = true;
				System.out.println("Down 1");
			} else if (foodX > this.x && foodY < this.y) {
				down = false;
				right = true;
				System.out.println("Down 2");
			} else if (foodX == this.x && foodY < this.y) {

				down = false;
				right = true;
				System.out.println("Down 3");
			} else if (foodX < this.x && foodY == this.y) {
				down = false;
				left = true;
				System.out.println("Down 4");
			} else if (foodX > this.x && foodY == this.y) {
				down = false;
				right = true;
				System.out.println("Down 5");
			}
		}
		System.out.println("food " + foodY + " " + foodX);
		System.out.println("Snake " + this.y + " " + this.x);

	}

	void draw(Graphics g) {

		for (int i = 0; i < tail.size(); i++) {
			tail.get(i).draw(g);

		}

		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);

	}

}
