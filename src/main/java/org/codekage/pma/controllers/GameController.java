package org.codekage.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codekage.pma.entities.Question;
import org.codekage.pma.model.HelloMessage;
import org.codekage.pma.services.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {

    final String HOME_PAGE = "game/home";
    final QuizService quizService;

    public GameController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping()
    public String displayGame(Model model) {
        model.addAttribute("pageTitle", "Game");
        model.addAttribute("message", "Game Home Page");
        return HOME_PAGE;
    }

    @GetMapping("/quiz")
    public String displayQuiz(Model model, HelloMessage message) throws JsonProcessingException {
            var quiz = quizService.getQuizQuestions();
            var objectMapper = new ObjectMapper();
            var quizJson = objectMapper.writeValueAsString(quiz);
            model.addAttribute("pageTitle", "Quiz");
            model.addAttribute("questions", quizJson);
        return "game/quiz";
    }

    @GetMapping("/add-question")
    public String displayAddQuestion(Model model, HelloMessage message) {
        model.addAttribute("pageTitle", "Add Question");
        model.addAttribute("question", new Question());
        return "game/add-question";
    }

    @PostMapping("/save-question")
    public String saveQuestion(Question question, Model model) {
        quizService.saveQuestion(question);
        return "redirect:/game";
    }
}
