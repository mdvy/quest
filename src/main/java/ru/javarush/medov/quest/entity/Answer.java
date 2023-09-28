package ru.javarush.medov.quest.entity;

import lombok.Data;

@Data
public class Answer {
    private long nextQuestionId;
    private String text;
}
