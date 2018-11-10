
package SnakeRemastered;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

		if (CSnake.x > 1880 && CSnake.x < 2000) {
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

		g.fillRect(0, 0, 1900, 940);

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
		if(manager.Mode == 0) {
			manager.snakes.get(0).isAI = true;
			manager.snakes.get(1).isAI = true;
if(e.getKeyCode() == KeyEvent.VK_1) {
	manager.snakes.get(0).isAI = false;
	manager.snakes.get(1).isAI = false;
	manager.Mode = 1;
	manager.snakes.get(0).x = 940;
	manager.snakes.get(0).y = 480;
	manager.snakes.get(0).size = 0;
	manager.snakes.get(0).up = false;
	manager.snakes.get(0).down = false;
	manager.snakes.get(0).right = false;
	manager.snakes.get(0).left = false;
}
if(e.getKeyCode() == KeyEvent.VK_2) {
	manager.snakes.get(0).isAI = false;
	manager.snakes.get(1).isAI = true;
	manager.Mode = 2;
	manager.snakes.get(1).x = 460;
	manager.snakes.get(1).y = 240;
	manager.snakes.get(1).size = 0;
	manager.snakes.get(1).up = false;
	manager.snakes.get(1).down = false;
	manager.snakes.get(1).right = false;
	manager.snakes.get(1).left = false;

	manager.snakes.get(0).x = 940;
	manager.snakes.get(0).y = 480;
	manager.snakes.get(0).size = 0;
	manager.snakes.get(0).up = false;
	manager.snakes.get(0).down = false;
	manager.snakes.get(0).right = false;
	manager.snakes.get(0).left = false;
}
if(e.getKeyCode() == KeyEvent.VK_3) {
	manager.snakes.get(0).isAI = false;
	manager.snakes.get(1).isAI = false;
	manager.Mode = 3;
	manager.snakes.get(1).x = 460;
	manager.snakes.get(1).y = 240;
	manager.snakes.get(1).size = 0;
	manager.snakes.get(1).up = false;
	manager.snakes.get(1).down = false;
	manager.snakes.get(1).right = false;
	manager.snakes.get(1).left = false;

	manager.snakes.get(0).x = 940;
	manager.snakes.get(0).y = 480;
	manager.snakes.get(0).size = 0;
	manager.snakes.get(0).up = false;
	manager.snakes.get(0).down = false;
	manager.snakes.get(0).right = false;
	manager.snakes.get(0).left = false;
}
if(e.getKeyCode() == KeyEvent.VK_0) {
	manager.Mode = 4;
	manager.snakes.get(0).isAI = true;
	manager.snakes.get(1).isAI = true;
	
	
}
	}
if(manager.Mode != 0) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {


			if ((snake1.left == false || snake1.size == 0) && keyPressed == false) {
				keyPressed = true;
				snake1.right = true;
				snake1.left = false;
				snake1.up = false;
				snake1.down = false;

			}

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		
			if ((snake1.right == false || snake1.size == 0) && keyPressed == false) {
				keyPressed = true;
				snake1.left = true;
				snake1.right = false;
				snake1.up = false;
				snake1.down = false;

			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			if ((snake1.up == false || snake1.size == 0) && keyPressed == false) {
				keyPressed = true;
				snake1.down = true;
				snake1.right = false;
				snake1.left = false;
				snake1.up = false;

			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			
			if ((snake1.down == false || snake1.size == 0) && keyPressed == false) {
				keyPressed = true;
				snake1.up = true;
				snake1.right = false;
				snake1.left = false;

				snake1.down = false;
			}
		}
}
if(manager.Mode == 3) {

		
		if (e.getKeyCode() == KeyEvent.VK_D) {
	

			if ((CSnake.left == false || CSnake.size == 0) && pressedKey == false) {
				pressedKey = true;
				CSnake.right = true;
				CSnake.left = false;
				CSnake.up = false;
				CSnake.down = false;

			}

		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			
			if ((CSnake.right == false || CSnake.size == 0) && pressedKey == false) {
				pressedKey = true;
				CSnake.left = true;
				CSnake.right = false;
				CSnake.up = false;
				CSnake.down = false;

			}
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			
			if ((CSnake.up == false || CSnake.size == 0) && pressedKey == false) {
				pressedKey = true;
				CSnake.down = true;
				CSnake.right = false;
				CSnake.left = false;
				CSnake.up = false;

			}
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			
			if ((CSnake.down == false || CSnake.size == 0) && pressedKey == false) {
				pressedKey = true;
				CSnake.up = true;
				CSnake.right = false;
				CSnake.left = false;

				CSnake.down = false;
			}
		}
	}
		if(manager.Mode == 4){
			if(e.getKeyCode() == KeyEvent.VK_M){
			manager.manual = false;	
				manager.mC = false;
				manager.mO = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_D) {
	manager.manual = true;
				manager.mC = true;

			if ((CSnake.left == false || CSnake.size == 0) && pressedKey == false) {
				pressedKey = true;
				CSnake.right = true;
				CSnake.left = false;
				CSnake.up = false;
				CSnake.down = false;

			}

		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			manager.manual = true;
				manager.mC = true;
			if ((CSnake.right == false || CSnake.size == 0) && pressedKey == false) {
				pressedKey = true;
				CSnake.left = true;
				CSnake.right = false;
				CSnake.up = false;
				CSnake.down = false;

			}
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			manager.manual = true;
				manager.mC = true;
			if ((CSnake.up == false || CSnake.size == 0) && pressedKey == false) {
				pressedKey = true;
				CSnake.down = true;
				CSnake.right = false;
				CSnake.left = false;
				CSnake.up = false;

			}
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			manager.manual = true;
				manager.mC = true;
			if ((CSnake.down == false || CSnake.size == 0) && pressedKey == false) {
				pressedKey = true;
				CSnake.up = true;
				CSnake.right = false;
				CSnake.left = false;

				CSnake.down = false;
			}
		}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
manager.manual = true;
manager.mO = true;
			if ((snake1.left == false || snake1.size == 0) && keyPressed == false) {
				keyPressed = true;
				snake1.right = true;
				snake1.left = false;
				snake1.up = false;
				snake1.down = false;

			}

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		manager.manual = true;
				manager.mO = true;

			if ((snake1.right == false || snake1.size == 0) && keyPressed == false) {
				keyPressed = true;
				snake1.left = true;
				snake1.right = false;
				snake1.up = false;
				snake1.down = false;

			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			manager.manual = true;
				manager.mO = true;

			if ((snake1.up == false || snake1.size == 0) && keyPressed == false) {
				keyPressed = true;
				snake1.down = true;
				snake1.right = false;
				snake1.left = false;
				snake1.up = false;

			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			manager.manual = true;
				manager.mO = true;
			if ((snake1.down == false || snake1.size == 0) && keyPressed == false) {
				keyPressed = true;
				snake1.up = true;
				snake1.right = false;
				snake1.left = false;

				snake1.down = false;
			}
		}
		}
if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	manager.Mode = 0;
	
	
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
