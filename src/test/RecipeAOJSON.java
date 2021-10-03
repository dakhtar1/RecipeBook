package test;

import java.util.ArrayList;
import java.util.List;

public class RecipeAOJSON implements RecipeAO {
    List<Recipe> recipesList;

    @Override
    public void initializeRecipesList(String filename) {
    }

    @Override
    public void createRecipe(Recipe recipe) {
        System.out.println("RECIPE: " + "\n" + recipe.toString() + "CREATED SUCCESSFULLY.");
    }

    @Override
    public List<Recipe> getRecipes() {
        String recipename = "test recipe";
        List<String> ingredients = new ArrayList<>();
        ingredients.add("test ingredient");
        List<String> directions = new ArrayList<>();
        directions.add("test directions");
        Recipe recipe1 = new Recipe(recipename, ingredients, directions);
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe1);
        return recipeList;
    }
}
