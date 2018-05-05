import javax.swing.JOptionPane;

public class Happy_UnBirthday_and_Birthday {
	public static void main(String[] args) {
	String i =	JOptionPane.showInputDialog("Is it ur birthday???");
	if(i.equals("Yess"))
		JOptionPane.showMessageDialog(null,"Happy Birthday");
	else{
		JOptionPane.showMessageDialog(null,"Happy unBirthday");
	}
	}
}
