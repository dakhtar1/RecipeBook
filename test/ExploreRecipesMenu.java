import java.io.IOException;

public class ExploreRecipesMenu implements Menu {
    RecipeAO recipeAO;

    public ExploreRecipesMenu(RecipeAO recipeAO) {
        this.recipeAO = recipeAO;
    }

    @Override
    public void show() {
        System.out.println("RECIPES:");
        for (Recipe recipe : recipeAO.getRecipes()) {
            // Using getter() from Recipe.java
            System.out.println(recipe.getRecipeName());
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

    @Override
    public void deleteRecipe(String lasagna) throws IOException {

    }
}
