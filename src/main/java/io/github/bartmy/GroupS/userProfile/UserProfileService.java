package io.github.bartmy.GroupS.userProfile;


import io.github.bartmy.GroupS.landingPage.login.LoginService;
import io.github.bartmy.GroupS.userProfile.user.User;
import io.github.bartmy.GroupS.userProfile.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
class UserProfileService {

    private UserRepository repository;
    private LoginService loginService;

    private List<String> menuArr = new ArrayList<>();

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
    void createMenu(){
        menuArr.add("my data");
        menuArr.add("change my dat");
        menuArr.add("my groups");
        menuArr.add("join group");
        menuArr.add("enter group");
        menuArr.add("create new group");
        menuArr.add("logout");
    }
    List<String> menu(){
        createMenu();
        return menuArr;
    }
    User findByUserId(Integer Id){
        return repository.findByUserId(Id).get(0);
    }
//    User saveChanges(){
//        var user = findByUserId()
//        repository.save()
//    }
}
