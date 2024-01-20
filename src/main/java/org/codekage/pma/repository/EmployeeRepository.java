package org.codekage.pma.repository;

import org.codekage.pma.entities.Employee;
import org.codekage.pma.model.EmployeeWithProjectCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM employee e WHERE e.employee_id IN" +
            " (SELECT employee_id FROM projects_employees where project_id = :projectId)")
    Iterable<Employee> findAllOnProjectByProjectId(long projectId);


    // native query to get all employees with their projects count
    @Query(nativeQuery = true, value = "SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount " +
            "FROM employee e LEFT JOIN projects_employees pe ON e.employee_id = pe.employee_id " +
            "GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
    Iterable<EmployeeWithProjectCount> findAllWithProjects();
}