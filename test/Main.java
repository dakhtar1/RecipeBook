import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        RecipeAO recipeAOCSV = new RecipeAOCSV("../src/data/recipes.csv");
        recipeAOCSV.initializeRecipesList();
        Menu exploreRecipesMenu = new ExploreRecipesMenu(recipeAOCSV);

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
        while (true) {
            System.out.println("Please enter a command or press any other key to exit:");
            input = bf.readLine();
            if (input.equals("1")) {
                exploreRecipesMenu.show();
            }
            // ADD COMMANDS 2-5 HERE
            else {
                return;
            }

        }
    }
}