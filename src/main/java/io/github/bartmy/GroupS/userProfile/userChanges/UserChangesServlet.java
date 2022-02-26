package io.github.bartmy.GroupS.userProfile.userChanges;

import io.github.bartmy.GroupS.userProfile.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/site/profile/profile.html/api")
class UserChangesServlet {

    private UserChangesService service;

    UserChangesServlet(UserChangesService service) {
        this.service = service;
    }

    @PutMapping()
    ResponseEntity<User> changeUserData(@RequestBody User user){
        log.info("Got put changeUserData request ");
        return ResponseEntity.ok(service.change(user));
    }
}

