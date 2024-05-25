package db.lab6.projectmanagement.repository;

import db.lab6.projectmanagement.entity.Project;
import db.lab6.projectmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Set<Task> findByProject(Project project);
}
