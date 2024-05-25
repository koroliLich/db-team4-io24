package db.lab6.projectmanagement.repository;

import db.lab6.projectmanagement.entity.Member;
import db.lab6.projectmanagement.entity.Project;
import db.lab6.projectmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByProjects(Set<Project> projects);

    Set<Member> findByUser(User user);
}
