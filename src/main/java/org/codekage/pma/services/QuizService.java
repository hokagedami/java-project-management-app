package org.codekage.pma.services;

import org.codekage.pma.model.QuizQuestion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QuizService {

    public ArrayList<QuizQuestion> getQuizQuestions() {
        var quiz = new ArrayList<QuizQuestion>();
        quiz.add(new QuizQuestion("What is the capital of France?", "Geography", new String[]{"Paris", "London", "Berlin", "Madrid"}, false, null));
        quiz.add(new QuizQuestion("What is the capital of Spain?", "Geography", new String[]{"Paris", "London", "Berlin", "Madrid"}, false, null));
        return quiz;
    }
}
