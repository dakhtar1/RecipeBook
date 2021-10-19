import java.io.IOException;
import java.util.List;

public interface RecipeAO {
    void initializeRecipesList() throws IOException;

    void createRecipe(Recipe recipe) throws Exception;

    void deleteRecipe(String recipe_name) throws IOException;

    List<Recipe> getRecipes();

    Recipe getRecipe(String recipeName);

}
