package test;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllTests {

    @Test
    public void mainMenu(){
        Menu mainMenu = new MainMenu();
        mainMenu.show();
    }

    @Test
    public void initializeRecipes() throws IOException {
        RecipeAO recipeAO = new RecipeAOCSV("src/files/recipes.csv");
        recipeAO.initializeRecipesList();
        System.out.println(recipeAO.getRecipes());
    }
    @Test
    public void createRecipe() throws Exception {
        String recipename = "pasta";

        // Change ingredientsList to be 2D array instead of list of strings
        ArrayList<ArrayList<String>> ingredientsList = new ArrayList();
        /*  NOTE: AllTests won't work after a recipe in the new format is added to the csv.
         *  Currently need to fix the create recipe method since it doesn't yet save
         *  recipes in the proper format. Saves them as a list instead of converting to a string.
         */
        String testList[][] = {{"pasta","1","lb"},{"tomatoes","24","oz"},{"Onions","2","lb"}};
        for (int i = 0; i < testList.length; i++){
            ArrayList<String> newIngredient = new ArrayList();
            newIngredient.add(testList[i][0]);
            newIngredient.add(testList[i][1]);
            newIngredient.add(testList[i][2]);
            ingredientsList.add(newIngredient);
        }

        List<String> directions = new LinkedList<>();
        directions.add("Make the pasta");
        Recipe recipe = new Recipe(recipename, ingredientsList, directions);
        RecipeAO recipeAO = new RecipeAOCSV("src/files/recipes.csv");
        recipeAO.initializeRecipesList();
        Menu createRecipeMenu = new CreateRecipeMenu(recipeAO);
        createRecipeMenu.show();
        createRecipeMenu.createRecipe(recipe);
    }

    @Test
    public void exploreRecipes() throws Exception {
        RecipeAO recipeAO = new RecipeAOCSV("src/files/recipes.csv");
        recipeAO.initializeRecipesList();
        Menu exploreRecipesMenu = new ExploreRecipesMenu(recipeAO.getRecipes());
        exploreRecipesMenu.show();
    }

    @Test
    public void retrieveRecipe_nonInteractive() throws Exception {
        RecipeAO recipeAO = new RecipeAOCSV("src/files/recipes.csv");
        recipeAO.initializeRecipesList();
        Menu retrieveRecipeMenu = new RetrieveRecipeMenu(recipeAO);
        retrieveRecipeMenu.show();
        String recipeName = "lasagna";
        Recipe retrievedRecipe = retrieveRecipeMenu.retrieveRecipe(recipeName);
        System.out.println(retrievedRecipe);
    }

    @Test
    public void retrieveRecipe_Interactive() throws Exception {
        RecipeAO recipeAO = new RecipeAOCSV("src/files/recipes.csv");
        recipeAO.initializeRecipesList();
        Menu retrieveRecipeMenu = new RetrieveRecipeMenu(recipeAO);
        retrieveRecipeMenu.show();
        String recipeName = "lasagna";
        //TODO: Implement retrieval in interactive way.
        //TEST
    }
}
