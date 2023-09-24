package ru.javarush.medov.quest.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.medov.quest.entity.Question;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QuestionRepository {
    private final Map<Long ,Question> questionMap;

    public QuestionRepository() {

        StringBuilder jsonData = new StringBuilder();
        FileReader fr = null;
        try {
            fr = new FileReader(getClass().getClassLoader().getResource("questions.json").getFile());
            while (fr.ready())
                jsonData.append((char)fr.read());
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper mapper = new ObjectMapper();

        Question[] questions;
        try {
            questions = mapper.readValue(jsonData.toString(), Question[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        questionMap = Arrays.stream(questions)
                .collect(Collectors.toMap(Question::getId, Function.identity()));

        }

    public Map<Long, Question> getQuestionMap() {
        return questionMap;
    }


}

