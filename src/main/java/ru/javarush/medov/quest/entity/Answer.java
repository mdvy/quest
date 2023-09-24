package ru.javarush.medov.quest.entity;

import lombok.Data;

@Data
public class Answer {
    private long id;

    public Answer() {
    }

    private long nextQuestionId;
    private String text;

    public Answer(String text) {
        this.text = text;
    }
}
