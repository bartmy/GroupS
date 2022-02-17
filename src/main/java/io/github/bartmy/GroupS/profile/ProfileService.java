package io.github.bartmy.GroupS.profile;

import io.github.bartmy.GroupS.user.User;
import io.github.bartmy.GroupS.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class ProfileService {

    private UserRepository repository;

    ProfileService(UserRepository repository){
        this.repository = repository;
    }

    User startMenuForUserId(Integer userId){

        return repository.findByUserId(userId).get(0);
    }
    String printUserData(Integer userId){
        String username = repository.findByUserId(userId).get(0).getUsername();
        String email = repository.findByUserId(userId).get(0).getEmail();
        String displayName = repository.findByUserId(userId).get(0).getDisplayName();
        return "Username " + username + " email: " + email + " displayName: " + displayName;
    }
    String printMenu(){
        return """

                 what do you want to do ?\s
                1. my data\s
                2. change my data\s
                3. my groups\s
                4. join group\s
                5. enter group\s
                6. create new group\s
                0. logout""";
    }
}
