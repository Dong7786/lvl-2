package SnakeRemastered;

import java.awt.Graphics;

public class ObjectsManager {
PlayerSnake snake;
ObjectsManager(PlayerSnake s){
	snake = s;
}

void draw(Graphics g) {
	snake.draw(g);
}
void update() {
	snake.update();
}
}
