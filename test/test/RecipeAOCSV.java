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
        System.out.println("Initializing recipes list...");
        recipeList = new LinkedList<>();
        recipeMap = new HashMap<>();
        BufferedReader bf = new BufferedReader(new FileReader(this.filename));
        String line = "";
        // Update the string parsing/conversion of the ingredients variable
        while ((line = bf.readLine()) != null){
            String[] recipeData = line.split(",");
            String recipeName = recipeData[0];
            String ingredients = recipeData[1];
            String directions = recipeData[2];
            String[] ingredientsList_unparsed = ingredients.split("-");
            //Include code to separate each ingredient's info/measurements

            ArrayList<ArrayList<String>> ingredientsList = new ArrayList();
            for (String ingredient: ingredientsList_unparsed){
                ArrayList<String> newIngredient = new ArrayList();
                String[] measurements = ingredient.split("/");
                newIngredient.add(measurements[0]);
                newIngredient.add(measurements[1]);
                newIngredient.add(measurements[2]);
                ingredientsList.add(newIngredient);
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
        System.out.println("Initialization complete.");
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

            /* Currently saves each ingredient as a list.
            *  TODO: Implement changes so each ingredient is properly saved as a string
            *  CURRENT:
            *  pasta,[pasta, 1, lb]-[tomatoes, 24, oz]-[Onions, 2, lb],Make the pasta
            *
            *  GOAL:
            *  pasta,pasta/1/lb-tomatoes/24/oz-Onions/2/lb,Make the pasta
            */
            Iterator<ArrayList<String>> it = newRecipe.getIngredients().iterator();
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
            Iterator<String> itD = newRecipe.getDirections().iterator();
            while (itD.hasNext()){
                stringBuilder.append(itD.next());
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
