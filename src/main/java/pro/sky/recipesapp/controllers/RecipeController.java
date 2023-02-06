package pro.sky.recipesapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.recipesapp.services.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private RecipeService recipeService;
}
