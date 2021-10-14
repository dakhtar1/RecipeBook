import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

//Compile this class
public class Main {
    public static void main(String[] args) throws Exception {
        RecipeAO recipeAOCSV = new RecipeAOCSV("./src/data/recipes.csv");
        recipeAOCSV.initializeRecipesList();
        Menu exploreRecipesMenu = new ExploreRecipesMenu(recipeAOCSV);
        Menu retrieveRecipeMenu = new RetrieveRecipeMenu(recipeAOCSV);
        Menu retrieveRecipeInteractiveMenu = new RetrieveRecipeInteractiveMenu(recipeAOCSV);
        Menu createRecipeMenu = new CreateRecipeMenu(recipeAOCSV);
        Menu deleteRecipeMenu = new DeleteRecipeMenu(recipeAOCSV);

        System.out.println("Welcome to the Recipe Book! Please refer to the following options:");
        System.out.println();
        System.out.println();
        System.out.println("At any time, please press 1, 2, 3, 4, 5.");
        System.out.println("1 - explore all recipes");
        System.out.println("2 - retrieve a particular recipe");
        System.out.println("3 - interactive recipe retrieval");
        System.out.println("4 - create a recipe");
        System.out.println("5 - delete a recipe");
        System.out.println("Press any other key to exit.");

        String input = "";
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println();
        System.out.println();
        while (true){
            System.out.println("Please enter a command or press any other key to exit:");
            input = bf.readLine();
            if (input.equals("1")){
                exploreRecipesMenu.show();
            }
            else if (input.equals("2")){
                retrieveRecipeMenu.show();
                System.out.println("Please enter the name of the recipe to retrieve:");
                String recipe = bf.readLine();
                Recipe retrieved = retrieveRecipeMenu.retrieveRecipe(recipe);
                if (retrieved != null){
                    System.out.println(retrieved);
                }
                else{
                    System.out.println("RECIPE " + "\"" + recipe + "\"" + " does not exist!");
                }
            }
            else if (input.equals("3")){
                retrieveRecipeInteractiveMenu.show();
                System.out.println("Please enter the name of the recipe to retrieve:");
                String recipe = bf.readLine();
                retrieveRecipeInteractiveMenu.show_interactive(recipe);
            }
            else if (input.equals("4")){
                createRecipeMenu.show();
                System.out.println("Please enter the name of the recipe to create:");
                String recipeName = bf.readLine();
                List<List<String>> ingredientsList = RecipeInputRetrieval.retrieveRecipeIngredientsInput();
                List<String> directionsList = RecipeInputRetrieval.retrieveDirectionsList();
                createRecipeMenu.createRecipe(new Recipe(recipeName, ingredientsList, directionsList));
            }
            else if (input.equals("5")){
                deleteRecipeMenu.show();
                System.out.println("Please enter the name of the recipe to delete");
                String recipe = bf.readLine();
                deleteRecipeMenu.deleteRecipe(recipe);
            }
            else{
                return;
            }
        }
    }
}
