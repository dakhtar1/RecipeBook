package test;

import org.junit.Test;

import java.util.List;

public class AllTests {

    @Test
    void createRecipe(){
        Recipe recipe = new Recipe();
        Menu mainMenu = new MainMenu();
        mainMenu.createRecipe(recipe);
    }

    @Test
    void exploreRecipes(){
        Menu mainMenu = new MainMenu();
        List<Recipe> recipesList = mainMenu.getRecipes();
        Menu exploreRecipesMenu = new ExploreRecipesMenu(recipesList);
        exploreRecipesMenu.show();
    }

    @Test
    void retrieveRecipe(){
        String recipeName = "";
        Menu mainMenu = new MainMenu();
        Menu recipeMenu = mainMenu.retrieveRecipe(recipeName);
        recipeMenu.show();
    }
}
