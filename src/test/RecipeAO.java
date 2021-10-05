package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface RecipeAO {
    void initializeRecipesList() throws IOException;

    void createRecipe(Recipe recipe) throws Exception;

    List<Recipe> getRecipes();

    Recipe getRecipe(String recipeName);
}
