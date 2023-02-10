package pro.sky.recipesapp.services.impl;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import pro.sky.recipesapp.services.FileRecipeService;

public class FileRecipeServiceImpl implements FileRecipeService {
    @Value("${pathToDataRecipeFile}")
    private String dataFilePath;
    @Value("${nameOfDataRecipeFile}")
    private String dataFileName;




}
