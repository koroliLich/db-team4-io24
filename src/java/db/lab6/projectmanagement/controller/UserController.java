package db.lab6.projectmanagement.controller;

import db.lab6.projectmanagement.dto.UserDto;
import db.lab6.projectmanagement.entity.Project;
import db.lab6.projectmanagement.entity.User;
import db.lab6.projectmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userDto));
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.update(userId, userDto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}/projects")
    public ResponseEntity<Set<Project>> getUserProjects(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findProjects(userId));
    }
}
