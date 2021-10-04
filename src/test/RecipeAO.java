package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface RecipeAO {
    void initializeRecipesList(String filename) throws IOException;

    void createRecipe(Recipe recipe);

    List<Recipe> getRecipes();

    Recipe getRecipe(String recipeName);
}
