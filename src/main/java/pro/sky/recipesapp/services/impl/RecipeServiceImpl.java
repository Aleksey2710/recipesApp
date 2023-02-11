package pro.sky.recipesapp.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pro.sky.recipesapp.model.Recipe;
import pro.sky.recipesapp.services.FileService;
import pro.sky.recipesapp.services.RecipeService;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Бизнес-логика для рецептов.
 */

@Service
public class RecipeServiceImpl implements RecipeService {

    private final FileRecipeServiceImpl fileRecipeService;

    public RecipeServiceImpl(FileRecipeServiceImpl fileRecipeService) {
        this.fileRecipeService = fileRecipeService;
    }

    private long idRecipe = 1L;

    private Map<Long, Recipe> recipeMap = new HashMap<>();


    @PostConstruct
    private void init() {
        readFromFile();
    }

    @Override
    public long addNewRecipe(Recipe recipe) { //Создаем новый рецепт.
        recipeMap.put(idRecipe, recipe);
        saveToFile();
        return idRecipe++;
    }

    @Override
    public Recipe getRecipeById(long idRecipe) { //Получаем рецепт по его id.
        return recipeMap.get(idRecipe);
    }

    @Override
    public Collection<Recipe> getAllRecipes() { //Получаем список всех рецептов.
        return recipeMap.values();

    }

    @Override
    public Recipe editRecipeById(long idRecipe, Recipe recipe) { //Редактируем рецепт по его id.
        if (recipeMap.containsKey(idRecipe)) {
            recipeMap.put(idRecipe, recipe);
            saveToFile();
            return recipe;
        }
        return null;
    }

    @Override
    public boolean deleteRecipe(long idRecipe) { //Удаляем рецепт по его id.
        if (recipeMap.containsKey(idRecipe)) {
            recipeMap.remove(idRecipe);
            saveToFile();
            return true;
        }
        return false;
    }

    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipeMap);
            fileRecipeService.saveToFile(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {
        try {
            String json = fileRecipeService.readFromFile();
            recipeMap = new ObjectMapper().readValue(json, new TypeReference<HashMap<Long, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
