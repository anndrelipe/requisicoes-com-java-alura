import br.com.alura.exercicios.classes.Meal;
import br.com.alura.exercicios.classes.Movie;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Meal first_recipe = new Meal("Sushi");
        first_recipe.searchForInfos();
    }
}