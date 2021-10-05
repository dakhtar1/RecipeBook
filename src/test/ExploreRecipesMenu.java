package test;

import java.util.List;

public class ExploreRecipesMenu implements Menu {
    List<Recipe> recipeList;

    public ExploreRecipesMenu(List<Recipe> recipesList) {
        this.recipeList = recipesList;
    }

    @Override
    public void show() {
        System.out.println("RECIPES:");
        for (Recipe recipe: recipeList){
            System.out.println(recipe);
        }
    }

    @Override
    public void createRecipe(Recipe recipe) throws Exception {
        throw new Exception("Class ExploreRecipesMenu cannot call \"createRecipe\" method.");
    }

    @Override
    public Recipe retrieveRecipe(String recipeName) throws Exception {
        throw new Exception("Class ExploreRecipesMenu cannot call \"retrieveRecipe\" method.");
    }
}
