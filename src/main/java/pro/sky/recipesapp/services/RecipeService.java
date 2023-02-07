package pro.sky.recipesapp.services;

import pro.sky.recipesapp.model.Recipe;

public interface RecipeService {

    long addNewRecipe(Recipe recipe);

    Recipe getRecipeById(long idRecipe);
}
