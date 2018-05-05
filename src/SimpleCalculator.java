import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleCalculator implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField f1 = new JTextField(10);
	JTextField f2 = new JTextField(10);
	NumberFormat formatter = new DecimalFormat("#0.0000");
	JLabel label = new JLabel();
	JButton b1 = new JButton("+");
	JButton b2 = new JButton("-");
	JButton b3 = new JButton("x");
	JButton b4 = new JButton("÷");
	String i;
	String d;
public static void main(String[] args) {
	SimpleCalculator g = new SimpleCalculator();
	g.stuff();
}
void stuff() {
	
	frame.add(panel);
	frame.setSize(350, 200);
	
	panel.add(f1);
	panel.add(f2);

	panel.add(b1);
	panel.add(b2);
	panel.add(b3);
	panel.add(b4);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
frame.setVisible(true);
panel.add(label);
label.setLocation(125, 100);
label.setFont(label.getFont().deriveFont(50.0f));

}
@Override
public void actionPerformed(ActionEvent e) {
	i = f1.getText();	
	d = f2.getText();
	int w = Integer.parseInt(i);
	int q = Integer.parseInt(d);
	
	// TODO Auto-generated method stub
	if(e.getSource() == (b1)) {
		

	Integer l = w + q;
	label.setText(l.toString());
	}else if(e.getSource() == (b2)) {
		
		Integer l = w - q;
		label.setText(l.toString());
	}else if(e.getSource()==(b3)) {
		Integer l = w * q;
		label.setText(l.toString());
	}else {
		Double dub = (double)w / (double)q; 
		label.setText(formatter.format(dub.doubleValue()));
		
	}
	
	
}
}
