package pro.sky.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipesapp.model.Ingredient;
import pro.sky.recipesapp.services.IngredientService;

import java.util.Map;
import java.util.TreeMap;

@Service
public class IngredientServiceImpl implements IngredientService {
    private static long idIngredient = 1L;

    private static Map<Long, Ingredient> ingredientMap = new TreeMap<>();


    @Override
    public long addNewIngredient(Ingredient ingredient) {
        ingredientMap.getOrDefault(idIngredient, ingredient);
        return idIngredient++;
    }

    @Override
    public Ingredient getIngredientById(long idIngredient) {
        return ingredientMap.get(idIngredient);
    }
}
