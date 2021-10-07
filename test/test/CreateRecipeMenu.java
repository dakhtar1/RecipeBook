package test;

public class CreateRecipeMenu implements Menu {
    RecipeAO recipeAO;

    public CreateRecipeMenu(RecipeAO recipeAO) throws Exception {
        if (recipeAO == null){
            throw new Exception("Could not instantiate CreateRecipeMenu, recipeAO was null.");
        }
        this.recipeAO = recipeAO;
    }
    @Override
    public void show() {
        System.out.println("RECIPE CREATION:");
    }

    @Override
    public void createRecipe(Recipe recipe) throws Exception {
        this.recipeAO.createRecipe(recipe);
    }

    @Override
    public Recipe retrieveRecipe(String recipeName) throws Exception {
        throw new Exception("Class CreateRecipeMenu cannot call \"retrieveRecipe\" method.");
    }

    @Override
    public void show_interactive(String recipeName) throws Exception {
        throw new Exception("Class CreateRecipeMenu cannot call \"show_interactive\" method.");
    }
}
