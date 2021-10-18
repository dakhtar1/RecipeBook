import javax.swing.*;
import java.awt.*;
import java.util.List;


public class DrawPanel extends JPanel {
  static Graphics g;
  public static Color c;

  public void paintComponent(Graphics ing){
	  
	  super.paintComponent(ing);
	  g = ing;
	  g.setColor(c);
	  g.setFont(new Font("Times New Roman", Font.BOLD, 24));

	  g.fillRect(0, 0, 200, 1000);
  }


    public void add(List<String> recipeListOutput) {
    }
}
 
