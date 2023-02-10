package pro.sky.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipesapp.model.Ingredient;
import pro.sky.recipesapp.services.IngredientService;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * Бизнес-логика для ингредиентов.
 */

@Service
public class IngredientServiceImpl implements IngredientService {
    private long idIngredient = 1L;

    private final Map<Long, Ingredient> ingredientMap = new TreeMap<>();


    @Override
    public long addNewIngredient(Ingredient ingredient) { //Создаем новый ингредиент.
        ingredientMap.put(idIngredient, ingredient);
        return idIngredient++;
    }

    @Override
    public Ingredient getIngredientById(long idIngredient) { //Получаем ингредиент по его id.
        return ingredientMap.get(idIngredient);
    }

    @Override
    public Collection<Ingredient> getAllIngredients() { //Получаем список всех ингредиентов.
        return ingredientMap.values();
    }

    @Override
    public Ingredient editIngredient(long idIngredient,
                                     Ingredient ingredient) { //Редактируем ингредиент по его id.
        if (ingredientMap.containsKey(idIngredient)) {
            ingredientMap.put(idIngredient, ingredient);
            return ingredient;
        }
        return null;
    }

    @Override
    public boolean deleteIngredient(long idIngredient) { //Удаляем ингредиент по его id.
        if (ingredientMap.containsKey(idIngredient)) {
            ingredientMap.remove(idIngredient);
            return true;
        }
        return false;
    }
}
