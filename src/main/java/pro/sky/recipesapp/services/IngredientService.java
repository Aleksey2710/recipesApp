package pro.sky.recipesapp.services;

import pro.sky.recipesapp.model.Ingredient;

public interface IngredientService {
    void addNewIngredient(Ingredient ingredient);

    Ingredient getIngredientById(long idIngredient);
}
