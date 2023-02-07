package pro.sky.recipesapp.services;

import pro.sky.recipesapp.model.Recipe;

import java.util.Collection;

public interface RecipeService {

    long addNewRecipe(Recipe recipe);

    Recipe getRecipeById(long idRecipe);

    Collection<Recipe> getAllRecipes();

    Recipe editRecipeById(long idRecipe, Recipe recipe);

    boolean deleteRecipe(long idRecipe);
}
