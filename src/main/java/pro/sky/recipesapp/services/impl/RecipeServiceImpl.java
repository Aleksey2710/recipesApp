package pro.sky.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipesapp.model.Recipe;
import pro.sky.recipesapp.services.RecipeService;

import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static long idRecipe = 1L;

    private static Map<Long, Recipe> recipeMap = new TreeMap<>();


    @Override
    public long addNewRecipe(Recipe recipe) {
        recipeMap.getOrDefault(idRecipe, recipe);
        return idRecipe++;
    }

    @Override
    public Recipe getRecipeById(long idRecipe) {
        try {
            return recipeMap.get(idRecipe);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

}
