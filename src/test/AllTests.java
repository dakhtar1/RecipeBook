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
        RecipeAO recipeAO = new RecipeAOCSV();
        recipeAO.initializeRecipesList("src/files/recipes.csv");
        System.out.println(recipeAO.getRecipes());
    }
    @Test
    public void createRecipe(){
        String recipename = "Lasagna";
        List<String> ingredientsList = new LinkedList<>();
        ingredientsList.add("pasta");
        ingredientsList.add("tomatoes");
        List<String> directions = new LinkedList<>();
        directions.add("Make the pasta");
        Recipe recipe = new Recipe(recipename, ingredientsList, directions);
        Menu mainMenu = new MainMenu();
        //TODO: Add check if recipe already exists.
        mainMenu.createRecipe(recipe);
    }

    @Test
    public void exploreRecipes(){
        Menu mainMenu = new MainMenu();
        List<Recipe> recipesList = mainMenu.getRecipes();
        Menu exploreRecipesMenu = new ExploreRecipesMenu(recipesList);
        //TODO: Make sure that parsing happens for all steps.
        exploreRecipesMenu.show();
    }

    @Test
    public void retrieveRecipe(){
        String recipeName = "";
        Menu mainMenu = new MainMenu();
        Menu recipeMenu = mainMenu.retrieveRecipe(recipeName);
        recipeMenu.show();
    }
}
