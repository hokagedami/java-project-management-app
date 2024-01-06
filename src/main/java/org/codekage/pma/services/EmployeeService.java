package org.codekage.pma.services;

import org.codekage.pma.entities.Employee;
import org.codekage.pma.repository.EmployeeRepository;
import org.codekage.pma.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public EmployeeService(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    public Employee getEmployeeById(long id) {
        var employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Iterable<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Iterable<Employee> getAllByProjectId(long projectId) {
        return employeeRepository.findAllOnProjectByProjectId(projectId);
    }

    // add employee to a project using the join table
    public void addEmployeeToProject(long employeeId, long projectId) {
        var employee = employeeRepository.findById(employeeId);
        var project = projectRepository.findById(projectId);
        if(employee.isPresent() && project.isPresent()) {
            var employeeObj = employee.get();
            var projectObj = project.get();
            employeeObj.getProjects().add(projectObj);
            employeeRepository.save(employeeObj);
        }
    }

    // remove employee from a project using the join table
    public boolean removeEmployeeFromProject(long employeeId, long projectId) {
        var employee = employeeRepository.findById(employeeId);
        var project = projectRepository.findById(projectId);
        if(employee.isPresent() && project.isPresent()) {
            var employeeObj = employee.get();
            var projectObj = project.get();
            employeeObj.getProjects().remove(projectObj);
            employeeRepository.save(employeeObj);
            return true;
        }
        return false;
    }

    public Iterable<Employee> getEmployeesByIds(Iterable<Long> ids) {
        return employeeRepository.findAllById(ids);
    }

}
