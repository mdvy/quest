package ru.javarush.medov.quest.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    Answer answer = new Answer();

    @Test
    void shouldReturnNextQuestion() {
        answer.setNextQuestionId(1);
        assertEquals(1, answer.getNextQuestionId());
    }

    @Test
    void shouldReturnText() {
        answer.setText("text");
        assertEquals("text", answer.getText());
    }
}