package pro.sky.recipesapp.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;

public interface FileService {
    boolean saveToFile(String json);

    String readFromFile();

    boolean cleanDataFile();

    File getDataFile();

    void upLoadDataRecipeFile(MultipartFile file);
}
