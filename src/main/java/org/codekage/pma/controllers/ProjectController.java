package org.codekage.pma.controllers;

import org.codekage.pma.entities.enums.Stage;
import org.codekage.pma.model.ProjectToSave;
import org.codekage.pma.services.EmployeeService;
import org.codekage.pma.services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/projects")
public class ProjectController {

    final String NEW_PROJECT_PAGE = "projects/new-project";
    final String PROJECTS_HOME = "projects/home";
    final String PROJECT_DETAILS = "projects/single-project";
    final ProjectService projectService;
    final EmployeeService employeeService;

    public ProjectController(ProjectService projectService, EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }


    @GetMapping()
    public String displayProjects(@RequestParam(required = false) String errorMessage, Model model) {
        model.addAttribute("projects", projectService.getAll());
        model.addAttribute("errorMessage", errorMessage);
        return PROJECTS_HOME;
    }
    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        model.addAttribute("projectToSave", new ProjectToSave());
        model.addAttribute("allEmployees", employeeService.getAll());
        model.addAttribute("stages", Stage.values());
        return NEW_PROJECT_PAGE;
    }

    @PostMapping("/save")
    public String createProject(ProjectToSave project, RedirectAttributes redirectAttributes) {
        var saved = projectService.saveProjectWithAssignedEmployees(project);
        if (!saved) {
            redirectAttributes.addAttribute("errorMessage", "Project not saved. Please try again.");
        }
        return "redirect:/projects";
    }

    // view single project details
    @GetMapping("/{id}")
    public String displayProjectDetails(Model model, RedirectAttributes redirectAttributes, @PathVariable Long id) {
        var project = projectService.getProjectById(id);
        if (project != null) {
            model.addAttribute("project", project);
            return PROJECT_DETAILS;
        }
        redirectAttributes.addAttribute("errorMessage", "Project not found.");
        return "redirect:/projects";
    }
}
