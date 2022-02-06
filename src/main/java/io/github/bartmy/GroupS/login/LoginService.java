package io.github.bartmy.GroupS.login;

import io.github.bartmy.GroupS.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
class LoginService {

    private UserRepository repository;

    LoginService(UserRepository repository){
        this.repository = repository;
    }


    String login(String username, String password, Integer langId){
        if (loginValidation(username, password)){
            return "login ok!";
        }else {
            return loginFailed();
        }
    }

    boolean loginValidation(String username, String password){
        var loginOK = false;
        if (repository.findByUsernameAndPassword(username, password).isEmpty()) {
            log.info("login failed");
        }else {
            log.info("login success!");
            loginOK = true;
        }
        return loginOK;
    }

    String loginFailed() {
        return "Login failed! Try again.";
    }
}
