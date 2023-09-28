package ru.javarush.medov.quest.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class QuestionTest {

    Question question = new Question();

    @Test
    void shouldReturnId() {
        question.setId(100);
        Assertions.assertEquals(100, question.getId());
    }

    @Test
    void shouldReturnText() {
        question.setText("some text");
        Assertions.assertEquals("some text", question.getText());
    }

    @Test
    void shouldReturnAnswers() {
        Answer answer = new Answer();
        answer.setText("answer text");
        answer.setNextQuestionId(10);
        question.setAnswers(List.of(answer, answer));
        Assertions.assertEquals(List.of(answer, answer), question.getAnswers());
    }

    @Test
    void shouldReturnPath() {
        question.setImagePath("some path");
        Assertions.assertEquals("some path", question.getImagePath());
    }
}