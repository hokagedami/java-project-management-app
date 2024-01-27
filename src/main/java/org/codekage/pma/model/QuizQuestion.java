package org.codekage.pma.model;

public class QuizQuestion {
    private String question;
    private String[] options;
    private String category;

    private boolean hasImage;
    private String image;

    public QuizQuestion(String question, String category, String[] options, boolean hasImage, String image) {
        this.question = question;
        this.options = options;
        this.category = category;
        this.hasImage = hasImage;
        this.image = image;
    }

    public QuizQuestion() {
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
