package pro.sky.recipesapp.services;

import pro.sky.recipesapp.model.Recipe;

public interface RecipeService {

    void addNewRecipe(Recipe recipe);

    Recipe getRecipeById(long idRecipe);
}
