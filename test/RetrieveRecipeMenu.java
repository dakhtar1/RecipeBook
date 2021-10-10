import java.io.IOException;

public class RetrieveRecipeMenu implements Menu {
    RecipeAO recipeAO;

    public RetrieveRecipeMenu(RecipeAO recipeAO) throws Exception {
        if (recipeAO == null){
            throw new Exception("Could not instantiate RetrieveRecipeMenu, recipeAO was null.");
        }
        this.recipeAO = recipeAO;
    }
    @Override
    public void show() {
        System.out.println("RETRIEVE RECIPE:");
    }

    @Override
    public void createRecipe(Recipe recipe) throws Exception {
        throw new Exception("Class RetrieveRecipeMenu cannot call \"createrecipe\" method.");
    }

    @Override
    public Recipe retrieveRecipe(String recipeName) throws Exception {
        System.out.println("Retrieving recipe: " + "\"" + recipeName + "\"" + "...");
        Recipe recipe = this.recipeAO.getRecipe(recipeName);
        if (recipe == null){
            System.out.println("NO RECIPE FOUND WITH NAME " + "\"" + recipeName + "\"");
        }
        else{
            System.out.println(recipeName + " successfully found.");
        }
        return this.recipeAO.getRecipe(recipeName);
    }

    @Override
    public void show_interactive(String recipeName) throws Exception {
        throw new Exception("Class RetrieveRecipMenu cannot call \"show_interactive\" method.");
    }

    @Override
    public void deleteRecipe(String lasagna) throws IOException {

    }
}
