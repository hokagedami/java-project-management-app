package org.codekage.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codekage.pma.model.HelloMessage;
import org.codekage.pma.model.ResponseObject;
import org.codekage.pma.services.QuizService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    final String HOME_PAGE = "game/home";
    final QuizService quizService;

    public GameController(QuizService quizService) {
        this.quizService = quizService;
    }

    @MessageMapping("/live")
    @SendTo("/topic/game")
    public ResponseObject<String> game(String message) {
        return new ResponseObject<>(message);
    }

    @GetMapping("/game-home")
    public String displayGame(Model model, HelloMessage message) {
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


}
