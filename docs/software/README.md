# Реалізація інформаційного та програмного забезпечення

## SQL-скрипт для створення на початкового наповнення бази даних
```sql
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db-io24-team4
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db-io24-team4
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db-io24-team4` DEFAULT CHARACTER SET utf8 ;
USE `db-io24-team4` ;

-- -----------------------------------------------------
-- Table `db-io24-team4`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db-io24-team4`.`user` (
  `id` INT NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db-io24-team4`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db-io24-team4`.`role` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db-io24-team4`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db-io24-team4`.`member` (
  `id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_member_user_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_member_Role1_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_member_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `db-io24-team4`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_member_Role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `db-io24-team4`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db-io24-team4`.`permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db-io24-team4`.`permission` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db-io24-team4`.`grant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db-io24-team4`.`grant` (
  `id` INT NOT NULL,
  `role_id` INT NOT NULL,
  `permission_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Grant_Role1_idx` (`role_id` ASC) VISIBLE,
  INDEX `fk_grant_permission1_idx` (`permission_id` ASC) VISIBLE,
  CONSTRAINT `fk_Grant_Role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `db-io24-team4`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grant_permission1`
    FOREIGN KEY (`permission_id`)
    REFERENCES `db-io24-team4`.`permission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db-io24-team4`.`project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db-io24-team4`.`project` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(150) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db-io24-team4`.`project_member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db-io24-team4`.`project_member` (
  `id` INT NOT NULL,
  `member_id` INT NOT NULL,
  `project_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_project_member_member1_idx` (`member_id` ASC) VISIBLE,
  INDEX `fk_project_member_project1_idx` (`project_id` ASC) VISIBLE,
  CONSTRAINT `fk_project_member_member1`
    FOREIGN KEY (`member_id`)
    REFERENCES `db-io24-team4`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_project_member_project1`
    FOREIGN KEY (`project_id`)
    REFERENCES `db-io24-team4`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db-io24-team4`.`task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db-io24-team4`.`task` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(150) NOT NULL,
  `isCompleted` TINYINT NOT NULL,
  `project_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_task_project1_idx` (`project_id` ASC) VISIBLE,
  CONSTRAINT `fk_task_project1`
    FOREIGN KEY (`project_id`)
    REFERENCES `db-io24-team4`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- -----------------------------------------------------
-- Data for table `db-io24-team4`.`role`
-- -----------------------------------------------------
START TRANSACTION;
USE `db-io24-team4`;
INSERT INTO `db-io24-team4`.`role` (`id`, `name`) VALUES (1, `ProjectOwner`);
INSERT INTO `db-io24-team4`.`role` (`id`, `name`) VALUES (2, `Developer`);

COMMIT;

-- -----------------------------------------------------
-- Data for table `db-io24-team4`.`permission`
-- -----------------------------------------------------
START TRANSACTION;
USE `db-io24-team4`;
INSERT INTO `db-io24-team4`.`permission` (`id`, `name`) VALUES (1, `create_task`);
INSERT INTO `db-io24-team4`.`permission` (`id`, `name`) VALUES (2, `delete_task`);
INSERT INTO `db-io24-team4`.`permission` (`id`, `name`) VALUES (3, `change_task_description`);
INSERT INTO `db-io24-team4`.`permission` (`id`, `name`) VALUES (4, `change_project_description`);
INSERT INTO `db-io24-team4`.`permission` (`id`, `name`) VALUES (5, `add_user`);
INSERT INTO `db-io24-team4`.`permission` (`id`, `name`) VALUES (6, `delete_user`);
INSERT INTO `db-io24-team4`.`permission` (`id`, `name`) VALUES (7, `delete_project`);

COMMIT;

-- -----------------------------------------------------
-- Data for table `db-io24-team4`.`grant`
-- -----------------------------------------------------
START TRANSACTION;
USE `db-io24-team4`;
INSERT INTO `db-io24-team4`.`grant` (`id`, `role_id`, `permission_id`) VALUES (1, 1, 1);
INSERT INTO `db-io24-team4`.`grant` (`id`, `role_id`, `permission_id`) VALUES (2, 1, 2);
INSERT INTO `db-io24-team4`.`grant` (`id`, `role_id`, `permission_id`) VALUES (3, 1, 3);
INSERT INTO `db-io24-team4`.`grant` (`id`, `role_id`, `permission_id`) VALUES (4, 1, 4);
INSERT INTO `db-io24-team4`.`grant` (`id`, `role_id`, `permission_id`) VALUES (5, 1, 5);
INSERT INTO `db-io24-team4`.`grant` (`id`, `role_id`, `permission_id`) VALUES (6, 1, 6);
INSERT INTO `db-io24-team4`.`grant` (`id`, `role_id`, `permission_id`) VALUES (7, 1, 7);
INSERT INTO `db-io24-team4`.`grant` (`id`, `role_id`, `permission_id`) VALUES (8, 2, 1);
INSERT INTO `db-io24-team4`.`grant` (`id`, `role_id`, `permission_id`) VALUES (9, 2, 2);
INSERT INTO `db-io24-team4`.`grant` (`id`, `role_id`, `permission_id`) VALUES (10, 2, 3);

COMMIT;

-- -----------------------------------------------------
-- Data for table `db-io24-team4`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `db-io24-team4`;
INSERT INTO `db-io24-team4`.`user` (`id`, `email`, `nickname`, `password`) VALUES (1, `yellowmonkey@gmail.com`, `yellowmonkey`, `Bws3YXQ8`);
INSERT INTO `db-io24-team4`.`user` (`id`, `email`, `nickname`, `password`) VALUES (2, `wonderful@gmail.com`, `w0nderful`, `NW4Xzm4h`);
INSERT INTO `db-io24-team4`.`user` (`id`, `email`, `nickname`, `password`) VALUES (3, `denysholovin03@gmail.com`, `holovin.d`, `sDnGtCiN`);

COMMIT;

-- -----------------------------------------------------
-- Data for table `db-io24-team4`.`member`
-- -----------------------------------------------------
START TRANSACTION;
USE 'db-io24-tean4';
INSERT INTO `db-io24-team4`.`member` (`id`, `user_id`, `role_id`) VALUES (1, 1, 1)
INSERT INTO `db-io24-team4`.`member` (`id`, `user_id`, `role_id`) VALUES (2, 2, 2)
INSERT INTO `db-io24-team4`.`member` (`id`, `user_id`, `role_id`) VALUES (3, 3, 2)

COMMIT;

-- -----------------------------------------------------
-- Data for table `db-io24-team4`.`project_member`
-- -----------------------------------------------------
START TRANSACTION;
USE 'db-io24-tean4';
INSERT INTO `db-io24-team4`.`project_member` (`id`, `member_id`, `project_id`) VALUES (1, 1, 1)
INSERT INTO `db-io24-team4`.`project_member` (`id`, `member_id`, `project_id`) VALUES (2, 2, 1)
INSERT INTO `db-io24-team4`.`project_member` (`id`, `member_id`, `project_id`) VALUES (3, 3, 1)

COMMIT;

-- -----------------------------------------------------
-- Data for table `db-io24-team4`.`project`
-- -----------------------------------------------------
START TRANSACTION;
USE 'db-io24-tean4';
INSERT INTO `db-io24-team4`.`project` (`id`, `name`, `description`) VALUES (1, `course work`, `Our course work`)

COMMIT;

-- -----------------------------------------------------
-- Data for table `db-io24-team4`.`task`
-- -----------------------------------------------------
START TRANSACTION;
USE 'db-io24-tean4';
INSERT INTO `db-io24-team4`.`task` (`id`, `name`, `description`, `isCompleted`, `project_id`) VALUES (1, `Frontend`, `Frontend part`, 0, 1)
INSERT INTO `db-io24-team4`.`task` (`id`, `name`, `description`, `isCompleted`, `project_id`) VALUES (2, `Backend`, `Backend part`, 0, 1)

COMMIT;
```

## RESTfull сервіс для управління даними

### Сервіси

#### ProjectService

```java
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
    public Set<Member> addMember(Long id, MemberDto memberDto) {

        Project project = findById(id);

        User user = userService.findByNickname(memberDto.getNickname()); // ось цей

        Set<Project> projects = new HashSet<>();
        projects.add(project);
        List<Member> members = memberRepository.findByProjects(projects);

        for (Member member : members) {
            System.out.println(member);
        }

        if (members.stream().anyMatch(member -> member.getUser().equals(user))) {
            throw new UserAlreadyExistException(id, memberDto.getNickname());
        }

        Role role = roleService.findByName(memberDto.getGivenRole());

        Member newMember = Member.builder()
                .user(user)
                .role(role)
                .build();

        members.add(newMember);
        project.setMembers(new HashSet<>(members));

        return projectRepository.save(project).getMembers();
    }

    @Override
    public Set<Member> removeMember(Long projectId, Long memberId) {

        Project project = findById(projectId);

        Set<Project> projects = new HashSet<>();
        projects.add(project);
        List<Member> members = memberRepository.findByProjects(projects);

        Member memberToRemove = members.stream()
                .filter(member -> member.getId().equals(memberId)).findFirst()
                .orElseThrow(() -> new MemberNotFoundException(memberId));

        members.remove(memberToRemove);

        project.setMembers(new HashSet<>(members));

        memberRepository.deleteById(memberId);

        return projectRepository.save(project).getMembers();
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
```

#### RoleService

```java
package db.lab6.projectmanagement.service.impl;

import db.lab6.projectmanagement.dto.RoleDto;
import db.lab6.projectmanagement.entity.Role;
import db.lab6.projectmanagement.repository.RoleRepository;
import db.lab6.projectmanagement.service.RoleService;
import db.lab6.projectmanagement.service.RoleAlreadyExistException;
import db.lab6.projectmanagement.service.RoleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(() ->
                new RoleNotFoundException(id));
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() ->
                new RoleNotFoundException(name));
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role create(RoleDto roleDto) {

        if (roleRepository.existsByName(roleDto.getName())) {
            throw new RoleAlreadyExistException(roleDto.getName());
        }
        Role role = Role.builder()
                .name(roleDto.getName())
                .build();
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Long id, RoleDto roleDto) {

        if (roleRepository.existsByName(roleDto.getName())) {
            throw new RoleAlreadyExistException(roleDto.getName());
        }
        Role existingRole = findById(id);
        if (roleDto.getName() != null) existingRole.setName(roleDto.getName());
        return roleRepository.save(existingRole);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        roleRepository.deleteById(id);
    }
}
```

#### UserService

```java
package db.lab6.projectmanagement.service.impl;

import db.lab6.projectmanagement.dto.UserDto;
import db.lab6.projectmanagement.entity.Member;
import db.lab6.projectmanagement.entity.Project;
import db.lab6.projectmanagement.entity.User;
import db.lab6.projectmanagement.repository.MemberRepository;
import db.lab6.projectmanagement.repository.ProjectRepository;
import db.lab6.projectmanagement.repository.UserRepository;
import db.lab6.projectmanagement.service.UserAlreadyExistException;
import db.lab6.projectmanagement.service.UserNotFoundException;
import db.lab6.projectmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, MemberRepository memberRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.memberRepository = memberRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(id));
    }

    @Override
    public User findByNickname(String nickname) {
        return userRepository.findByNickname(nickname).orElseThrow(() ->
                new UserNotFoundException(nickname));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDto userDto) {

        if (userRepository.existsByNickname(userDto.getNickname())) {
            throw new UserAlreadyExistException("nickname", userDto.getNickname());
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new UserAlreadyExistException("email", userDto.getEmail());
        }
        User user = User.builder()
                .email(userDto.getEmail())
                .nickname(userDto.getNickname())
                .password(userDto.getPassword())
                .build();
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, UserDto userDto) {

        if (userRepository.existsByNickname(userDto.getNickname())) {
            throw new UserAlreadyExistException("nickname", userDto.getNickname());
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new UserAlreadyExistException("email", userDto.getEmail());
        }
        User existingUser = findById(id);
        if (userDto.getEmail() != null) existingUser.setEmail(userDto.getEmail());
        if (userDto.getNickname() != null) existingUser.setNickname(userDto.getNickname());
        if (userDto.getPassword() != null) existingUser.setPassword(userDto.getPassword());
        return userRepository.save(existingUser);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }

    @Override
    public Set<Project> findProjects(Long userId) {
        Set<Member> memberSet = memberRepository.findByUser(findById(userId));
        Set<Long> memberIds = memberSet.stream().map(Member::getId).collect(Collectors.toSet());
        return projectRepository.findByMemberIds(memberIds);
    }
}
```