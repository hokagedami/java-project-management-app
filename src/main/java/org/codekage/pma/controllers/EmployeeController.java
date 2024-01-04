package org.codekage.pma.controllers;

import org.codekage.pma.entities.Employee;
import org.codekage.pma.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    final String NEW_EMPLOYEE_PAGE = "employees/new-employee";
    final String EMPLOYEES_HOME = "employees/home";

    final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping()
    public String displayEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return EMPLOYEES_HOME;
    }
    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return NEW_EMPLOYEE_PAGE;
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model) {
        employeeRepository.save(employee); // save to database
        return "redirect:/employees";
    }
}
