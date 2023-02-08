package pro.sky.recipesapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipesapp.model.Recipe;
import pro.sky.recipesapp.services.RecipeService;

import java.util.Collection;

/**
 * Контроллер для рецептов.
 */

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Long> addNewRecipe(@RequestBody Recipe recipe) { //Создаем новый рецепт.
        long id = recipeService.addNewRecipe(recipe);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) { //Получаем рецепт по его id.
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @GetMapping
    public ResponseEntity<Collection<Recipe>> getAllRecipes() { //Получаем список всех рецептов.
        Collection<Recipe> allRecipes = recipeService.getAllRecipes();
        return ResponseEntity.ok(allRecipes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable long id,
                                             @RequestBody Recipe recipe) {//Редактируем рецепт по его id.
        recipe = recipeService.editRecipeById(id, recipe);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable long id) { //Удаляем рецепт по его id.
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
