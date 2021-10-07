package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

public class RetrieveRecipeInteractiveMenu implements Menu {
    RecipeAO recipeAO;
    public RetrieveRecipeInteractiveMenu(RecipeAO recipeAO) throws Exception {
        if (recipeAO == null){
            throw new Exception("Unable to instantiate RetrieveRecipeInteractiveMenu, recipeAO was null.");
        }
        this.recipeAO = recipeAO;
    }

    @Override
    public void show() {
        System.out.println("INTERACTIVE RECIPE RETRIEVAL:");
    }

    @Override
    public void createRecipe(Recipe recipe) throws Exception {
        throw new Exception("Cannot call method \"createRecipe\" from RetrieveRecipeInteraction");
    }

    @Override
    public Recipe retrieveRecipe(String recipeName) throws Exception {
        Recipe retrievedRecipe = this.recipeAO.getRecipe(recipeName);
        if (retrievedRecipe == null){
            System.out.println("NO RECIPE MATCHED " + "\"" + recipeName +  "\"" + ". Returning null.");
            return null;
        }
        else{
            System.out.println("RETRIEVED RECIPE " + "\"" + recipeName + "\"");
        }
        return retrievedRecipe;
    }

    @Override
    public void show_interactive(String recipeName) throws Exception {
        Recipe retrievedRecipe = this.recipeAO.getRecipe(recipeName);
        if (retrievedRecipe == null){
            throw new Exception("RECIPE " + "\"" + recipeName + "\"" + " does not exist.");
        }
        System.out.println("RECIPE " + "\"" + retrievedRecipe.getRecipeName() + "\"" + ":");
        System.out.println();
        System.out.println();
        System.out.println("INGREDIENTS: ");
        for (String ingredient: retrievedRecipe.getIngredients()){
            System.out.println("-" + " " + ingredient);
        }
        System.out.println();
        System.out.println();
        List<String> directionsList = retrievedRecipe.getDirections();
        String input = "";
        int num = 1;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Iterator<String> it = directionsList.iterator();
        System.out.println("Please press enter to view Step " + num);
        while (it.hasNext()){
            input = bf.readLine();
            while (input == "" || !input.equals("\n")){
                input = bf.readLine();
            }
            System.out.println("Step " + num + ": " + it.next());
            num+=1;
        }
    }
}
