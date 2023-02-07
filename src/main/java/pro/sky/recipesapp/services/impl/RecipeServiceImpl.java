package pro.sky.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipesapp.model.Recipe;
import pro.sky.recipesapp.services.RecipeService;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * Бизнес-логика для рецептов.
 */

@Service
public class RecipeServiceImpl implements RecipeService {
    private static long idRecipe = 1L;

    private static Map<Long, Recipe> recipeMap = new TreeMap<>();


    @Override
    public long addNewRecipe(Recipe recipe) { //Создаем новый рецепт.
        recipeMap.getOrDefault(idRecipe, recipe);
        return idRecipe++;
    }

    @Override
    public Recipe getRecipeById(long idRecipe) { //Получаем рецепт по его id.
        try {
            return recipeMap.get(idRecipe);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Collection<Recipe> getAllRecipes() { //Получаем список всех рецептов.
        return recipeMap.values();
    }

    @Override
    public Recipe editRecipeById(long idRecipe, Recipe recipe) { //Редактируем рецепт по его id.
        if (recipeMap.containsKey(idRecipe)) {
            recipeMap.put(idRecipe, recipe);
            return recipe;
        }
        return null;
    }

    @Override
    public boolean deleteRecipe(long idRecipe) { //Удаляем рецепт по его id.
        if (recipeMap.containsKey(idRecipe)) {
            recipeMap.remove(idRecipe);
            return true;
        }
        return false;
    }
}
