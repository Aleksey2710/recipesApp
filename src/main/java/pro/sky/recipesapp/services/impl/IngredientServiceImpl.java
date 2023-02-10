package pro.sky.recipesapp.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pro.sky.recipesapp.model.Ingredient;
import pro.sky.recipesapp.model.Recipe;
import pro.sky.recipesapp.services.FileIngredientService;
import pro.sky.recipesapp.services.FileRecipeService;
import pro.sky.recipesapp.services.IngredientService;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Бизнес-логика для ингредиентов.
 */

@Service
public class IngredientServiceImpl implements IngredientService {
    private final FileIngredientService fileIngredientService;

    public IngredientServiceImpl(FileIngredientService fileIngredientService) {
        this.fileIngredientService = fileIngredientService;
    }

    private long idIngredient = 1L;

    private HashMap<Long, Ingredient> ingredientMap = new HashMap<>();

    @PostConstruct
    private void init() {
        readFromFile();
    }

    @Override
    public long addNewIngredient(Ingredient ingredient) { //Создаем новый ингредиент.
        ingredientMap.put(idIngredient, ingredient);
        saveToFile();
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
            saveToFile();
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

    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredientMap);
            fileIngredientService.saveToFile(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {
        try {
            String json = fileIngredientService.readFromFile();
            ingredientMap = new ObjectMapper().readValue(json, new TypeReference<HashMap<Long, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
