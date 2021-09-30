package test;

public interface Menu {
    void createRecipe(Recipe recipe);

    Menu exploreRecipes();

    void show();

    Menu retrieveRecipe(String recipeName);
}
