package SnakeRemastered;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Tail extends GameObject{

	Tail(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
 void update() {
super.update();	
}
void draw(Graphics g) {
	g.setColor(Color.WHITE);
	g.fillRect(x, y, width, height);

}
}
