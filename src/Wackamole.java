import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Wackamole implements ActionListener{
	static int l;
	static JButton buttons[] = new JButton[84];
static int whacks;
static int whack;
static int miss;
public static void main(String[] args) {
	
Wackamole w = new Wackamole();
w.drawButtons();
	
}//main
void drawButtons() {
	 JFrame frame = new JFrame();
	 JPanel panel = new JPanel();
	Random random = new Random();
	
	frame.setVisible(true);
	
	frame.add(panel);
	panel.setVisible(true);
	for(int i = 0; i < buttons.length; i ++) {
		
		buttons[i] = new JButton();
		panel.add(buttons[i]);
		buttons[i].setVisible(true);
		buttons[i].addActionListener(this);
}
	frame.setSize(500, 500);
int number = random.nextInt(buttons.length);
l = number;
buttons[number].setText("Mole!");

}//drawButtons
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Random r = new Random();
	if(e.getSource() == buttons[l]) {
	whack++;
		speak("Whack!");
	}else {
	miss++;
	whacks--;
		speak("Dork!");
	}
	if(e.getSource() == buttons[l]) {
		drawButtons();
		//int num = r.nextInt(buttons.length);
		//l = num;
		//buttons[num].setText("Mole!");
		//System.out.println("P");
		whacks++;
	}
	
	if(whacks == 10) {
		System.out.println("You whacked the mole "+ whack +" times!");
		System.out.println("You missed the mole "+ miss + " times!");

		System.exit(0);
				
	}
}
void speak(String words) {
try {
Runtime.getRuntime().exec("say " + words).waitFor();
} catch (Exception e) {
e.printStackTrace();
}
}


}//class