import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;

public class StephenHawking implements KeyListener {
public static void main(String[] args) {
	int i = 0;
	
	String ask = JOptionPane.showInputDialog("Input a sentence please!");
	
	String times = JOptionPane.showInputDialog("How many times do you want it to play? 1 - 5");
if(times.equals("1")) {
	
}else if(times.equals("2")) {
	
}else if(times.equals("3")) {
	
}else if(times.equals("4")) {
	
}else if(times.equals("5")) {
	
}else {
	JOptionPane.showMessageDialog(null, "That doesnt work");
}
int x = Integer.parseInt(times);
for(i = 0; i < x; i++) {
	if(x >= 5)
	speak(ask);
}

}

    // 1. make a main method and put steps 2, 3 & 4 inside it
    // 2. ask the user for a sentence
    // 3. call the speak method below and send it the sentence
    // 4. repeat steps 2 and 3 a lot of times

/* Don’t change this…. */
static void speak(String words) {
   	 try {
   		 Runtime.getRuntime().exec("say " + words).waitFor();
   	 } catch (Exception e) {
   		 e.printStackTrace();
   	 }
    }


@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	char i = e.getKeyChar();
	speak(Character.toString(i));
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

}
