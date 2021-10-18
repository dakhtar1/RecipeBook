import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Random;

public class ClickedEvent implements ActionListener {
	Menu inaction;

    public ClickedEvent(Menu inAction){ inaction = inAction; }
	@Override
	public void actionPerformed(ActionEvent e){

    	// Gets the text written on the button to know which button was pressed
		JButton clicked = (JButton) e.getSource();
		String btntext = clicked.getText();

		/*
			Returns the specified task based on text on button pressed
		 */
		if (btntext.contains("Explore")){
			inaction.show();
		}
		else if (btntext.contains("Retrieve")) {
			inaction.show();
			String recipe = JOptionPane.showInputDialog(null, "Please enter the name of the recipe to retrieve:");
			try {
				inaction.retrieveRecipe(recipe);
			} catch (Exception exception) {
				System.out.println("RECIPE " + "\"" + recipe + "\"" + " does not exist!");
			}
		}
		else if (btntext.contains("Inter")) {
			inaction.show();
			String recipe = JOptionPane.showInputDialog(null, "Please enter the name of the recipe to retrieve:");
			try {
				inaction.show_interactive(recipe);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		else if (btntext.contains("Create")){
			inaction.show();
			String recipeName = JOptionPane.showInputDialog(null, "Please enter the name of the recipe to create:");
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
			String recipe = JOptionPane.showInputDialog(null, "Please enter the name of the recipe to delete:");
			try {
				inaction.deleteRecipe(recipe);
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
		else{
			return;
		}
	}
}
