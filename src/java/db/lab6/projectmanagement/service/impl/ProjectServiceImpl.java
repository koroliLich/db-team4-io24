package db.lab6.projectmanagement.service.impl;

import db.lab6.projectmanagement.dto.MemberDto;
import db.lab6.projectmanagement.dto.ProjectDto;
import db.lab6.projectmanagement.dto.TaskDto;
import db.lab6.projectmanagement.entity.*;
import db.lab6.projectmanagement.repository.MemberRepository;
import db.lab6.projectmanagement.repository.ProjectRepository;
import db.lab6.projectmanagement.repository.TaskRepository;
import db.lab6.projectmanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;
    private final UserService userService;
    private final RoleService roleService;
    private final TaskRepository taskRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository,
                              MemberRepository memberRepository,
                              UserService userService,
                              RoleService roleService, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.memberRepository = memberRepository;
        this.userService = userService;
        this.roleService = roleService;
        this.taskRepository = taskRepository;
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id).orElseThrow(() ->
                new ProjectNotFoundException(id));
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project create(ProjectDto projectDto) {

        User ownerUser = userService.findByNickname(projectDto.getOwnerNickname());

        Role ownerRole = roleService.findByName("OWNER");

        Member ownerMember = Member.builder()
                .user(ownerUser)
                .role(ownerRole).build();

        Set<Member> members = new HashSet<>();
        members.add(ownerMember);
        Project project = Project.builder()
                .name(projectDto.getName())
                .description(projectDto.getDescription())
                .members(members).build();
        return projectRepository.save(project);
    }

    @Override
    public Project update(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project update(Long id, ProjectDto projectDto) {

        Project existingProject = findById(id);
        if (projectDto.getName() != null) existingProject.setName(projectDto.getName());
        if (projectDto.getDescription() != null) existingProject.setDescription(projectDto.getDescription());
        return projectRepository.save(existingProject);
    }

    @Override
    public void delete(Project project) {
        projectRepository.delete(project);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        projectRepository.deleteById(id);
    }

    @Override
    public List<Member> findMembers(Long id) {
        Project project = findById(id);
        // the only way it works
        // project.getMembers() returns empty Set
        Set<Project> projects = new HashSet<>();
        projects.add(project);
        return memberRepository.findByProjects(projects);
    }

    @Override
    public List<Member> addMember(Long id, MemberDto memberDto) {

        Project project = findById(id);
        Set<Project> projects = new HashSet<>();
        projects.add(project);

        User user = userService.findByNickname(memberDto.getNickname());

        List<Member> members = memberRepository.findByProjects(projects);
        if (members.stream().anyMatch(member -> member.getUser().equals(user))) {
            throw new UserAlreadyExistException(id, memberDto.getNickname());
        }

        Role role = roleService.findByName(memberDto.getGivenRole());

        Member newMember = Member.builder()
                .user(user)
                .role(role)
                .build();

        members.add(newMember);
        projectRepository.save(project);

        return memberRepository.findByProjects(projects);
    }

    @Override
    public List<Member> removeMember(Long id, Long memberId) {

        Project project = findById(id);

        Set<Project> projects = new HashSet<>();
        projects.add(project);
        List<Member> members = memberRepository.findByProjects(projects);

        Member memberToRemove = members.stream()
                .filter(member -> member.getId().equals(memberId)).findFirst()
                .orElseThrow(() -> new MemberNotFoundException(memberId));

        members.remove(memberToRemove);
        memberRepository.deleteById(memberId);
        projectRepository.save(project);

        project.setMembers(new HashSet<>(members));
        return memberRepository.findByProjects(projects);
    }

    @Override
    public Set<Task> findTasks(Long id) {
        return taskRepository.findByProject(findById(id));
    }

    @Override
    public Set<Task> addTask(Long id, TaskDto taskDto) {

        Project project = findById(id);

        Set<Task> tasks = taskRepository.findByProject(project);
        if (tasks.stream().anyMatch(task -> task.getName().equals(taskDto.getName()))) {
            throw new TaskAlreadyExistException(id, taskDto.getName());
        }

        Task task = Task.builder()
                .name(taskDto.getName())
                .description(taskDto.getDescription())
                .isCompleted(false)
                .project(project)
                .build();

        taskRepository.save(task);
        return taskRepository.findByProject(project);
    }

    @Override
    public Set<Task> removeTask(Long id, Long taskId) {

        Project project = findById(id);

        Set<Task> tasks = taskRepository.findByProject(project);
        Task taskToRemove = tasks.stream()
                .filter(task -> task.getId().equals(taskId)).findFirst()
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        taskRepository.delete(taskToRemove);
        return taskRepository.findByProject(project);
    }
}
