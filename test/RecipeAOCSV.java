import java.io.*;
import java.util.*;

public class RecipeAOCSV implements RecipeAO {
    private String filename;
    private List<Recipe> recipeList;
    private Map<String, Recipe> recipeMap;

    public RecipeAOCSV(String filename) {
        this.filename = filename;
    }

    // Initialize Recipe Function
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

            LinkedList<List<String>> ingredientsList = new LinkedList();
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

    // Create Recipe Function
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
            stringBuilder.append(newRecipe.getRecipeName());
            stringBuilder.append(",");

            // Updated the way the program writes to the csv
            for (List<String> Data : newRecipe.getIngredients()){
                for (Object n : Data){
                    stringBuilder.append(n);
                    stringBuilder.append("/");
                }
                stringBuilder.append("-");
            }

            stringBuilder.append(",");
            int num = 0;
            Iterator<String> itD = newRecipe.getDirections().iterator();
            while (itD.hasNext()){
                stringBuilder.append(itD.next());
                num+=1;
                if (num < newRecipe.getDirections().size()){
                    stringBuilder.append("-");
                }
            }
            stringBuilder.append("\n");
            fw.write(stringBuilder.toString());
            fw.close();
            System.out.println("RECIPE: " + "\n" + recipe.getRecipeName() + "CREATED SUCCESSFULLY.");
        }
        //Check to ensure that if recipe already exists, no action is taken.
        else{
            System.out.println("RECIPE: " + "\"" + recipe.getRecipeName() + "\"" + " already exists. NO ACTION TAKEN.");
        }
    }

    // Get Recipe Function
    @Override
    public List<Recipe> getRecipes() {
        return this.recipeList;
    }

    // Get Recipe Function
    @Override
    public Recipe getRecipe(String recipeName){
        return this.recipeMap.get(recipeName);
    }

    // TODO: Make a Delete Recipe function

    @Override
    public void deleteRecipe(String recipe_name) throws IOException {
        // Handle Exception
        Iterator<Recipe> it = this.recipeList.iterator();
        StringBuilder sb = new StringBuilder();
        FileWriter fw = new FileWriter(this.filename);
        while (it.hasNext()){
            Recipe nextRecipe = it.next();
            // Only add to CSV if the recipe is not the one we are deleting
            if(!nextRecipe.getRecipeName().equals(recipe_name)){
                // Add Name
                sb.append(nextRecipe.getRecipeName());
                sb.append(",");

                // Add Ingredients
                List<List<String>> ingredientsList = nextRecipe.getIngredients();
                Iterator<List<String>> ingredientsIterator = ingredientsList.iterator();
                int num = 0;
                while (ingredientsIterator.hasNext()){
                    num+=1;
                    sb.append(ingredientsIterator.next());
                    if (num < nextRecipe.getIngredients().size()){
                        sb.append("-");
                    }
                }
                sb.append(",");
                num = 0;

                // Add Directions
                List<String> directionsList = nextRecipe.getDirections();
                Iterator<String> directionsIterator = directionsList.iterator();
                while (directionsIterator.hasNext()){
                    num+=1;
                    directionsIterator.next();
                    if (num < nextRecipe.getDirections().size()){
                        sb.append("-");
                    }
                }
                sb.append("\n");
            }
        }
        fw.write(sb.toString());
        fw.close();
        System.out.println("RECIPE: " + "\"" + recipe_name + "\"" + " DELETED SUCCESSFULLY.");
    }
}

