package db.lab6.projectmanagement.controller;

import db.lab6.projectmanagement.dto.MemberDto;
import db.lab6.projectmanagement.dto.ProjectDto;
import db.lab6.projectmanagement.dto.TaskDto;
import db.lab6.projectmanagement.entity.Member;
import db.lab6.projectmanagement.entity.Project;
import db.lab6.projectmanagement.entity.Task;
import db.lab6.projectmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @GetMapping("/{projectId}")
    private ResponseEntity<Project> getProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(projectService.findById(projectId));
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.create(projectDto));
    }

    @PatchMapping("/{projectId}")
    public ResponseEntity<Project> updateProject(@PathVariable Long projectId, @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectService.update(projectId, projectDto));
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long projectId) {
        projectService.deleteById(projectId);
        return ResponseEntity.noContent().build();
    }

    // members
    @GetMapping("/{projectId}/members")
    public ResponseEntity<List<Member>> getAllMembersFromProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(projectService.findMembers(projectId));
    }

    @PostMapping("/{projectId}/members")
    public ResponseEntity<List<Member>> addMemberToProject(@PathVariable Long projectId,
                                                      @RequestBody MemberDto memberDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.addMember(projectId, memberDto));
    }

    @DeleteMapping("/{projectId}/members/{memberId}")
    public ResponseEntity<List<Member>> removeMemberFromProject(@PathVariable Long projectId,
                                                      @PathVariable Long memberId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.removeMember(projectId, memberId));
    }

    // tasks
    @GetMapping("/{projectId}/tasks")
    public ResponseEntity<Set<Task>> getAllTasksInProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(projectService.findTasks(projectId));
    }

    @PostMapping("/{projectId}/tasks")
    public ResponseEntity<Set<Task>> addTaskToProject(@PathVariable Long projectId,
                                                           @RequestBody TaskDto taskDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.addTask(projectId, taskDto));
    }

    @DeleteMapping("/{projectId}/tasks/{taskId}")
    public ResponseEntity<Set<Task>> removeTaskFromProject(@PathVariable Long projectId,
                                                                @PathVariable Long taskId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.removeTask(projectId, taskId));
    }
}
