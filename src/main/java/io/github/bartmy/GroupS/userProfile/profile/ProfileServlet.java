package io.github.bartmy.GroupS.userProfile.profile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/profile")
class ProfileServlet {

    private ProfileService profileService;

    ProfileServlet(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = "/{userId}")
    void profileStart(@PathVariable Integer userId){
        log.info("Profile request got");
        profileService.startMenu(userId);
    }
}

