package db.lab6.projectmanagement.service;

import db.lab6.projectmanagement.dto.RoleDto;
import db.lab6.projectmanagement.entity.Role;

import java.util.List;

public interface RoleService {

    Role findById(Long id);

    Role findByName(String name);

    List<Role> findAll();

    Role create(RoleDto roleDto);

    Role update(Role role);

    Role update(Long id, RoleDto roleDto);

    void delete(Role role);

    void deleteById(Long id);
}
