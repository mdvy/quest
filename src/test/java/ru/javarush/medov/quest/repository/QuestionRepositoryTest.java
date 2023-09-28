package ru.javarush.medov.quest.repository;

import org.junit.jupiter.api.Test;
import ru.javarush.medov.quest.entity.Question;

import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuestionRepositoryTest {

    @Test
    public void wrongArgumentThrowsRuntimeException() {
        assertThrows(RuntimeException.class, () -> new QuestionRepository(""));
    }

    @Test
    public void wrongJsonFileThrowsRuntimeException() {
        assertThrows(RuntimeException.class, () -> new QuestionRepository("questions_wrong.json"));
    }

    @Test
    public void shouldReturnMap() {

        QuestionRepository repository = new QuestionRepository("questions.json");
        try {
            Field field = repository.getClass().getDeclaredField("questionMap");
            field.setAccessible(true);
            Map<Long, Question> questionMap = (Map<Long, Question>) field.get(repository);
            assertEquals(questionMap, repository.getQuestionMap());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}