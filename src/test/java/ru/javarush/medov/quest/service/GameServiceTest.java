package ru.javarush.medov.quest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.javarush.medov.quest.entity.Answer;
import ru.javarush.medov.quest.entity.Question;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    GameService gameService = new GameService("questions.json");
    Question question = new Question();

    {
        Answer answer1 = new Answer();
        answer1.setNextQuestionId(2);
        answer1.setText("открыть дверь");
        Answer answer2 = new Answer();
        answer2.setNextQuestionId(3);
        answer2.setText("осмотреть комнату");
        Answer answer3 = new Answer();
        answer3.setNextQuestionId(7);
        answer3.setText("ущипнуть себя");
        question.setId(1L);
        question.setAnswers(List.of(answer1, answer2, answer3));
        question.setText("ты проснулся в пустой темной комнате. Ты замечаешь приоткрытую дверь, откуда едва заметно пробивается поток бледного света.");
        question.setImagePath("/img/mainPage.jpg");
    }

    @Test
    public void shouldReturnQuestionById() {
        Assertions.assertEquals(question, gameService.getQuestionById(1L));
    }

    @Test
    public void shouldReturnNullWhenSearchQuestionWithWrongId() {
        Assertions.assertNull(gameService.getQuestionById(100L));
    }

    @Test
    public void shouldNotReturnEqualQuestion() {
        Assertions.assertNotEquals(question, gameService.getQuestionById(2L));
    }


    @Test
    public void shouldReturnAnswersByQuestionId() {
        Assertions.assertEquals(question.getAnswers(), gameService.getAnswersByQuestionId(1L));
    }

    @Test
    public void shouldReturnQuestionTextById() {
        Assertions.assertEquals(question.getText(), gameService.getQuestionTextById(1L));
    }

    @Test
    public void shouldThrownNPEWhenSearchQuestionTextByAbsentId() {
        Assertions.assertThrows(NullPointerException.class, () -> gameService.getQuestionTextById(100L));
    }

    @Test
    public void shouldReturnNextQuestionIdByAnswer() {
        Assertions.assertEquals(
                question.getAnswers().get(0).getNextQuestionId(), gameService.getNextQuestionIdByAnswer(1L, 0)
        );
    }

    @Test
    public void shouldThrownNPEWhenSearchNextQuestionIdByAnswer() {
        Assertions.assertThrows(NullPointerException.class, () -> gameService.getNextQuestionIdByAnswer(100L, 0));
    }

    @Test
    public void shouldReturnImagePathByQuestionId() {
        Assertions.assertEquals(question.getImagePath(), gameService.getImageByQuestionId(1L));
    }

    @Test
    public void shouldReturnNPEWhenSearchImagePathByAbsentQuestionId() {
        Assertions.assertThrows(NullPointerException.class, () -> gameService.getImageByQuestionId(100L));
    }

    @Test
    public void shouldReturnRuntimeExceptionWhenTryingToOpenWrongJsonFile() {
        Assertions.assertThrows(RuntimeException.class, () -> new GameService("questions_wrong.json"));
    }
}