package db.lab6.projectmanagement.service;

public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException(String name) {
        super(String.format("Role with name '%s' not found", name));
    }

    public RoleNotFoundException(Long id) {
        super(String.format("Role with id %d not found", id));
    }
}
