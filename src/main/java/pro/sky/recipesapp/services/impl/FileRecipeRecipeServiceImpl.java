package pro.sky.recipesapp.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pro.sky.recipesapp.services.FileRecipeService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Бизнес-логика для работы с файлами (рецептов).
 */
@Service
public class FileRecipeRecipeServiceImpl implements FileRecipeService {
    @Value("${pathToDataRecipeFile}")
    private String dataFilePath;
    @Value("${nameOfDataRecipeFile}")
    private String dataFileName;

    /**
     * Сохранение рецепта в файл
     *
     * @param json файл для сохранения (записи)
     * @return подтверждение сохранения рецепта в файл
     */
    @Override
    public boolean saveToFile(String json) {
        try {
            Files.writeString(Path.of(dataFilePath, dataFileName), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Читаем (получаем) рецепт из файла
     *
     * @return Получаем прочитанный файл
     */
    @Override
    public String readFromFile() {
        try {
            return Files.readString(Path.of(dataFilePath, dataFileName));
        } catch (IOException e) {
            e.printStackTrace();
            return "Не удалось прочитать файл!";
        }
    }
}
