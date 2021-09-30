package test;

public interface Menu {
    void addRecipe(Recipe recipe);

    Menu exploreRecipes();

    void show();

    Menu retrieveRecipe(String recipeName);
}
