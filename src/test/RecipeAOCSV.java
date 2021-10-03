package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class RecipeAOCSV implements RecipeAO {
    private List<Recipe> recipeList;
    private Map<String, Recipe> recipeMap;
    @Override
    public void initializeRecipesList(String filename) throws IOException {
        recipeList = new LinkedList<>();
        recipeMap = new HashMap<>();
        BufferedReader bf = new BufferedReader(new FileReader(filename));
        String line = "";
        while ((line = bf.readLine()) != null){
            String[] recipeData = line.split(",");
            String recipeName = recipeData[0];
            String ingredients = recipeData[1];
            String directions = recipeData[2];
            String[] ingredientsList_unparsed = ingredients.split("-");
            List<String> ingredientsList = new LinkedList<>();
            for (String ingredient: ingredientsList_unparsed){
                ingredientsList.add(ingredient);
            }
            String[] directionsList_unparsed = directions.split("-");
            List<String> directionsList = new LinkedList<>();
            for (String direction: directionsList_unparsed){
                directionsList.add(direction);
            }
            Recipe recipe = new Recipe(recipeName, ingredientsList, directionsList);
            recipeList.add(recipe);
            recipeMap.put(recipe.getRecipeName(), recipe);
        }
    }

    @Override
    public void createRecipe(Recipe recipe) {
        System.out.println("RECIPE: " + "\n" + recipe.toString() + "CREATED SUCCESSFULLY.");
    }

    @Override
    public List<Recipe> getRecipes() {
        return this.recipeList;
    }
}
