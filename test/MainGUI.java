import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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

        DrawPanel p = new DrawPanel();
        JFrame f = new JFrame("Recipe Book");
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 800);
        f.setVisible(true);
        JTextArea textWelcome = new JTextArea("Welcome to the Recipe Book", 200, 200);

        exploreRecipesMenu.show();
        JLabel title = new JLabel("Recipe Name");
        title.setBounds(400,100,80,25);
        p.add(title);
        List<String> recipeList = ExploreRecipesMenu.recipeListOutput;
        int yPos = 100;
        for (int i = 0; i < recipeList.size(); i++){
            JLabel name = new JLabel(recipeList.get(i));
            yPos += 50;
            name.setBounds(400,yPos,80,25);
            p.add(name);
        }


        //Sizing and placing buttons on the panel
        JButton btnExplore = new JButton("Explore");
        btnExplore.setBounds(25,50,150,40);
        JButton btnRetrieve = new JButton("Retrieve");
        btnRetrieve.setBounds(25,200,150,40);
        JButton btnInteractive = new JButton("Interactive Retrieval");
        btnInteractive.setBounds(25,350,150,40);
        JButton btnCreate = new JButton("Create");
        btnCreate.setBounds(25,500,150,40);
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(25, 650, 150, 40);
        /*
            ClickedEvent implements ActionListener and takes in Menu
            to return the specified action when the button is pressed
         */
        ClickedEvent exploreClicked = new ClickedEvent(exploreRecipesMenu);
        ClickedEvent retrieveClicked = new ClickedEvent(retrieveRecipeMenu);
        ClickedEvent interactiveClicked = new ClickedEvent(retrieveRecipeInteractiveMenu);
        ClickedEvent createClicked = new ClickedEvent(createRecipeMenu);
        ClickedEvent deleteClicked = new ClickedEvent(deleteRecipeMenu);

        //Adds buttons to the panel
        p.add(btnDelete);
        p.add(btnExplore);
        p.add(btnRetrieve);
        p.add(btnInteractive);
        p.add(btnCreate);

        // Attempting to create the TextArea here.
        p.add(new JScrollPane(textWelcome));
        /*
            'Listens' for any clicks on the buttons
         */
        btnExplore.addActionListener(exploreClicked);
        btnRetrieve.addActionListener(retrieveClicked);
        btnInteractive.addActionListener(interactiveClicked);
        btnCreate.addActionListener(createClicked);
        btnDelete.addActionListener(deleteClicked);
        f.repaint();
    }
}
