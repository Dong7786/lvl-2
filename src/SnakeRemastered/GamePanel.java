
package SnakeRemastered;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer timer;
	Snake snake1 = new Snake(940, 480, 19, 19);
Snake CSnake = new Snake(460, 240, 19, 19);
	ObjectsManager manager = new ObjectsManager(snake1, CSnake);

	boolean isMoving;
	static boolean keyPressed = false;
	static boolean pressedKey = false;

	void updateGameState() {
		manager.update();

		if (snake1.up == true || snake1.down == true || snake1.right == true || snake1.left == true) {
			isMoving = true;

		} else {
			isMoving = false;

		}

	}

	void drawGameState(Graphics g) {

		manager.draw(g);
		if (snake1.x > 1880) {
			snake1.x = 0;
		} else if (snake1.x < 0) {
			snake1.x = 1880;

		}
		if (snake1.y > 920) {
			snake1.y = 0;

		} else if (snake1.y < 0) {
			snake1.y = 920;

		}
	
	if (CSnake.x > 1880) {
		CSnake.x = 0;
	} else if (CSnake.x < 0) {
		CSnake.x = 1880;

	}
	if (CSnake.y > 920) {
		CSnake.y = 0;

	} else if (CSnake.y < 0) {
		CSnake.y = 920;

	}
}

	GamePanel() {

		timer = new Timer(1000 / 12, this);

	}

	void startGame() {
		timer.start();
	}

	@Override

	public void paintComponent(Graphics g) {

		g.fillRect(0, 0, 1920, 972);

		g.setColor(Color.white);
		drawGameState(g);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		updateGameState();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// object.x = object.x + 20;
			// snake1.x = snake1.x + snake1.speed;

			if ((snake1.left == false || snake1.size == 0) && keyPressed == false) {
				keyPressed = true;
				snake1.right = true;
				snake1.left = false;
				snake1.up = false;
				snake1.down = false;

			}
			
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// object.x = object.x - 20;
			// snake1.x = snake1.x - snake1.speed;
			if ((snake1.right == false || snake1.size == 0) && keyPressed == false) {
				keyPressed = true;
				snake1.left = true;
				snake1.right = false;
				snake1.up = false;
				snake1.down = false;

			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// object.y = object.y + 20;
			if ((snake1.up == false || snake1.size == 0) && keyPressed == false) {
				keyPressed = true;
				snake1.down = true;
				snake1.right = false;
				snake1.left = false;
				snake1.up = false;

			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			// object.y = object.y - 20;
			if ((snake1.down == false || snake1.size == 0) && keyPressed == false) {
				keyPressed = true;
				snake1.up = true;
				snake1.right = false;
				snake1.left = false;

				snake1.down = false;
			}
		}
		
		
		
		
		// -- CSnake
		if (e.getKeyCode() == KeyEvent.VK_D) {
			// object.x = object.x + 20;
			// snake1.x = snake1.x + snake1.speed;

			if ((CSnake.left == false || CSnake.size == 0) && pressedKey == false) {
				pressedKey = true;
				CSnake.right = true;
				CSnake.left = false;
				CSnake.up = false;
				CSnake.down = false;

			}
			
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			// object.x = object.x - 20;
			// snake1.x = snake1.x - snake1.speed;
			if ((CSnake.right == false || CSnake.size == 0) && pressedKey == false) {
				pressedKey = true;
				CSnake.left = true;
				CSnake.right = false;
				CSnake.up = false;
				CSnake.down = false;

			}
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			// object.y = object.y + 20;
			if ((CSnake.up == false || CSnake.size == 0) && pressedKey == false) {
				pressedKey = true;
				CSnake.down = true;
				CSnake.right = false;
				CSnake.left = false;
				CSnake.up = false;

			}
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			// object.y = object.y - 20;
			if ((CSnake.down == false || CSnake.size == 0) && pressedKey == false) {
				pressedKey = true;
				CSnake.up = true;
				CSnake.right = false;
				CSnake.left = false;

				CSnake.down = false;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
