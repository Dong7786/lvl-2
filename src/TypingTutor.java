import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor {
public static void main(String[] args) {
	TypingTutor t = new TypingTutor();
	t.Stuff();
}
static char generateRandomLetter() {
	Random r = new Random();
	return (char) (r.nextInt(26) + 'a');
}
void Stuff() {
	char currentLetter;
	currentLetter = generateRandomLetter();
	JLabel letter = new JLabel();
	JFrame type = new JFrame();
	JPanel screen = new JPanel();
	type.setTitle("Type or Die");
	type.setSize(500, 200);
	type.setVisible(true);
	type.add(screen);
	letter.setVisible(true);
	letter.setText(Character.toString(currentLetter));
	screen.add(letter);
	
}
}
