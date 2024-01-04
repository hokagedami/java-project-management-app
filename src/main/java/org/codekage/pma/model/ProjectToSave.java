package org.codekage.pma.model;

import org.codekage.pma.entities.enums.Stage;

import java.util.List;

public class ProjectToSave {
    private String name;
    private Stage stage;
    private String description;

    private List<Long> employees;

    public ProjectToSave() {
    }

    public ProjectToSave(String name, Stage stage, String description, List<Long> employees) {
        this.name = name;
        this.stage = stage;
        this.description = description;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public Stage getStage() {
        return stage;
    }

    public String getDescription() {
        return description;
    }

    public List<Long> getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmployees(List<Long> employees) {
        this.employees = employees;
    }
}
