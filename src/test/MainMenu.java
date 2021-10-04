package test;

import java.util.List;

public class MainMenu implements Menu {
    RecipeAO recipeAO;
    public MainMenu(RecipeAO recipeAO) throws Exception {
        if (recipeAO == null){
            throw new Exception("Unable to instantiate MainMenu, recipeAO is null.");
        }
        this.recipeAO = recipeAO;
    }

    public MainMenu() {
        System.out.println("Main Menu initialized WITHOUT recipeAO.");
    }

    @Override
    public void createRecipe(Recipe recipe) {
        this.recipeAO.createRecipe(recipe);
    }

    @Override
    public List<Recipe> getRecipes() {
        return this.recipeAO.getRecipes();
    }

    @Override
    public void show() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Welcome to the Recipe Book!");
        stringBuilder.append("\n");
        stringBuilder.append("You can press 1, 2, or 3 at any time. Create (1) a recipe, retrieve (2) a recipe, or explore (3) all the recipes.");
        stringBuilder.append("\n");
        stringBuilder.append("In addition, please press -1 at any time to exit the application.");
        stringBuilder.append("\n");
        stringBuilder.append("Happy exploring!");
        System.out.println(stringBuilder.toString());
    }

    @Override
    public Menu retrieveRecipe(String recipeName) {
        return null;
    }
}
