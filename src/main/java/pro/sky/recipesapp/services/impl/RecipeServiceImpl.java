package pro.sky.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipesapp.model.Recipe;
import pro.sky.recipesapp.services.RecipeService;

import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    private long idRecipe = 1L;

    private static final Map<Long, Recipe> recipeMap = new TreeMap<>();


    @Override
    public long addNewRecipe(Recipe recipe) {
        recipeMap.put(idRecipe, recipe);
        return idRecipe++;
    }

    @Override
    public Recipe getRecipeById(long idRecipe) {
            return recipeMap.get(idRecipe);
    }

}
