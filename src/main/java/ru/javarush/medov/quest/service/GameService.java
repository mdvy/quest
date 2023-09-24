package ru.javarush.medov.quest.service;

import lombok.Data;
import ru.javarush.medov.quest.entity.Answer;
import ru.javarush.medov.quest.entity.Question;
import ru.javarush.medov.quest.repository.QuestionRepository;
import java.util.List;
import java.util.Map;

@Data
public class GameService {


    private static final QuestionRepository repository = new QuestionRepository();

    public Map<Long, Question> getAllQuestions(){
        return repository.getQuestionMap();
    }

    public Question getQuestionById(Long id){
            return repository.getQuestionMap().get(id);
    }

    public List<Answer> getAnswersByQuestionId(Long id){
        return getQuestionById(id).getAnswers();
    }

    public Question getNextQuestionByAnswer(Long id, int answerId){
        return getQuestionById(getAnswersByQuestionId(id).get(answerId).getNextQuestionId());
    }

    public String getQuestionTextById(Long id){
        return getQuestionById(id).getText();
    }


    public Long getNextQuestionIdByAnswer(Long currentQuestionId, int answerId) {
        return getQuestionById(currentQuestionId).getAnswers().get(answerId).getNextQuestionId();
    }

    public String getImageByQuestionId(Long id){
        return getQuestionById(id).getImagePath();
    }
}
