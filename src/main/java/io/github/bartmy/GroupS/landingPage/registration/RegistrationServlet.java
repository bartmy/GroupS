package io.github.bartmy.GroupS.landingPage.registration;

import io.github.bartmy.GroupS.userProfile.user.User;
import io.github.bartmy.GroupS.userProfile.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
class RegistrationServlet {

    private UserService service;

    RegistrationServlet(UserService service){
        this.service = service;
    }

    @GetMapping(value = "/register", params = {"username", "password"})
    void register(@RequestParam String username, @RequestParam String password){
        log.info("Registration request got");

    }

    @PostMapping
    ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.ok(service.save(user));
    }
}

