package test;

import java.io.*;
import java.util.*;

public class RecipeAOCSV implements RecipeAO {
    private String filename;
    private List<Recipe> recipeList;
    private Map<String, Recipe> recipeMap;

    public RecipeAOCSV(String filename) {
        this.filename = filename;
    }

    @Override
    public void initializeRecipesList() throws IOException {
        recipeList = new LinkedList<>();
        recipeMap = new HashMap<>();
        BufferedReader bf = new BufferedReader(new FileReader(this.filename));
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
    public void createRecipe(Recipe recipe) throws Exception {
        if (this.recipeMap == null){
            throw new Exception("Unable to retrieve recipe, recipeMap was null.");
        }
        if (this.recipeList == null){
            throw new Exception("Unable to retrieve recipe, recipeList was null");
        }
        if (!recipeMap.containsKey(recipe.getRecipeName().toLowerCase())){
            Recipe newRecipe = new Recipe(recipe.getRecipeName().toLowerCase(), recipe.getIngredients(), recipe.getDirections());
            recipeMap.put(newRecipe.getRecipeName(), newRecipe);
            recipeList.add(newRecipe);
            FileWriter fw = new FileWriter(this.filename, true);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n");
            stringBuilder.append(newRecipe.getRecipeName());
            stringBuilder.append(",");
            Iterator<String> it = newRecipe.getIngredients().iterator();
            int num = 0;
            while (it.hasNext()){
                stringBuilder.append(it.next());
                num+=1;
                if (num < newRecipe.getIngredients().size()){
                    stringBuilder.append("-");
                }
            }
            stringBuilder.append(",");
            num = 0;
            it = newRecipe.getDirections().iterator();
            while (it.hasNext()){
                stringBuilder.append(it.next());
                num+=1;
                if (num < newRecipe.getDirections().size()){
                    stringBuilder.append("-");
                }
            }
            fw.write(stringBuilder.toString());
            fw.close();
            System.out.println("RECIPE: " + "\n" + recipe.toString() + "CREATED SUCCESSFULLY.");
        }
        //Check to ensure that if recipe already exists, no action is taken.
        else{
            System.out.println("RECIPE: " + "\"" + recipe.getRecipeName() + "\"" + " already exists. NO ACTION TAKEN.");
        }
    }

    @Override
    public List<Recipe> getRecipes() {
        return this.recipeList;
    }

    @Override
    public Recipe getRecipe(String recipeName){
        return this.recipeMap.get(recipeName);
    }
}
