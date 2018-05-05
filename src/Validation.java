
import java.util.Random;

import javax.swing.JOptionPane;

public class Validation {
	public static void main(String[] args) {
		int i = 0;
		// 1. Watch the first 2 minutes of this movie: http://vimeo.com/2485018
		while  (i == 0){
			i = 1;
		
		int randomNumber = new Random().nextInt(5);
		// 2. On paper, write all the numbers that get printed when you run this class

		String[] options1 = { "Meh.", "Thanks!" };
		
		// 3. Use the randomNumber to give the user a random compliment.
		if (randomNumber == 0) {
			i = JOptionPane.showOptionDialog(null, "You are great!", "Emergency Compliments", JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options1, null);
		

		} else if (randomNumber == 1) {
		
				i = JOptionPane.showOptionDialog(null, "Sushi chefs are wowed by your chopstick dexterity.", "Emergency Compliments",JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options1, null);
		} else if (randomNumber == 2) {
			i = JOptionPane.showOptionDialog(null, "Everyone at sleepovers thought you were the bravest during thunderstorms.","Emergency Compliments", JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options1, null);
		} else if (randomNumber == 3) {
			i = JOptionPane.showOptionDialog(null,"At least two friends are going to name their child and/or goldfish after you.","Emergency Compliments", JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options1, null);
		} else if (randomNumber == 4) {
			i = JOptionPane.showOptionDialog(null,"You are your parent's greatest accomplishment, unless they invented the spork.","Emergency Compliments", JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options1, null);
		}

		else if (randomNumber == 5) {
			i = JOptionPane.showOptionDialog(null,"You want the best for everyone...except Gary.", "Emergency Compliments", JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options1, null);
		}

		// 4. Repeat all the code above 10 times

		// 5. Find someone to test out your program. They will like it :)
	
}
	}
}