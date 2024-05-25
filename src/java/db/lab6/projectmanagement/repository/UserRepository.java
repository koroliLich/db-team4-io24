package db.lab6.projectmanagement.repository;

import db.lab6.projectmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNickname(String creatorNickname);

    Boolean existsByNickname(String username);

    Boolean existsByEmail(String email);
}
