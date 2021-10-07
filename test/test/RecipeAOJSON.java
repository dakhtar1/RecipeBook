package test;

import java.util.ArrayList;
import java.util.List;

public class RecipeAOJSON implements RecipeAO {
    List<Recipe> recipesList;

    @Override
    public void initializeRecipesList() {
    }

    @Override
    public void createRecipe(Recipe recipe) {
        System.out.println("RECIPE: " + "\n" + recipe.toString() + "CREATED SUCCESSFULLY.");
    }

    @Override
    public List<Recipe> getRecipes() {
        String recipename = "test recipe";

        ArrayList<ArrayList<String>> ingredients = new ArrayList<>();
        ArrayList<String> testIngredient = new ArrayList<>();
        testIngredient.add("test ingredient");
        testIngredient.add("10");
        testIngredient.add("oz");
        ingredients.add(testIngredient);

        List<String> directions = new ArrayList<>();
        directions.add("test directions");
        Recipe recipe1 = new Recipe(recipename, ingredients, directions);
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe1);
        return recipeList;
    }

    @Override
    public Recipe getRecipe(String recipeName) {
        //TODO: not implemented yet.
        return null;
    }
}
