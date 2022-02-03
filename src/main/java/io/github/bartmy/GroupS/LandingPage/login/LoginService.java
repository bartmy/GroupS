package io.github.bartmy.GroupS.LandingPage.login;

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

    void loginValidation(String username, String password){
        if (repository.findByUsernameAndPassword(username, password).isEmpty()) {
            log.info("login failed");
        }else log.info("login success!");
    }
}
