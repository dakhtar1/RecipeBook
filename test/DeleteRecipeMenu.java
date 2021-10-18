import java.io.IOException;

public class DeleteRecipeMenu implements Menu {
    RecipeAO recipeAO;

    public DeleteRecipeMenu(RecipeAO recipeAO) throws Exception {
        if (recipeAO == null){
            throw new Exception("Unable to instantiate DeleteRecipeMenu, recipeAO was null.");
        }
        this.recipeAO = recipeAO;
    }

    @Override
    public void show() {
        System.out.println("Welcome to RECIPE DELETION.");
    }

    @Override
    public void createRecipe(Recipe recipe) throws Exception {
        throw new Exception("Class DeleteRecipeMenu cannot call method \"createRecipe\".");
    }

    @Override
    public Recipe retrieveRecipe(String recipeName) throws Exception {
        throw new Exception("Class DeleteRecipeMenu cannot call method \"retrieveRecipe\".");
    }

    @Override
    public void show_interactive(String recipeName) throws Exception {
        throw new Exception("Class DeleteRecipeMenu cannot call method \"show_interactive\".");
    }

    @Override
    public void deleteRecipe(String recipeName) throws IOException {
        this.recipeAO.deleteRecipe(recipeName);
    }
}
