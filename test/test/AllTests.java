package test;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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
        String recipename = "lasagna";
        List<String> ingredientsList = new LinkedList<>();
        ingredientsList.add("pasta");
        ingredientsList.add("tomatoes");
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
        String recipeName = "lasagna";
        Menu retrieveRecipeInteractiveMenu = new RetrieveRecipeInteractiveMenu(recipeAO);
        retrieveRecipeInteractiveMenu.show_interactive(recipeName);
    }

    @Test
    public void deleteRecipe() throws Exception {
        RecipeAO recipeAO = new RecipeAOCSV("src/files/recipes.csv");
        recipeAO.initializeRecipesList();
        recipeAO.deleteRecipe("lasagna");
    }
}
