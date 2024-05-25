package db.lab6.projectmanagement.service;

public class TaskAlreadyExistException extends RuntimeException {

    public TaskAlreadyExistException(Long projectId, String name) {
        super(String.format("Task with name '%s' already exists in project with id %d", name, projectId));
    }
}
