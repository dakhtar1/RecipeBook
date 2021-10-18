import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class MainGUI {
    public static void main(String[] args) throws Exception {
        RecipeAO recipeAOCSV = new RecipeAOCSV("src/data/recipes.csv");
        recipeAOCSV.initializeRecipesList();

        Menu exploreRecipesMenu = new ExploreRecipesMenu(recipeAOCSV);
        Menu retrieveRecipeMenu = new RetrieveRecipeMenu(recipeAOCSV);
        Menu retrieveRecipeInteractiveMenu = new RetrieveRecipeInteractiveMenu(recipeAOCSV);
        Menu createRecipeMenu = new CreateRecipeMenu(recipeAOCSV);
        Menu deleteRecipeMenu = new DeleteRecipeMenu(recipeAOCSV);

        //DrawPanel p = new DrawPanel();
        JFrame f = new JFrame("Recipe Book");

        CardLayout cl = new CardLayout();

        JTabbedPane tabbedPane = new JTabbedPane();
        f.add(tabbedPane);

        JLabel explore = new JLabel();
        JLabel retrieve = new JLabel();
        JLabel create = new JLabel();
        JLabel delete = new JLabel();

        tabbedPane.add("Explore", explore);
        tabbedPane.add("Retrieve", retrieve);
        tabbedPane.add("Create", create);
        tabbedPane.add("Delete", delete);



        exploreRecipesMenu.show();
        JLabel title = new JLabel("Recipe Name");
        title.setBounds(25,25,80,25);
        explore.add(title);
        List<String> recipeList = ExploreRecipesMenu.recipeListOutput;
        int yPos = 25;
        for (int i = 0; i < recipeList.size(); i++){
            JLabel name = new JLabel(recipeList.get(i));
            yPos += 15;
            name.setBounds(50,yPos,80,25);
            explore.add(name);
        }



        f.pack();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 800);
        f.setVisible(true);
        JTextArea textWelcome = new JTextArea("Welcome to the Recipe Book", 200, 200);


        /*
            ClickedEvent implements ActionListener and takes in Menu
            to return the specified action when the button is pressed
         */


/*
        ClickedEvent exploreClicked = new ClickedEvent(exploreRecipesMenu);
        ClickedEvent retrieveClicked = new ClickedEvent(retrieveRecipeMenu);
        ClickedEvent interactiveClicked = new ClickedEvent(retrieveRecipeInteractiveMenu);
        ClickedEvent createClicked = new ClickedEvent(createRecipeMenu);
        ClickedEvent deleteClicked = new ClickedEvent(deleteRecipeMenu);
*/

        /*
        //Adds buttons to the panel

        p.add(btnDelete);
        p.add(btnExplore);
        p.add(btnRetrieve);
        p.add(btnInteractive);
        p.add(btnCreate);

        // Attempting to create the TextArea here.
        p.add(new JScrollPane(textWelcome));*/
        /*
            'Listens' for any clicks on the buttons
         */
        /*
        btnExplore.addActionListener(exploreClicked);
        btnRetrieve.addActionListener(retrieveClicked);
        btnInteractive.addActionListener(interactiveClicked);
        btnCreate.addActionListener(createClicked);
        btnDelete.addActionListener(deleteClicked);
        f.repaint();*/
    }
}
