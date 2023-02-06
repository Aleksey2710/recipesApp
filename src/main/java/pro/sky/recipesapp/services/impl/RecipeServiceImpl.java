package pro.sky.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipesapp.model.Recipe;
import pro.sky.recipesapp.services.RecipeService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    private long idRecipe = 1L;

    private static Map<Long, Recipe> recipeMap = new TreeMap<>();


    @Override
    public void addNewRecipe(Recipe recipe) {
        try {
            recipeMap.getOrDefault(idRecipe++, recipe);
        } catch (Exception e) {
            System.out.println(e);
        }

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
