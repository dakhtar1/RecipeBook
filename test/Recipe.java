import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class Recipe {
    //change ingredients to be a 2D array instead of a list of strings
    private String recipeName;
    private List<List<String>> ingredients;
    private List<String> directions;

    public Recipe(String recipeName, List<List<String>> ingredients, List<String> directions) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public String getRecipeName(){
        return this.recipeName;
    }

    public List<String> getDirections() {
        return directions;
    }

    public List<List<String>> getIngredients() {
        return ingredients;
    }

    public void setRecipeName(String recipeName){
        this.recipeName = recipeName;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    public void setIngredients(List<List<String>> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(recipeName, recipe.recipeName) && Objects.equals(ingredients, recipe.ingredients) && Objects.equals(directions, recipe.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeName, ingredients, directions);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: " + this.recipeName);
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("Ingredients: ");
        stringBuilder.append("\n");
        // Fix so that it accurately parses through new ingredients list format
        for (int i = 0; i < this.ingredients.size(); i++){
            List<String> ingredientsList = this.ingredients.get(i);
            stringBuilder.append(ingredientsList.get(1) + ingredientsList.get(2) + " " + ingredientsList.get(0) + "\n");
        }
        stringBuilder.append("\n");
        stringBuilder.append("Directions: ");
        stringBuilder.append("\n");
        for (int i = 0; i < this.directions.size(); i++){
            if (i < this.directions.size()-1){
                stringBuilder.append("Step " + (i+1) + ": " + directions.get(i) + "\n");
            }
            else{
                stringBuilder.append("Step " + (i+1) + ": " + directions.get(i));
            }
        }
        return stringBuilder.toString();
    }
}
