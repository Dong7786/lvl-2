import javax.swing.JOptionPane;

import org.teachingextensions.logo.Tortoise;

public class DizzyTortoise {

	public static void main(String[] args) {

		// 2. Ask the user how dizzy you want the tortoise from 1-10, then spin
		// that number of times.
String i = JOptionPane.showInputDialog("How dizzy do u want the turtle to be??");
int n = Integer.parseInt(i);
		// 1. Use the dance method to make the Tortoise spin.
dance(n);
		
	}

	static void dance(int numberOfSpins) {
		for (int i = 0; i < numberOfSpins; i++) {
			Tortoise.turn(360);
		}
	}
}
