package org.codekage.pma.services;

import org.codekage.pma.entities.Project;
import org.codekage.pma.model.ProjectToSave;
import org.codekage.pma.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final EmployeeService employeeService;

    public ProjectService(ProjectRepository projectRepository, EmployeeService employeeService) {
        this.projectRepository = projectRepository;
        this.employeeService = employeeService;
    }

    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    public Iterable<Project> getAll() {
        return projectRepository.findAll();
    }

    public Project getProjectById(long id) {
        var project = projectRepository.findById(id);
        return project.orElse(null);
    }

    public Iterable<Project> getAllByEmployeeId(long employeeId) {
        return projectRepository.findAllProjectByEmployeeId(employeeId);
    }

    public boolean addNewProject(ProjectToSave projectToSave) {
        if(projectToSave == null
                || projectToSave.getEmployees() == null
                || projectToSave.getEmployees().isEmpty()) {
            return false;
        }
        var employees = employeeService.getEmployeesByIds(projectToSave.getEmployees());
        if (employees != null && ((Collection<?>)employees).size() == projectToSave.getEmployees().size()) {
            var project = new Project(projectToSave.getName(), projectToSave.getStage(), projectToSave.getDescription());
            projectRepository.save(project);
            for (var employee : employees) {
                employeeService.addEmployeeToProject(employee.getEmployeeId(), project.getProjectId());
            }
            return true;
        }
        return false;
    }
}
