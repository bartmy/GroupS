package io.github.bartmy.GroupS.userProfile;

import io.github.bartmy.GroupS.userProfile.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/site/profile/profile.html/api")
class UserProfileServlet {

    private UserProfileService service;

    UserProfileServlet(UserProfileService service) {
        this.service = service;
    }

//    @GetMapping()
//    String profileStart(){
//        log.info("Profile request got");
//        return service.printMenu();
//    }

    @GetMapping(value = "/{username}")
    ResponseEntity<String> printUserData(@PathVariable String username){
        log.info("printUserData request got");
        return ResponseEntity.ok(service.printUserData(username));
    }

    @GetMapping(value = "/menu")
    ResponseEntity<String> menu(){
        log.info("menu request got");
        return ResponseEntity.ok("service.menu()");
    }


//    @GetMapping(value = "/menu")
//    ResponseEntity<List<String>> menu(){
//        log.info("menu request got");
//        return ResponseEntity.ok(service.menu());
//    }
}

