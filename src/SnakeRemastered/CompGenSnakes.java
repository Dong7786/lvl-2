package SnakeRemastered;

import java.awt.Graphics;
import java.util.ArrayList;

public class CompGenSnakes extends GameObject {
	ArrayList<CompGenSnakes> snakes = new ArrayList<CompGenSnakes>();
int level;
	CompGenSnakes(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void update() {
super.update();

	}

	void draw(Graphics g) {
g.fillRect(x, y, width, height);
	}
}
