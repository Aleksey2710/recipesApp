package pro.sky.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipesapp.services.ProjectService;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

@Service
public class ProjectServiceImpl implements ProjectService {

    public static final String STUDENT_NAME = "Aleksey";
    public static final String PROJECT_NAME = "Рецепты";
    public static final String START_VALUE = "Приложение запущено!";

    public static final String DATE = LocalDate.of(2023, 2, 3).toString();

//    public static final String DESCRIPTION = ;
            /*"Рецепты содержат в себе следующую информацию:\n" +
            " - описание приготовляемого блюда;\n" +
            " - ингредиенты для данного блюда;\n" +
            " - пропорции;\n" +
            " - способ приготовления.";*/


    @Override
    public String getInfoProject() throws FileNotFoundException {
        return "Имя студента: " + STUDENT_NAME + "\n" +
                "Название проекта: " + PROJECT_NAME + "\n" +
                "Дата создания: " + DATE + "\n" +
                "Описание проекта: " + getProjectDescription();
    }

    @Override
    public String getStarting() {
        return START_VALUE;
    }

    @Override
    public String getProjectDescription() throws FileNotFoundException {
        String separator = File.separator;
        String path = "C:" + separator + "Users" + separator + "User" + separator +
                "IdeaProjects" + separator + "RecipesApp" + separator + "src" + separator + "main"
                + separator + "java" + separator + "pro" + separator + "sky" + separator + "recipesapp"
                + separator + "ReadMe.md";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String s = "";
        while (scanner.hasNextLine()) {
            s += scanner.nextLine();
        }
        scanner.close();
        return s;
    }
}
