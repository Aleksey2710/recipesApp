package pro.sky.recipesapp.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pro.sky.recipesapp.services.FileService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Бизнес-логика для работы с файлами (ингредиентов).
 */
@Service
public class FileIngredientServiceImpl implements FileService {
    @Value("${pathToDataIngredientFile}")
    private String dataFilePath;
    @Value("${nameOfDataIngredientFile}")
    private String dataFileName;

    /**
     * Сохранение ингредиента в файл
     *
     * @param json файл для сохранения (записи)
     * @return подтверждение сохранения ингредиента в файл
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
     * Читаем (получаем) ингредиент из файла
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
    @Override
    public boolean cleanDataFile() {
        try {
            Path path = Path.of(dataFilePath, dataFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public File getDataFile() {
        return new File(dataFilePath + "/" + dataFileName);
    }

    @Override
    public Path createTempFile(String suffix) {
        try {
            return Files.createTempFile(Path.of(dataFilePath), "tempFile", suffix);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
