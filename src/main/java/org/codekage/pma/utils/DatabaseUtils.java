package org.codekage.pma.utils;

import org.codekage.pma.entities.Employee;
import org.codekage.pma.entities.Project;
import org.codekage.pma.entities.enums.Stage;
import org.codekage.pma.model.ProjectToSave;
import org.codekage.pma.services.EmployeeService;
import org.codekage.pma.services.ProjectService;

import java.util.ArrayList;

public class DatabaseUtils {
    public static void populateDatabase(ProjectService projectService, EmployeeService employeeService) {
        var employees = new ArrayList<Employee>();
        var projects = new ArrayList<Project>();
        employees.add(new Employee("John", "Doe", "john_doe@email.com"));
        employees.add(new Employee("Mike", "Smith", "mike_smith@email.com"));
        employees.add(new Employee("Jane", "Doe", "jane_doe@email.com"));
        projects.add(new Project("Project 1", Stage.NOT_STARTED, "This is project 1 description"));
        projects.add(new Project("Project 2", Stage.IN_PROGRESS, "This is project 2 description"));
        projects.add(new Project("Project 3", Stage.COMPLETED, "This is project 3 description"));
        projects.add(new Project("Project 4", Stage.NOT_STARTED, "This is project 4 description"));

        for (Employee employee : employees) {
            employeeService.saveEmployee(employee);
        }

        for (Project project : projects) {
            projectService.saveProject(project);
            // two random index from 0 to 2 inclusive. ensure they are not the same
            var randomIndexOne = (int) (Math.random() * 3);
            var randomIndexTwo = (int) (Math.random() * 3);
            while (randomIndexOne == randomIndexTwo) {
                randomIndexTwo = (int) (Math.random() * 3);
            }
            int finalRandomIndexTwo = randomIndexTwo;
            var projectToSave = new ProjectToSave(project.getName(), project.getStage(), project.getDescription(),
                    new ArrayList<>() {
                        {
                            add(employees.get(randomIndexOne).getEmployeeId());
                            add(employees.get(finalRandomIndexTwo).getEmployeeId());
                        }
                    });
            projectService.saveProjectWithAssignedEmployees(projectToSave);
        }
    }
}
