package io.github.bartmy.GroupS.profile;

import io.github.bartmy.GroupS.user.User;
import io.github.bartmy.GroupS.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
class ProfileService {

    private UserRepository repository;

    ProfileService(UserRepository repository){
        this.repository = repository;
    }

//    User startMenuForUserId(Integer userId){
//        return repository.findByUserId(userId).get(0);
//    }
}
