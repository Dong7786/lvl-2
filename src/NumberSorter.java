import javax.swing.JOptionPane;

public class NumberSorter {
public static void main(String[] args) {
	String g = JOptionPane.showInputDialog("Whats your Grade?");
	double con = Double.parseDouble(g);
if(con <= 58.9999999999999999999999999999999999999999999999999 && con >= 1){
	JOptionPane.showMessageDialog(null, "F");	
}
else if(con <= 68.9999999999999999999999999999999999999999999999999 && con >= 61){
	JOptionPane.showMessageDialog(null , "D");
}
else if(con <= 78.9999999999999999999999999999999999999999999999999 && con >= 71){
	JOptionPane.showMessageDialog(null , "C");
}
else if(con <= 88.9999999999999999999999999999999999999999999999999 && con >= 81){
	JOptionPane.showMessageDialog(null , "B");
}
else if(con <= 99.9999999999999999999999999999999999999999999999999 && con >= 91){
	JOptionPane.showMessageDialog(null , "A");
}
else if(con <= 1000000000 && con >= 100){
	JOptionPane.showMessageDialog(null , "A+");
}
else if(con <= 0){
	JOptionPane.showMessageDialog(null , "M");
}
else if(con <= 90.9999999999999999999999999999999999999999999999999 && con >= 90){
	JOptionPane.showMessageDialog(null, "A-");
}
else if(con <= 89.9999999999999999999999999999999999999999999999999 && con >= 89){
	JOptionPane.showMessageDialog(null, "B+");
}
else if(con < 80 && con >= 79){
	JOptionPane.showMessageDialog(null, "C+");
}
else if(con <= 69.9999999999999999999999999999999999999999999999999 && con >= 69){
	JOptionPane.showMessageDialog(null, "D+");
}
else if(con <= 59.9999999999999999999999999999999999999999999999999 && con >= 59){
	JOptionPane.showMessageDialog(null, "F+");
}
else if(con <= 80.9999999999999999999999999999999999999999999999999 && con >= 80){
	JOptionPane.showMessageDialog(null, "B-");
}
else if(con < 80 && con >= 70){
	JOptionPane.showMessageDialog(null, "C-");
}

else if(con <= 60.9999999999999999999999999999999999999999999999999 && con >= 60){
	JOptionPane.showMessageDialog(null, "D-");
}else {
	JOptionPane.showMessageDialog(null, "Boi, type a number -_-'");
}
	
	
JOptionPane.showMessageDialog(null, "BTW rawlbawks(Roblox) sucks");	
}
}
