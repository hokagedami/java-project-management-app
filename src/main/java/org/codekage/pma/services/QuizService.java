package org.codekage.pma.services;

import org.codekage.pma.entities.Question;
import org.codekage.pma.model.QuizQuestion;
import org.codekage.pma.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QuizService {

    private final QuestionRepository questionRepository;

    public QuizService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public ArrayList<QuizQuestion> getQuizQuestions() {
        var quiz = new ArrayList<QuizQuestion>();
        var questions = questionRepository.findAll();
        for (var question : questions) {
            quiz.add(new QuizQuestion(question.getAsk(), question.getCategory(),
                    new String[]{question.getOption1(), question.getOption2(), question.getOption3(),
                            question.getOption4()}, question.isHasImage(), question.getImage(), question.getAnswer()));
        }
        return quiz;
    }

    public void saveQuestion(Question question) {
        try {
            questionRepository.save(question);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
