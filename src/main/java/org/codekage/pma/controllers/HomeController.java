package org.codekage.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codekage.pma.entities.enums.Stage;
import org.codekage.pma.repository.EmployeeRepository;
import org.codekage.pma.repository.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {
    final String HOME_PAGE = "main/home";
    final ProjectRepository projectRepository;
    final EmployeeRepository employeeRepository;

    public HomeController(ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        var employees = employeeRepository.findAllWithProjects();
        var projects = projectRepository.findAll().stream().toList();
        var projectStages = projectRepository.findProjectStagesCount();

        // convert projectStages to json
        var objectMapper = new ObjectMapper();
        var jsonString = objectMapper.writeValueAsString(projectStages);
        var stagesJson = objectMapper.writeValueAsString(Stage.getStages());


        model.addAllAttributes(Map.of(
                "employees", employees,
                "projects", projects,
                "chartData", jsonString,
                "stages", stagesJson,
                "pageTitle", "Home"
        ));
        return HOME_PAGE;
    }
}
