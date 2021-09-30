package test;

import org.junit.Test;

public class AllTests {
    @Test
    void firstTest(){
        System.out.println("JUnit Test 1");
    }

    @Test
    void createRecipe(){
        Recipe recipe = new Recipe();
        Menu mainMenu = new MainMenu();
        mainMenu.addRecipe(recipe);
    }

    @Test
    void exploreRecipes(){
        Menu mainMenu = new MainMenu();
        Menu exploreRecipesMenu = mainMenu.exploreRecipes();
        exploreRecipesMenu.show();
    }

    @Test
    void retrieveRecipe(){
        String recipeName = "";
        Menu mainMenu = new MainMenu();
        Menu recipeMenu = mainMenu.retrieveRecipe(recipeName);
    }
}
