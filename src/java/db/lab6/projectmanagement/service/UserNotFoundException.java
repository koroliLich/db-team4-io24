package db.lab6.projectmanagement.service;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String nickname) {
        super(String.format("User with nickname '%s' not found", nickname));
    }

    public UserNotFoundException(Long id) {
        super(String.format("User with id %d not found", id));
    }
}
