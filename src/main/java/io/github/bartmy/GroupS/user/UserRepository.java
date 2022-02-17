package io.github.bartmy.GroupS.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUsername(String username);

    List<User> findByUserId(Integer Id);

    List<User> findByUsernameAndPassword(String username, String password);

    List<User> findByEmail(String email);

    List<User> findByDisplayName(String displayName);
}
