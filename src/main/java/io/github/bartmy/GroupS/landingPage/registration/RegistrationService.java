package io.github.bartmy.GroupS.landingPage.registration;

import io.github.bartmy.GroupS.userProfile.user.User;
import io.github.bartmy.GroupS.userProfile.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class RegistrationService {

    private UserRepository repository;

    RegistrationService(UserRepository repository){
        this.repository = repository;
    }

    public String registrationConfirmation(String username, String email){
        return "user " + username + "has been registered! confirmation email has been send to " + email;
    }

    public User createNewUser(User user) {
        if (repository.findByUsername(user.getUsername()).isEmpty()) {
            return save(user);
        }else {
            log.warn("user already exists ");
            return null;
        }
    }
    public User save(User user){
        repository.save(user);
        return user;
    }

}
