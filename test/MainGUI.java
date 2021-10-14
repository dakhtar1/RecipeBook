import javax.swing.*;

public class MainGUI {
    public static void main(String[] args) throws Exception {
        RecipeAO recipeAOCSV = new RecipeAOCSV("../src/data/recipes.csv");
        recipeAOCSV.initializeRecipesList();
        Menu exploreRecipesMenu = new ExploreRecipesMenu(recipeAOCSV);
        Menu retrieveRecipeMenu = new RetrieveRecipeMenu(recipeAOCSV);
        Menu retrieveRecipeInteractiveMenu = new RetrieveRecipeInteractiveMenu(recipeAOCSV);
        Menu createRecipeMenu = new CreateRecipeMenu(recipeAOCSV);
        Menu deleteRecipeMenu = new DeleteRecipeMenu(recipeAOCSV);

        DrawPanel p  = new DrawPanel();
        JFrame f = new JFrame("Recipe Book");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        f.setSize(1000, 1000);
        f.setVisible(true);
        JTextField textWelcome = new JTextField("Welcome to the Recipe Book!");
        JButton btnExplore = new JButton("Explore");
        btnExplore.setBounds(10,10,200,40);
        JButton btnRetrieve = new JButton("Retrieve");
        btnRetrieve.setBounds(260,10,200,40);
        JButton btnInteractive = new JButton("Interactive Retrieval");
        btnInteractive.setBounds(550,10,200,40);
        JButton btnCreate = new JButton("Create");
        btnCreate.setBounds(800,10,200,40);
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(400, 665, 200, 40);
        ClickedEvent exploreClicked = new ClickedEvent(btnExplore,exploreRecipesMenu);
        ClickedEvent retrieveClicked = new ClickedEvent(btnExplore,exploreRecipesMenu);
        ClickedEvent interactiveClicked = new ClickedEvent(btnExplore,exploreRecipesMenu);
        ClickedEvent createClicked = new ClickedEvent(btnExplore,exploreRecipesMenu);
        ClickedEvent deleteClicked = new ClickedEvent(btnExplore,exploreRecipesMenu);
        p.add(btnDelete);
        p.add(btnExplore);
        p.add(btnRetrieve);
        p.add(btnInteractive);
        p.add(btnCreate);
        btnExplore.addActionListener(exploreClicked);
        btnRetrieve.addActionListener(retrieveClicked);
        btnInteractive.addActionListener(interactiveClicked);
        btnCreate.addActionListener(createClicked);
        btnDelete.addActionListener(deleteClicked);
        f.repaint();
    }
}
