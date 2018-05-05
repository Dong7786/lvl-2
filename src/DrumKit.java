import java.applet.AudioClip;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrumKit extends MouseAdapter {

    JLabel drumLabelWithImage;

    public static void main(String[] args) throws Exception {
   	 new DrumKit().getGoing();
    }

    private void getGoing() throws MalformedURLException {
    
   	 // 1. Make a JFrame variable and initialize it using "new JFrame()"
   	 JFrame f = new JFrame();
   
	// 2. Make the frame visible
   	 f.setVisible(true);
   	 // 3. Set the size of the frame
   	 f.setSize(0, 1000);
   	 // 4. Set the title of the frame
   	 f.setTitle("DrumKit");
   	 // 5. Make a JPanel and initialize it.
   	 JPanel p = new JPanel();
   	 // 6. Add the panel to the frame. (The panel is invisible.)
   f.add(p);
   	 // 7. Download an image of a drum from the Internet. Drop it into your Eclipse project under "default package".
   	 // 8. Put the name of your image in a String variable.
    String drum = "download.jpg";
   	 // 9. Edit the next line to use your String variable
// drumLabelWithImage = createLabelImage(drumImageString);
    drumLabelWithImage = createLabelImage(drum);
   	 // 10. Add the image to the panel
    p.add(drumLabelWithImage);
   	 // 11. Set the layout of the panel to "new GridLayout()"
    p.setLayout (new GridLayout());
   	 // 12. call the pack() method on the frame
   	 f.pack();
   	 
// 13. add a mouse listener to drumLabelWithImage.
drumLabelWithImage.addMouseListener(this);
    }

    

	public void mouseClicked(MouseEvent e) {
   	 // 14. When the mouse is clicked, print "mouse clicked"
		 String a = "a";
		System.out.println("Mouse Clicked");
   if(e.getSource()== drumLabelWithImage) {
	   playSound(a);
   }
   	
   	 // 15. Download a drum sound and drop it into your "default package". You can find it on freesound.org. To download it, log in as leagueofamazing/code4life.
   	 // 16. If they clicked on the drumImage...

   		 // 17. ...use the playSound method to play a drum sound.

   	 // 18. Add more images to make a drumkit. Remember to add a mouse listener to each one.
    }

    private boolean mouseClicked(JLabel drumLabelWithImage2) {
		// TODO Auto-generated method stub
		return false;
	}

	private JLabel createLabelImage(String fileName)
			throws MalformedURLException
	{
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null)
		{
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}


    private void playSound(String fileName) {
   	 AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
   	 sound.play();
    }

}



