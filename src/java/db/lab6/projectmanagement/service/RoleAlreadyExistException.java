package db.lab6.projectmanagement.service;

public class RoleAlreadyExistException extends RuntimeException {

    public RoleAlreadyExistException(String name) {
        super(String.format("Role with name '%s' already exists", name));
    }
}
