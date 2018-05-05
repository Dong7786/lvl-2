import java.awt.Color;

import org.teachingextensions.logo.Tortoise;

public class Houses {
	static int x = 1;
	static int y = 440;

	public static void main(String[] args) {
	final Color red     = new Color(199,0,0);
	final Color blue      = new Color(0, 0, 199);
	final Color brown      = new Color(153, 77, 0);
	final Color magenta      = new Color(204, 0, 204);
	final Color orange        = new Color(244,170,66);
	final Color black          = new Color(0,0,0);
	final Color grey            = new Color(121,121,121);
	Tortoise.setPenWidth(5);
	System.out.println(y);
	Tortoise.setPenColor(red);
	Tortoise.setX(x);
	Tortoise.setY(y);
	Tortoise.penDown();
	Tortoise.move(100);
		drawPointyRoof();
	Tortoise.move(100);
	drawGrass();
	Tortoise.setPenColor(blue);
	Tortoise.move(200);
	drawFlatRoof();
	Tortoise.move(200);
	drawGrass();
	Tortoise.setPenColor(magenta);
	Tortoise.move(50);
	drawPointyRoof();
	Tortoise.move(50);
	drawGrass();
	Tortoise.setPenColor(brown);
	Tortoise.move(80);
	drawFlatRoof();
	Tortoise.move(80);
	drawGrass();
	Tortoise.setPenColor(orange);
	Tortoise.move(20);
	drawPointyRoof();
	Tortoise.move(20);
	drawGrass();
	Tortoise.setPenColor(grey);
	Tortoise.move(120);
	drawFlatRoof();
	Tortoise.move(120);
	drawGrass();
	Tortoise.setPenColor(black);
	Tortoise.move(400);
	drawPointyRoof();
	Tortoise.move(400);
	drawGrass();
	Tortoise.setPenColor(orange);
	Tortoise.move(350);
	drawFlatRoof();
	Tortoise.move(350);
	drawGrass();
	Tortoise.setPenColor(red);
	Tortoise.move(30);
	drawPointyRoof();
	Tortoise.move(30);
	}
static void drawPointyRoof(){
	Tortoise.setPenWidth(5);
	Tortoise.turn(45);
	Tortoise.move(20);
	Tortoise.turn(90);
	Tortoise.move(20);
	Tortoise.turn(45);
	
}
static void drawFlatRoof(){
	Tortoise.setPenWidth(5);
	Tortoise.turn(90);
	Tortoise.move(40);
	Tortoise.turn(90);
}
static void drawGrass(){
	final Color green    = new Color(0, 102, 0);
	Tortoise.setPenColor(green);
	Tortoise.setPenWidth(5);
	Tortoise.turn(270);
	Tortoise.move(40);
	Tortoise.turn(270);
}
}
