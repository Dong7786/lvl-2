
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
	int Xplace;
	int Yplace;
	boolean isMoving;
	int size = 0;
	int color;

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

		if (down == true && up == false) {
			up = false;
			right = false;
			left = false;

			y = y + speed;

			GamePanel.keyPressed = false;
			GamePanel.pressedKey = false;
		}

		if (up == true && down == false) {
			down = false;
			right = false;
			left = false;

			y = y - speed;

			GamePanel.keyPressed = false;
			GamePanel.pressedKey = false;
		}
		if (left == true && right == false) {
			up = false;
			down = false;
			right = false;

			x = x - speed;

			GamePanel.keyPressed = false;
			GamePanel.pressedKey = false;
		}
		if (right == true && left == false) {
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

		foodY = ObjectsManager.food.get(0).collisionBox.y;
		foodX = ObjectsManager.food.get(0).collisionBox.x;

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

	}

	void AI() {
		closestFood();
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
			} else {
				left = false;
				up = false;
				down = false;
				right = true;
			}
		}

		// ---

		if (right == true && left == false) {

			// if(x / 20 > 0 && x / 20 + 2 < 94 && y / 20 > 0 && y / 20 + 2 < 47 ) {
			// if(ObjectsManager.arr[x/20 + 2][y/20] == 1 || ObjectsManager.arr[x/20 +
			// 1][y/20] == 1) {
			// if(ObjectsManager.arr[x/20][y/20 + 2] != 1 || ObjectsManager.arr[x/20][y/20 +
			// 1] != 1) {
			// down = true;
			//
			// }else {
			// up = true;
			//
			// }
			//
			// }
			// }
			if (foodX < this.x && foodY < this.y) {
				right = false;
				up = true;

			} else if (foodX < this.x && foodY == this.y) {
				right = false;
				up = true;

			} else if (foodX < this.x && foodY > this.y) {
				right = false;
				down = true;

			} else if (foodX > this.x && foodY < this.y) {
				right = false;
				up = true;

			} else if (foodX > this.x && foodY == this.y) {

			} else if (foodX > this.x && foodY > this.y) {
				right = false;
				down = true;

			} else if (foodX == this.x && foodY < this.y) {
				right = false;
				up = true;

			} else if (foodX == this.x && foodY > this.y) {
				right = false;
				down = true;

			}

		}

		// ---

		if (left == true && right == false) {
			// if(x / 20 - 2> 0&& x / 20 < 94 && y / 20 > 0 && y / 20 + 2 < 47) {
			// if(ObjectsManager.arr[x/20 - 2][y/20] == 1 || ObjectsManager.arr[x/20 -
			// 1][y/20] == 1) {
			// if(ObjectsManager.arr[x/20][y/20 + 2] != 1 || ObjectsManager.arr[x/20][y/20 +
			// 1] != 1) {
			// down = true;
			//
			// }else {
			// up = true;
			//
			// }
			//
			// }
			// }
			if (foodX < this.x && foodY < this.y) {
				left = false;
				up = true;

			} else if (foodX < this.x && foodY == this.y) {

			} else if (foodX < this.x && foodY > this.y) {
				left = false;
				down = true;

			} else if (foodX > this.x && foodY < this.y) {
				left = false;
				up = true;

			} else if (foodX > this.x && foodY == this.y) {
				left = false;
				up = true;

			} else if (foodX > this.x && foodY > this.y) {
				left = false;
				down = true;

			} else if (foodX == this.x && foodY < this.y) {
				left = false;
				up = true;

			} else if (foodX == this.x && foodY > this.y) {
				left = false;
				down = true;

			}

		}

		// ---

		if (up == true && down == false) {
			// if(x / 20 > 0 && x / 20 + 2 < 94 && y / 20 - 2 > 0 && y / 20 < 47) {
			// if(ObjectsManager.arr[x/20][y/20 - 2] == 1 || ObjectsManager.arr[x/20][y/20 -
			// 1] == 1) {
			// if(ObjectsManager.arr[x/20 + 2][y/20] != 1 || ObjectsManager.arr[x/20 +
			// 1][y/20] != 1) {
			// right = true;
			//
			// }else {
			// left = true;
			//
			// }
			//
			// }
			// }
			if (foodX < this.x && foodY > this.y) {
				up = false;
				left = true;

			} else if (foodX > this.x && foodY > this.y) {
				up = false;
				right = true;
			} else if (foodX == this.x && foodY > this.y) {
				up = false;
				left = true;
			} else if (foodX < this.x && foodY == this.y) {
				up = false;
				left = true;
				closestFood();
			} else if (foodX > this.x && foodY == this.y) {
				up = false;
				right = true;
				closestFood();
			}

		}

		// ---

		if (down == true && up == false) {

			if (foodX < this.x && foodY < this.y) {

				down = false;
				left = true;
			} else if (foodX > this.x && foodY < this.y) {
				down = false;
				right = true;
			} else if (foodX == this.x && foodY < this.y) {

				down = false;
				right = true;
			} else if (foodX < this.x && foodY == this.y) {
				down = false;
				left = true;
			} else if (foodX > this.x && foodY == this.y) {
				down = false;
				right = true;
			}
			// if(x / 20 > 0 && x / 20 + 2 < 94 && y / 20 > 0 && y / 20 + 2 < 47) {
			// if(ObjectsManager.arr[x/20][y/20 + 2] == 1 || ObjectsManager.arr[x/20][y/20 +
			// 1] == 1) {
			// if(ObjectsManager.arr[x/20 + 2][y/20] != 1 || ObjectsManager.arr[x/20 +
			// 1][y/20] != 1) {
			// right = true;
			//
			// }else {
			// left = true;
			//
			// }
			// }
			// }
		}

	}

	void draw(Graphics g) {

		for (int i = 0; i < tail.size(); i++) {
			tail.get(i).draw(g);

		}
		if (color == 1) {
			g.setColor(Color.RED);

		}
		if (color == 2) {
			g.setColor(Color.BLUE);

		}
		if (color == 3) {
			g.setColor(Color.WHITE);
		}

		g.fillRect(x, y, width, height);

	}

}
