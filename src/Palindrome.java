
import javax.swing.JOptionPane;

public class Palindrome {
	
	public static void main(String[] args) {
		work();
	}
	
	public static void work() {
		// Write your code here

		String V = JOptionPane.showInputDialog("Insert Palindrone");
	reverse(V); 
	}

	public static String reverse(String s) {

		String reversedString = "";
		for (int i = s.length(); i > 0; i--) {
			reversedString += s.charAt(i - 1);
		}

		return reversedString;
	}

}
