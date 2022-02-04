package io.github.bartmy.GroupS.landingPage.registration;

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

}
