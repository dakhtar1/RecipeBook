package test;

import org.junit.Test;

import java.io.IOException;
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
        String recipename = "test";
        List<String> ingredientsList = new LinkedList<>();
        ingredientsList.add("pasta");
        ingredientsList.add("tomatoes");
        List<String> directions = new LinkedList<>();
        directions.add("Make the pasta");
        Recipe recipe = new Recipe(recipename, ingredientsList, directions);
        RecipeAO recipeAO = new RecipeAOCSV("src/files/recipes.csv");
        recipeAO.initializeRecipesList();
        Menu createRecipeMenu = new CreateRecipeMenu(recipeAO);
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
    public void retrieveRecipe() throws Exception {
        RecipeAO recipeAO = new RecipeAOCSV("src/files/recipes.csv");
        recipeAO.initializeRecipesList();
        String recipeName = "lasagna";
        Menu retrieveRecipeMenu = new RetrieveRecipeMenu(recipeAO);
        retrieveRecipeMenu.show();
        retrieveRecipeMenu.retrieveRecipe(recipeName);
    }
}
