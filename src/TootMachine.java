import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TootMachine implements ActionListener{
	JButton b1 = new JButton("Long Fart");
	JButton b2 = new JButton("Common Fart");
	JButton b3 = new JButton("Sharp Fart");
	public static void main(String[] args) {
		TootMachine g = new TootMachine();
		g.Goo();

	}

	public void Goo() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.pack();
		frame.setSize(400, 100);
		frame.add(panel);
		
		frame.setVisible(true);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		
b1.setVisible(true);
b2.setVisible(true);
b3.setVisible(true);
	b1.addActionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			System.out.println("test");
			playSound("/Users/league/Desktop/w.wav");
		
	}
	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}


}
