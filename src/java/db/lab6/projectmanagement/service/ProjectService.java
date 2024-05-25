package db.lab6.projectmanagement.service;

import db.lab6.projectmanagement.dto.MemberDto;
import db.lab6.projectmanagement.dto.ProjectDto;
import db.lab6.projectmanagement.dto.TaskDto;
import db.lab6.projectmanagement.entity.Member;
import db.lab6.projectmanagement.entity.Project;
import db.lab6.projectmanagement.entity.Task;

import java.util.List;
import java.util.Set;

public interface ProjectService {

    Project findById(Long id);

    List<Project> findAll();

    Project create(ProjectDto projectDto);

    Project update(Project project);

    Project update(Long id, ProjectDto projectDto);

    void delete(Project project);

    void deleteById(Long id);

    List<Member> findMembers(Long id);

    List<Member> addMember(Long id, MemberDto memberDto);

    List<Member> removeMember(Long id, Long memberId);

    Set<Task> findTasks(Long id);

    Set<Task> addTask(Long id, TaskDto taskDto);

    Set<Task> removeTask(Long id, Long taskId);
}
