import java.io.IOException;

public interface Menu {

    void show();

    void createRecipe(Recipe recipe) throws Exception;

    Recipe retrieveRecipe(String recipeName) throws Exception;

    void show_interactive(String recipeName) throws Exception;

    void deleteRecipe(String lasagna) throws IOException;
}
