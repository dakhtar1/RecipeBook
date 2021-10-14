import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class RecipeInputRetrieval {

    public static List<List<String>> retrieveRecipeIngredientsInput() throws IOException {
        LinkedList<List<String>> ingredientsList = new LinkedList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int ingredientNumber = 1;
        System.out.println("Please enter an ingredient for the recipe:");
        String ingredient = bf.readLine();
        System.out.println("Please enter the unit for this ingredient. (i.e. lb, oz, etc):");
        String unit = bf.readLine();
        System.out.println("Please enter the quantity of the ingredient in the unit specified previously:");
        String quantity = bf.readLine();
        LinkedList<String> ingredientComponents = new LinkedList<>();
        ingredientComponents.add(ingredient);
        ingredientComponents.add(unit);
        ingredientComponents.add(quantity);
        ingredientsList.add(ingredientComponents);
        ingredientNumber+=1;
        System.out.println("Please enter information for ingredient " + ingredientNumber + ": or type \"done\" to move to the next step.");
        String input;
        while (!(input = bf.readLine()).equals("done")){
            System.out.println("Please enter an ingredient for the recipe:");
            ingredient = bf.readLine();
            System.out.println("Please enter the unit for this ingredient. (i.e. lb, oz, etc):");
            unit = bf.readLine();
            System.out.println("Please enter the quantity of the ingredient in the unit specified previously:");
            quantity = bf.readLine();
            ingredientComponents = new LinkedList<>();
            ingredientComponents.add(ingredient);
            ingredientComponents.add(unit);
            ingredientComponents.add(quantity);
            ingredientsList.add(ingredientComponents);
            ingredientNumber+=1;
            System.out.println("Please enter information for ingredient " + ingredientNumber + ": or type \"done\" to move to the next step.");
        }
        return ingredientsList;

    }

    public static List<String> retrieveDirectionsList() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> directionsList = new LinkedList<>();
        int stepNum = 1;
        System.out.println("Please type Step 1:");
        String step = bf.readLine();
        directionsList.add(step);
        System.out.println("Please type out Step " + stepNum + " or type \"done\" to create the recipe.");
        while (!(step = bf.readLine()).equals("done")){
            directionsList.add(step);
            stepNum+=1;
            System.out.println("Please type out Step " + stepNum + " or type \"done\" to create the recipe.");
        }
        return directionsList;
    }
}
