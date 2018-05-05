import javax.swing.JOptionPane;

public class Riddlemethisandthereisarecipieforthis {

	public static void main(String[] args) {

		// 1. Make a variable to hold the score
		int i = 0;
		// 3. Ask the user a riddle. Here are some ideas: bit.ly/some-riddles
	String riddle = JOptionPane.showInputDialog("It can be cracked, It can be made, It can be told, it can be played. What is it?");
		// 4. If they got the answer right, pop up "correct!" and increase the
		// score by one
if(riddle.equals("Jokes")){
	JOptionPane.showMessageDialog(null, "Good");
	i = i+1;
}
		// 5. Otherwise, say "wrong" and tell them the answer
else{
	JOptionPane.showMessageDialog(null, "Ooh it Jokes");
	i = i-1;
}
		// 6. Add some more riddles
String n = JOptionPane.showInputDialog("What jumps higher than a building?");
if(n.equals("All animals can jump higher than a building. Buildings do not jump")){
	JOptionPane.showMessageDialog(null, "Good");
	i = i+1;
}
else{
	JOptionPane.showMessageDialog(null, "All animals can jump higher than a building. Buildings do not jump BTW");
	i = i-1;
}
		// 2. Make a pop up to show the score.
		JOptionPane.showMessageDialog(null, "score = " + i);
	}
}
