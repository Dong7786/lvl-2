import javax.swing.JOptionPane;

public class PrimeNumber {
public static void main(String[] args) {
	
	int d = 0;
	String chooseNumber = JOptionPane.showInputDialog("Insert a number below.").trim();
	int number = Integer.parseInt(chooseNumber);
	for (int i = 2;;i ++) {
		if (i == number) {
			break;
		}
		if(number % i == 0){
			d++;
		}
	}
	if (d >= 1) {
		JOptionPane.showMessageDialog(null, number + " is not Prime!");
	} else {
		JOptionPane.showMessageDialog(null, number + " is Prime!");
	}
}
} 								
