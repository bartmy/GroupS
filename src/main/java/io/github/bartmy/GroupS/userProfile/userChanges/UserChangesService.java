package io.github.bartmy.GroupS.userProfile.userChanges;


import io.github.bartmy.GroupS.userProfile.user.User;
import io.github.bartmy.GroupS.userProfile.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class UserChangesService {

    private UserRepository repository;

    UserChangesService(UserRepository repository){
        this.repository = repository;
    }

    User change(User user){
        repository.save(user);
        return user;
    }
}
