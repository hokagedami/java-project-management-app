package org.codekage.pma.controllers;

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
    public String displayHome(Model model) {
        var employees = employeeRepository.findAll().stream().toList();
        var projects = projectRepository.findAll().stream().toList();
        model.addAllAttributes(Map.of(
                "employees", employees,
                "projects", projects
        ));
        return HOME_PAGE;
    }
}
