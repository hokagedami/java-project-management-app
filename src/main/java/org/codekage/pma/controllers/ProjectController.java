package org.codekage.pma.controllers;

import org.codekage.pma.entities.Project;
import org.codekage.pma.repository.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    final String NEW_PROJECT_PAGE = "projects/new-project";
    final String PROJECTS_HOME = "projects/home";
    final
    ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping()
    public String displayProjects(Model model) {
        model.addAttribute("projects", projectRepository.findAll());
        return PROJECTS_HOME;
    }
    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return NEW_PROJECT_PAGE;
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        projectRepository.save(project); // save to database
        return "redirect:/projects";
    }
}
