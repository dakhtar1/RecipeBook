package test;

import java.util.List;

public class MainMenu implements Menu {
    @Override
    public void createRecipe(Recipe recipe) {
        RecipeAO recipeAO = new RecipeAO();
        recipeAO.createRecipe(recipe);
    }

    @Override
    public List<Recipe> getRecipes() {
        return null;
    }

    @Override
    public void show() {

    }

    @Override
    public Menu retrieveRecipe(String recipeName) {
        return null;
    }
}
