import java.util.List;
import java.util.Objects;

public class Recipe {
    private String recipeName;
    private List<String> ingredients;
    private List<String> directions;

    public Recipe(String recipeName, List<String> ingredients, List<String> directions) {
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

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setRecipeName(String recipeName){
        this.recipeName = recipeName;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    public void setIngredients(List<String> ingredients) {
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
        for (int i = 0; i < this.ingredients.size(); i++){
            stringBuilder.append((i+1) + ": " + ingredients.get(i) + "\n");
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
