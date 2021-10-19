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

        JPanel explore = new JPanel(null);
        JPanel retrieve = new JPanel(null);
        JPanel create = new JPanel(null);
        JPanel delete = new JPanel(null);

        tabbedPane.add("Explore", explore);
        tabbedPane.add("Retrieve", retrieve);
        tabbedPane.add("Create", create);


        // Explore Tab
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

        // Retrieve Tab
        //   search the recipe by name
        String searchedRecipe;
        JTextField field = new JTextField(20);
        JLabel retrieveTitle = new JLabel("Recipe Search: ");
        JLabel test1 = new JLabel("TEST");
        JButton search = new JButton("Search");
        JPanel recipeInfo = new JPanel(null);

        int navbarX = 25;
        int navbarY = 10;
        retrieveTitle.setBounds(navbarX,navbarY,100,25);
        field.setBounds(navbarX+100,navbarY,200,25);
        search.setBounds(navbarX+300,navbarY,100,25);
        recipeInfo.setBounds(navbarX, navbarY, 500, 1000 );
        //recipeInfo.setBackground(Color.DARK_GRAY);
        retrieve.add(retrieveTitle);
        retrieve.add(field);
        retrieve.add(search);
        retrieve.add(recipeInfo);

        test1.setBackground(Color.RED);


        search.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                recipeInfo.removeAll();
                String searchedRecipe = field.getText();
                System.out.println(searchedRecipe);
                Recipe returnedRecipe = recipeAOCSV.getRecipe(searchedRecipe);
                if (returnedRecipe != null){
                    JLabel recipeName = new JLabel(returnedRecipe.getRecipeName());
                    recipeName.setBounds(navbarX, navbarY+10, 100, 100);
                    recipeName.setFont(new Font("Calibri", Font.BOLD, 25));
                    recipeInfo.add(recipeName);

                    //Ingredients
                    JLabel ingredientsTitle = new JLabel("Ingredients: ");
                    ingredientsTitle.setBounds(navbarX, navbarY+35, 100, 100);
                    ingredientsTitle.setFont(new Font("Calibri", Font.BOLD, 18));
                    recipeInfo.add(ingredientsTitle);

                    int ingredientX = navbarX+15;
                    int ingredientY = navbarY+35;
                    List ingList = returnedRecipe.getIngredients();
                    for (int n = 0; n < ingList.size(); n++){
                        ingredientY += 15;

                        List ingData = (List)ingList.get(n);
                        String ingredientStr = String.join("  ", ingData);
                        JLabel ing = new JLabel(ingredientStr);
                        ing.setBounds(ingredientX, ingredientY, 100, 100);
                        recipeInfo.add(ing);
                    }

                    //Directions
                    JLabel directionsTitle = new JLabel("Directions: ");
                    directionsTitle.setBounds(ingredientX-15, ingredientY+35, 100, 100);
                    directionsTitle.setFont(new Font("Calibri", Font.BOLD, 18));
                    recipeInfo.add(directionsTitle);
                    ingredientY = ingredientY+35;
                    List dirList = returnedRecipe.getDirections();
                    for (int m = 0; m < dirList.size(); m++){
                        ingredientY += 15;
                        int setpCount = m+1;
                        JLabel dirLabel = new JLabel("Step " + setpCount +": ");
                        JLabel dir = new JLabel((String)dirList.get(m));
                        dirLabel.setBounds(ingredientX, ingredientY, 100, 100);
                        ingredientY += 15;
                        dir.setBounds(ingredientX+15, ingredientY, 100, 100);
                        recipeInfo.add(dirLabel);
                        recipeInfo.add(dir);

                    }

                    retrieve.repaint();

                    System.out.println(returnedRecipe.getRecipeName());
                    System.out.println(returnedRecipe.getDirections());
                    System.out.println(returnedRecipe.getIngredients());
                }
                else{
                    System.out.println("This recipe does not exist");
                }
            }
        });


        // Create Tab
        //  you input the name, ingredients, and steps for the recipe
        JLabel newNameLabel = new JLabel("New Recipe Name: ");
        newNameLabel.setBounds(25 , 10, 200, 25);

        JTextField newName = new JTextField(30);
        newName.setBounds(135 , 10, 100, 25);

        create.add(newNameLabel);
        create.add(newName);

        JLabel newIngredientLabel = new JLabel("Ingredients: ");
        JTextArea newIngredients = new JTextArea(5, 30);

        newIngredientLabel.setBounds(25 , 35, 200, 25);
        newIngredients.setBounds(135 , 40, 100, 140);

        create.add(newIngredientLabel);
        create.add(newIngredients);

        JLabel newDirectionsLabel = new JLabel("Directions: ");
        JTextArea newDirections = new JTextArea(5, 30);

        newDirectionsLabel.setBounds(25 , 180, 200, 25);
        newDirections.setBounds(135 , 185, 300, 150);
        newDirections.setLineWrap(true);

        create.add(newDirectionsLabel);
        create.add(newDirections);

        JButton addRecipeBtn = new JButton("Add Recipe");
        addRecipeBtn.setBounds(135, 350, 100, 25);
        create.add(addRecipeBtn);


        // Delete Tab
        //  Textbox where you input the name of the recipe you want to delete



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
