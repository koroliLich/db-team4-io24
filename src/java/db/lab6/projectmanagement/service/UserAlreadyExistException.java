package db.lab6.projectmanagement.service;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String signUpErrorField, String fieldValue) {
        super(String.format("User with %s '%s' already exists", signUpErrorField, fieldValue));
    }

    public UserAlreadyExistException(Long projectId, String nickname) {
        super(String.format("User with nickname '%s' already exists in project with id %d", nickname, projectId));
    }
}
