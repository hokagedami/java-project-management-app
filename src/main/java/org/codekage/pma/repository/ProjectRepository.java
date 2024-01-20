package org.codekage.pma.repository;

import org.codekage.pma.entities.Project;
import org.codekage.pma.model.ChartData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM project p WHERE p.project_id IN (SELECT project_id FROM projects_employees where employee_id = :employeeId)")
    Iterable<Project> findAllProjectByEmployeeId(long employeeId);

    @Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as total FROM project GROUP BY stage")
    Iterable<ChartData> findProjectStagesCount();
}