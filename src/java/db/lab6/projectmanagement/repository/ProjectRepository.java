package db.lab6.projectmanagement.repository;

import db.lab6.projectmanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p JOIN p.members m WHERE m.id IN :memberIds")
    Set<Project> findByMemberIds(@Param("memberIds") Set<Long> memberIds);
}
