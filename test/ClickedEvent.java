import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ClickedEvent implements ActionListener {
	JButton savebtn;
	Menu inaction;
	JTextField textBox;

    public ClickedEvent(JButton inbtn) {
    	savebtn = inbtn;
    }
    public ClickedEvent(JButton inbtn, Menu inAction){
    	inaction = inAction;
    	savebtn = inbtn;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		
		JButton clicked = (JButton) e.getSource();
		
	// (this is an easier way to do it)	if (clicked == savebtn) {}		
		String btntext = clicked.getText();
		if (btntext.contains("Explore")){
			inaction.show();
		}
		else if (btntext.contains("Retrieve")) {
			inaction.show();
		}
		else if (btntext.contains("Inter")) {
			inaction.show();
			JTextField textBox = new JTextField("Please enter the name of the recipe to retrieve:");
			String recipe = textBox.getText();
			try {
				inaction.show_interactive(recipe);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		else if (btntext.contains("Create")){
			inaction.show();
			JTextField textBox = new JTextField("Please enter the name of the recipe to create:");
			String recipeName = textBox.getText();
			try {
				java.util.List<java.util.List<String>> ingredientsList = RecipeInputRetrieval.retrieveRecipeIngredientsInput();
				List<String> directionsList = RecipeInputRetrieval.retrieveDirectionsList();
				inaction.createRecipe(new Recipe(recipeName, ingredientsList, directionsList));
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		else if (btntext.contains("Delete")) {
			inaction.show();
			JTextField textBox = new JTextField("Please enter the name of the recipe to delete");
			String recipe = textBox.getText();
			try {
				inaction.deleteRecipe(recipe);
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
		else{
			System.out.println("I am here now!");
		}
	}
}
