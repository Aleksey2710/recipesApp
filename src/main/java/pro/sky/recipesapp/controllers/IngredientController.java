package pro.sky.recipesapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipesapp.model.Ingredient;
import pro.sky.recipesapp.model.Recipe;
import pro.sky.recipesapp.services.IngredientService;

import java.util.Collection;

/**
 * Контроллер для ингредиентов.
 */

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public ResponseEntity<Long> addNewIngredient(@RequestBody Ingredient ingredient) { //Создаем новый ингредиент.
        long id = ingredientService.addNewIngredient(ingredient);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable long id) { //Получаем ингредиент по его id.
        Ingredient ingredient = ingredientService.getIngredientById(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping
    public ResponseEntity<Collection<Ingredient>> getAllIngredients() { //Получаем список всех ингредиентов.
        Collection<Ingredient> ingredients = ingredientService.getAllIngredients();
        return ResponseEntity.ok(ingredients);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable long id,
                                                     @RequestBody Ingredient ingredient) { //Редактируем ингредиент по его id.
        ingredient = ingredientService.editIngredient(id, ingredient);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable long id) { //Удаляем ингредиент по его id.
        if (ingredientService.deleteIngredient(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
