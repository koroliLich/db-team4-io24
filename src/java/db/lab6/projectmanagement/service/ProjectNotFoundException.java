package db.lab6.projectmanagement.service;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(Long id) {
        super(String.format("Project with id %d not found", id));
    }

}
