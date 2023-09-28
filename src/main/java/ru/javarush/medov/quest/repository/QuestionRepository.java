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
    private final Map<Long, Question> questionMap;

    public QuestionRepository(String jsonFileName) {

        StringBuilder jsonData = new StringBuilder();
        try (FileReader fr = new FileReader(Objects.requireNonNull(getClass().getClassLoader().getResource(jsonFileName)).getFile())) {
            while (fr.ready()) jsonData.append((char)
                    fr.read());
        } catch (IOException e) {
            throw new RuntimeException(jsonFileName + " can't be read");
        }

        ObjectMapper mapper = new ObjectMapper();

        Question[] questions;
        try {
            questions = mapper.readValue(jsonData.toString(), Question[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(jsonFileName + " has errors");
        }

        questionMap = Arrays.stream(questions)
                .collect(Collectors.toMap(Question::getId, Function.identity()));
    }

    public Map<Long, Question> getQuestionMap() {
        return questionMap;
    }
}

