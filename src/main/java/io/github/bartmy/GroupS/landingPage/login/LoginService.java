package io.github.bartmy.GroupS.landingPage.login;

import io.github.bartmy.GroupS.userProfile.user.User;
import io.github.bartmy.GroupS.userProfile.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public
class LoginService {

    private UserRepository repository;

    LoginService(UserRepository repository){
        this.repository = repository;
    }


//    User login(String username, String password, Integer langId){
    User login(String username, String password){
        if (loginValidation(username, password)){
            return repository.findByUsernameAndPassword(username, password).get(0);
        }else {
            return null;
        }
    }

    boolean loginValidation(String username, String password){
        var loginOK = false;
        if (repository.findByUsernameAndPassword(username, password).isEmpty()) {
            log.info("login failed");
        }else {
            log.info("login success! username '" + username + "' and password '" + password + "' is a match!!" );
            loginOK = true;
        }
        return loginOK;
    }

    String loginFailed() {
        return "Login failed! Try again.";
    }
}
