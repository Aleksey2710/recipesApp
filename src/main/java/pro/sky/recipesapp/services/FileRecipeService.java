package pro.sky.recipesapp.services;

public interface FileRecipeService {
    boolean saveToFile(String json);

    String readFromFile();
}
