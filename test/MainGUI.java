import javax.swing.*;
import javax.swing.event.*;
import java.io.IOException;
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
        JPanel recipeListDisp = new JPanel(null);
        JLabel title = new JLabel("Saved Recipes :");
        title.setBounds(25,25,80,25);
        explore.add(title);
        List<Recipe> recipeList = recipeAOCSV.getRecipes();
        System.out.println(recipeList);
        int yPos = 25;
        //System.out.println(recipeList.size());
        for (int i = 0; i < recipeList.size(); i++){
            System.out.println(recipeList.get(i).getRecipeName());
            JLabel name = new JLabel(recipeList.get(i).getRecipeName().toString());
            yPos += 15;
            name.setBounds(50,yPos,200,25);
            explore.add(name);
        }

        tabbedPane.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                explore.removeAll();

                JPanel recipeListDisp = new JPanel(null);
                JLabel title = new JLabel("Saved Recipes :");
                title.setBounds(25,25,80,25);
                explore.add(title);
                List<Recipe> recipeList = recipeAOCSV.getRecipes();
                System.out.println(recipeList);
                int yPos = 25;
                //System.out.println(recipeList.size());
                for (int i = 0; i < recipeList.size(); i++){
                    System.out.println(recipeList.get(i).getRecipeName());
                    JLabel name = new JLabel(recipeList.get(i).getRecipeName().toString());
                    yPos += 15;
                    name.setBounds(50,yPos,200,25);
                    explore.add(name);
                }
            }

        });


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
                    recipeName.setBounds(navbarX, navbarY+10, 500, 100);
                    recipeName.setFont(new Font("Calibri", Font.BOLD, 25));
                    recipeInfo.add(recipeName);

                    //Ingredients
                    JLabel ingredientsTitle = new JLabel("Ingredients: ");
                    ingredientsTitle.setBounds(navbarX, navbarY+35, 500, 100);
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
                        ing.setBounds(ingredientX, ingredientY, 500, 100);
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

                    JButton deleteRecipeBtn = new JButton("Delete");
                    deleteRecipeBtn.setBounds(ingredientX, ingredientY+100, 100, 25);
                    recipeInfo.add(deleteRecipeBtn);

                    deleteRecipeBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                recipeAOCSV.deleteRecipe(searchedRecipe);
                                recipeInfo.removeAll();
                                retrieve.repaint();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
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
        newIngredients.setLineWrap(true);
        JScrollPane ingScrollPane = new JScrollPane(newIngredients);
        ingScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ingScrollPane.setPreferredSize(new Dimension(100, 140));

        newIngredientLabel.setBounds(25 , 35, 200, 25);
        ingScrollPane.setBounds(135 , 40, 100, 140);

        create.add(newIngredientLabel);
        create.add(ingScrollPane);

        JLabel newDirectionsLabel = new JLabel("Directions: ");
        JTextArea newDirections = new JTextArea(5, 30);
        newDirections.setLineWrap(true);

        JScrollPane dirScrollPane = new JScrollPane(newDirections);
        dirScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        dirScrollPane.setPreferredSize(new Dimension(300, 150));

        newDirectionsLabel.setBounds(25 , 180, 200, 25);
        dirScrollPane.setBounds(135 , 185, 300, 150);


        create.add(newDirectionsLabel);
        create.add(dirScrollPane);

        JButton addRecipeBtn = new JButton("Add Recipe");
        addRecipeBtn.setBounds(135, 350, 100, 25);
        create.add(addRecipeBtn);

        addRecipeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String newRecipeNameStr = newName.getText();
                String newRecipeIngStr = newIngredients.getText();
                String newRecipeDirStr = newDirections.getText();

                List<String> ingList = Arrays.asList(newRecipeIngStr.split("\n",0));
                List<List<String>> ingListFinal = new ArrayList<>();
                for (int i=0; i< ingList.size(); i++){
                    ingListFinal.add(Arrays.asList(ingList.get(i).split(" ", 0)));
                }
                List<String> dirList = Arrays.asList(newRecipeDirStr.split("\n\n",0));

                System.out.println(newRecipeNameStr);
                System.out.println(ingListFinal);
                System.out.println(dirList);
                Recipe newRecipe = new Recipe(newRecipeNameStr, ingListFinal, dirList);
                try {
                    recipeAOCSV.createRecipe(newRecipe);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("ERROR");
                }

            }
        });


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
