import java.util.Iterator;
import java.util.List;

public class RecipeStringParser {
    public static String parseRecipeToCSVEntry(Recipe nextRecipe) {
        StringBuilder sb = new StringBuilder();
        // Add Name
        sb.append(nextRecipe.getRecipeName());
        sb.append(",");

        // Add Ingredients
        List<List<String>> ingredientsList = nextRecipe.getIngredients();
        Iterator<List<String>> ingredientsIterator = ingredientsList.iterator();
        int num = 0;
        while (ingredientsIterator.hasNext()){
            num+=1;
            List<String> ingredientData = ingredientsIterator.next();
            int ingredDataNum = 0;
            for (String data: ingredientData){
                sb.append(data);
                ingredDataNum+=1;
                if (ingredDataNum < 3){
                    sb.append("/");
                }
            }
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
            sb.append(directionsIterator.next());
            if (num < nextRecipe.getDirections().size()){
                sb.append("-");
            }
        }
        sb.append("\n");
        return sb.toString();
    }
}
