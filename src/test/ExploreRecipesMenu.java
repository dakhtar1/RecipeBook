package test;

import java.util.List;

public class ExploreRecipesMenu implements Menu {
    List<Recipe> recipeList;

    public ExploreRecipesMenu(List<Recipe> recipesList) {
        this.recipeList = recipesList;
    }

    @Override
    public void createRecipe(Recipe recipe) {

    }

    @Override
    public List<Recipe> getRecipes() {
        return null;
    }

    @Override
    public void show() {
        System.out.println("Recipes:");
        for (Recipe recipe: recipeList){
            System.out.println(recipe);
        }
    }

    @Override
    public Menu retrieveRecipe(String recipeName) {
        return null;
    }
}
