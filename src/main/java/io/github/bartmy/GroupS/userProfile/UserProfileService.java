package io.github.bartmy.GroupS.userProfile;


import io.github.bartmy.GroupS.user.User;
import io.github.bartmy.GroupS.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Service
class UserProfileService {

    private UserRepository repository;

    UserProfileService(UserRepository repository){
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
    User findByUserId(Integer Id){
        return repository.findByUserId(Id).get(0);
    }
//    User saveChanges(){
//        var user = findByUserId()
//        repository.save()
//    }
    User change(User user){
        repository.save(user);
        return user;
    }
}
