package db.lab6.projectmanagement.service;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(Long id) {
        super(String.format("Member with id %d not found", id));
    }

}
