import javax.swing.JOptionPane;

public class SimpleNumberSorter {
public static void main(String[] args) {
String Num1 = JOptionPane.showInputDialog("Number Plz");
String Num2 = JOptionPane.showInputDialog("Number Plz");
String Num3 = JOptionPane.showInputDialog("Number Plz");
int StringInt1 = Integer.parseInt(Num1);
int StringInt2 = Integer.parseInt(Num2);
int StringInt3 = Integer.parseInt(Num3);
for(int i = 0 ; i <= 3 ; i++){
	if(StringInt1 < StringInt2 && StringInt1 < StringInt3){
		System.out.println(StringInt1);	

		}
	else if(StringInt2 < StringInt1 && StringInt2 < StringInt3){
		System.out.println(StringInt2);	

		}
	else if(StringInt3 < StringInt2 && StringInt3 < StringInt1){
		System.out.println(StringInt3);	

		}
}

}
}
//Help me idk why this isn't working :/