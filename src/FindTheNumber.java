
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FindTheNumber {
public static void main(String[] args) {
	ImageIcon icon = new ImageIcon("5174259612_07953b7b8d_b.jpg");
	String i = (String) JOptionPane.showInputDialog(null,"How many sqaures are in the pictues?",null,0,icon,null,null);
	int x = Integer.parseInt(i);
	if(x == 5208){
		JOptionPane.showMessageDialog(null, "Yay, you got it correct!!");
	}
	else{
		JOptionPane.showMessageDialog(null, "Srry, u suck at counting. Do u need me to teach you?? Ok 123...");
	}
	String hai = JOptionPane.showInputDialog("Whats 100,000 digits of Pi??");
	int hi = Integer.parseInt(hai);
	if(hi == 3141592){
		JOptionPane.showMessageDialog(null, "You got it :D");
	}
	else{
		JOptionPane.showMessageDialog(null, "KNOW YOUR PIIIII!!!!!!! 3.141592....");
	}
String guess = JOptionPane.showInputDialog("Guess the random number");
int g = Integer.parseInt(guess);
if(g == 2147483647){
	JOptionPane.showMessageDialog(null, "Wait..how? That was supposed to be impossible");
}
else{
	JOptionPane.showMessageDialog(null,"Dude u suck at guessing");
}
	
}
}






















































































































































































