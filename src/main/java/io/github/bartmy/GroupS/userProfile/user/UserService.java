package io.github.bartmy.GroupS.userProfile.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
public
class UserService {
    private UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createNewUser(String username, String password) {
        User newUser = new User(username, password);
        if (repository.findByUsername(username).isEmpty()) {
            return newUser;
        }
        return newUser;
    }
    public User save(User user){
        repository.save(user);
        return user;
    }
}
