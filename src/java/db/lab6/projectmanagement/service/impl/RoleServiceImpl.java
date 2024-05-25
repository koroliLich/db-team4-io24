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
