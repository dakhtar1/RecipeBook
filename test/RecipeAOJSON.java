import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecipeAOJSON implements RecipeAO {
    List<Recipe> recipesList;

    @Override
    public void initializeRecipesList() {
    }

    @Override
    public void createRecipe(Recipe recipe) {
        System.out.println("RECIPE: " + "\n" + recipe.toString() + "CREATED SUCCESSFULLY.");
    }

    @Override
    public void deleteRecipe(String recipe_name) throws IOException {

    }

    @Override
    public List<Recipe> getRecipes() {
        String recipename = "test recipe";

        LinkedList<List<String>> ingredients = new LinkedList<>();
        LinkedList<String> testIngredient = new LinkedList<>();
        testIngredient.add("test ingredient");
        testIngredient.add("10");
        testIngredient.add("oz");
        ingredients.add(testIngredient);

        List<String> directions = new LinkedList<>();
        directions.add("test directions");
        Recipe recipe1 = new Recipe(recipename, ingredients, directions);
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe1);
        return recipeList;
    }

    @Override
    public Recipe getRecipe(String recipeName) {
        //TODO: not implemented yet.
        return null;
    }
}
