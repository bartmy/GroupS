package io.github.bartmy.GroupS.userProfile;

import io.github.bartmy.GroupS.userProfile.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/site/profile/profile.html/api")
class UserProfileServlet {

    private UserProfileService service;

    UserProfileServlet(UserProfileService service) {
        this.service = service;
    }

    @GetMapping()
    String profileStart(){
        log.info("Profile request got");
        return service.printMenu();
    }
    @GetMapping(value = "/{userId}")
    String profileStart(@PathVariable Integer userId){
        log.info("profileStart request got");
        return service.printUserData(userId);
    }
}

