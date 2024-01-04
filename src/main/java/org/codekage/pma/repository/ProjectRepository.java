package org.codekage.pma.repository;

import org.codekage.pma.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM project p WHERE p.project_id IN (SELECT project_id FROM projects_employees where employee_id = :employeeId)")
    Iterable<Project> findAllProjectByEmployeeId(long employeeId);
}