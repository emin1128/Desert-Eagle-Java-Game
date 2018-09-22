import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Welcome extends JPanel  {

	  protected Image backgroundImage;
	  private ImageIcon myBackgroundIcon; 
	  // Some code to initialize the background image.
	  // Here, we use the constructor to load the image. This
	  // can vary depending on the use case of the panel.
	  public Welcome(String fileName) throws IOException {
		myBackgroundIcon=new ImageIcon(getClass().getResource(fileName));
		
	    backgroundImage =myBackgroundIcon.getImage(); 
	  }

	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    // Draw the background image.
		
	    g.drawImage(backgroundImage, 0, 0, null);
	    
	  
	   
	   
	  }
}
