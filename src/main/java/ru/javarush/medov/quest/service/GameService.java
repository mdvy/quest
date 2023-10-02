package ru.javarush.medov.quest.service;

import lombok.Data;
import ru.javarush.medov.quest.entity.Answer;
import ru.javarush.medov.quest.entity.Question;
import ru.javarush.medov.quest.repository.QuestionRepository;

import java.util.List;

@Data
public class GameService {

    private final QuestionRepository repository;

    public GameService(String jsonFileName) {
        repository = new QuestionRepository(jsonFileName);
    }

    public Question getQuestionById(Long id) {
        return repository.getQuestionMap().get(id);
    }

    public List<Answer> getAnswersByQuestionId(Long id) {
        return getQuestionById(id).getAnswers();
    }


    public String getQuestionTextById(Long id) {
        return getQuestionById(id).getText();
    }


    public Long getNextQuestionIdByAnswer(Long currentQuestionId, int answerId) {
        return getQuestionById(currentQuestionId).getAnswers().get(answerId).getNextQuestionId();
    }

    public String getImageByQuestionId(Long id) {
        return "/img/" + getQuestionById(id).getImagePath();
    }
}
