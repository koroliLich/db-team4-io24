package db.lab6.projectmanagement.service;

import db.lab6.projectmanagement.dto.UserDto;
import db.lab6.projectmanagement.entity.Project;
import db.lab6.projectmanagement.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User findById(Long id);

    User findByNickname(String nickname);

    List<User> findAll();

    User create(UserDto userDto);

    User update(User user);

    User update(Long id, UserDto userDto);

    void delete(User user);

    void deleteById(Long id);

    Set<Project> findProjects(Long userId);
}
