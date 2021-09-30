package test;
import java.util.List;

public interface Menu {
    void createRecipe(Recipe recipe);

    List<Recipe> getRecipes();

    void show();

    Menu retrieveRecipe(String recipeName);
}
