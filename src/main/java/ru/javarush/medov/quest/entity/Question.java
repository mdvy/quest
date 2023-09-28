package ru.javarush.medov.quest.entity;

import lombok.Data;

import java.util.List;

@Data

public class Question {
    private long id;
    private String text;
    private List<Answer> answers;
    private String imagePath;
}
