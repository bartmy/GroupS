package io.github.bartmy.GroupS.userProfile;


import io.github.bartmy.GroupS.landingPage.login.LoginService;
import io.github.bartmy.GroupS.userProfile.user.User;
import io.github.bartmy.GroupS.userProfile.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class UserProfileService {

    private UserRepository repository;
    private LoginService loginService;

    UserProfileService(UserRepository repository){
        this.repository = repository;
    }

    void startMenuForUserId(Integer userId){

    }
    String printUserData(String username){
        String email = repository.findByUsername(username).get(0).getEmail();
        String displayName = repository.findByUsername(username).get(0).getDisplayName();
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
}
