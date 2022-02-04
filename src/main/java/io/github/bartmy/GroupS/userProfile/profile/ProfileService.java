package io.github.bartmy.GroupS.userProfile.profile;

import io.github.bartmy.GroupS.userProfile.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
class ProfileService {

    private UserRepository repository;

    ProfileService(UserRepository repository){
        this.repository = repository;
    }

    void startMenu(Integer userId){
        // TODO finish this process
    }
}
