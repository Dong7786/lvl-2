import javax.swing.JOptionPane;

public class WorldDomination {
	public static void main(String[] args) {
		// 1. Ask the user if they know how to write code.
		String WTYGTB = JOptionPane.showInputDialog("Do u know how to code??");
		
		// 2. If they say "yes", tell them they will rule the world.
        if (WTYGTB.equals("yes")) {
			JOptionPane.showMessageDialog(null,"See i rule the world!!");
		}
		// 3. Otherwise, wish them good luck washing dishes.
        else{
        	JOptionPane.showMessageDialog(null,"GL washing dishes :D");
        }
	}
}

