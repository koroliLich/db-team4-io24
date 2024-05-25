package db.lab6.projectmanagement.service.impl;

import db.lab6.projectmanagement.dto.UserDto;
import db.lab6.projectmanagement.entity.Member;
import db.lab6.projectmanagement.entity.Project;
import db.lab6.projectmanagement.entity.User;
import db.lab6.projectmanagement.repository.MemberRepository;
import db.lab6.projectmanagement.repository.ProjectRepository;
import db.lab6.projectmanagement.repository.UserRepository;
import db.lab6.projectmanagement.service.UserAlreadyExistException;
import db.lab6.projectmanagement.service.UserNotFoundException;
import db.lab6.projectmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, MemberRepository memberRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.memberRepository = memberRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(id));
    }

    @Override
    public User findByNickname(String nickname) {
        return userRepository.findByNickname(nickname).orElseThrow(() ->
                new UserNotFoundException(nickname));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDto userDto) {

        if (userRepository.existsByNickname(userDto.getNickname())) {
            throw new UserAlreadyExistException("nickname", userDto.getNickname());
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new UserAlreadyExistException("email", userDto.getEmail());
        }
        User user = User.builder()
                .email(userDto.getEmail())
                .nickname(userDto.getNickname())
                .password(userDto.getPassword())
                .build();
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, UserDto userDto) {

        if (userRepository.existsByNickname(userDto.getNickname())) {
            throw new UserAlreadyExistException("nickname", userDto.getNickname());
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new UserAlreadyExistException("email", userDto.getEmail());
        }
        User existingUser = findById(id);
        if (userDto.getEmail() != null) existingUser.setEmail(userDto.getEmail());
        if (userDto.getNickname() != null) existingUser.setNickname(userDto.getNickname());
        if (userDto.getPassword() != null) existingUser.setPassword(userDto.getPassword());
        return userRepository.save(existingUser);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }

    @Override
    public Set<Project> findProjects(Long userId) {
        Set<Member> memberSet = memberRepository.findByUser(findById(userId));
        Set<Long> memberIds = memberSet.stream().map(Member::getId).collect(Collectors.toSet());
        return projectRepository.findByMemberIds(memberIds);
    }
}
