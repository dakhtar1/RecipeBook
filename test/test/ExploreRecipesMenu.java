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
            System.out.println();
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

    @Override
    public void show_interactive(String recipeName) throws Exception {
        throw new Exception("Class ExploreRecipesMenu cannot call \"show_interactive\" method.");

    }
}
