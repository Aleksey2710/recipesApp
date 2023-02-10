package pro.sky.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Описание ингредиентов.
 */
@Data
@AllArgsConstructor
public class Ingredient {
    private String nameIngredient;
    private int countIngredients;
    private String countMeasurement;
}
