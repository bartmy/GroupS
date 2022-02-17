package io.github.bartmy.GroupS.profile;

import io.github.bartmy.GroupS.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/site/profile/profile.html/api")
class ProfileServlet {

    private ProfileService profileService;

    ProfileServlet(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping()
    String profileStart(){
        log.info("Profile request got");
        return profileService.printMenu();
    }
    @GetMapping(value = "/{userId}")
    String profileStart(@PathVariable Integer userId){
        log.info("Profile request got");
        return profileService.printUserData(userId);
    }
}

