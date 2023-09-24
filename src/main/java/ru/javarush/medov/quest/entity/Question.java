package ru.javarush.medov.quest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data

public class Question {
    private long id;
    private String text;

    private List<Answer> answers;
    private String imagePath;

    public Question() {
    }

    public Question(long id, String text) {
        this.text = text;
        this.id = id;
    }
}
