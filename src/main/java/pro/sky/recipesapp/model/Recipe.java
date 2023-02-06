package pro.sky.recipesapp.model;
/**
 * Описание рецептов.
 */

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Recipe {
    private String nameRecipe;
    private int cookingTime;
    private String timeMeasurement;
    private List<Ingredient> ingredients;
    private List<String> steps;
}
