package test;

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
        Recipe recipe = this.recipeAO.getRecipe(recipeName);
        if (recipe == null){
            System.out.println("NO RECIPE FOUND WITH NAME " + "\"" + recipeName + "\"");
        }
        return this.recipeAO.getRecipe(recipeName);
    }
}
