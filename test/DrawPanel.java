import javax.swing.*;
import java.awt.*;


public class DrawPanel extends JPanel {
  static Graphics g;
  public static Color c;

  public void paintComponent(Graphics ing){
	  
	  super.paintComponent(ing);
	  g = ing;
	  g.setColor(c);
	  g.setFont(new Font("Courier New", Font.BOLD, 24));
	  
	  g.fillRect(0, 0, 200, 700);
	  for (int i = 200 ; i<= 700; i = i + 50) {
		  g.setColor(Color.red);
		  g.drawString(Integer.toString((i-200)/5), i-10, 30);
		  g.setColor(Color.blue);
		  // sets the color of the background
		  g.fillRect(i, 0, 3, 700);
	  }
	   
	  
  }
   
	  
      
  }
 
