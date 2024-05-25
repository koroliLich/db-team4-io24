package db.lab6.projectmanagement.controller;

import db.lab6.projectmanagement.dto.RoleDto;
import db.lab6.projectmanagement.entity.Role;
import db.lab6.projectmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody RoleDto roleDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.create(roleDto));
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long roleId) {
        roleService.deleteById(roleId);
        return ResponseEntity.noContent().build();
    }
}
