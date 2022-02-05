package io.github.bartmy.GroupS.userProfile.profile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/up")
class ProfileServlet {

    private ProfileService profileService;

    ProfileServlet(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{userId}")
    String profileStart(@PathVariable Integer userId){
        log.info("Profile request got");
        return  profileService.startMenu(userId);}
}

