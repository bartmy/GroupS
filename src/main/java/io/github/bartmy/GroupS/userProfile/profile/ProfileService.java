package io.github.bartmy.GroupS.userProfile.profile;

import io.github.bartmy.GroupS.userProfile.user.User;
import io.github.bartmy.GroupS.userProfile.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
class ProfileService {

    private UserRepository repository;

    ProfileService(UserRepository repository){
        this.repository = repository;
    }

    String startMenu(Integer userId){
        Optional<User> user = repository.findById(userId);
//        List<User> user = repository.findByUserId(userId);

//        repository.findAll();
        return  user.get().getUsername();

        // TODO finish this process
    }
}
