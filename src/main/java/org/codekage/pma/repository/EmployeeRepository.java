package org.codekage.pma.repository;

import org.codekage.pma.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM employee e WHERE e.employee_id IN (SELECT employee_id FROM projects_employees where project_id = :projectId)")
    Iterable<Employee> findAllOnProjectByProjectId(long projectId);
}