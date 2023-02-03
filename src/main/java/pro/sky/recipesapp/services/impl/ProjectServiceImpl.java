package pro.sky.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipesapp.services.ProjectService;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class ProjectServiceImpl implements ProjectService {

    public static final String STUDENT_NAME = "Aleksey";
    public static final String PROJECT_NAME = "Рецепты";
    public static final String START_VALUE = "Приложение запущено!";

    public static final String DATE = LocalDate.of(2023,2,3).toString();
    public static final String DESCRIPTION = "Рецепты содержат в себе следующую информацию:\n" +
            " - описание приготовляемого блюда;\n" +
            " - ингредиенты для данного блюда;\n" +
            " - пропорции;\n" +
            " - способ приготовления.";


    @Override
    public String getInfoProject() {
        return "Имя студента: " + STUDENT_NAME + "\n" +
                "Название проекта: " + PROJECT_NAME + "\n" +
                "Дата создания: " + DATE + "\n" +
                "Описание проекта: " + DESCRIPTION;
    }

    @Override
    public String getStarting() {
        return START_VALUE;
    }
}
