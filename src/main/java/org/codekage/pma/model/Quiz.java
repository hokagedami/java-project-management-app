package org.codekage.pma.model;

public class Quiz extends QuizQuestion {
    private String answer;

    public Quiz(String question, String category, String[] options, boolean hasImage, String image, String answer) {
        super(question, category, options, hasImage, image);
        this.answer = answer;
    }

    public Quiz() {
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
