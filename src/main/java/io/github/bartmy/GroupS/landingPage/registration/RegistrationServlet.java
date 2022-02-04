package io.github.bartmy.GroupS.landingPage.registration;

import io.github.bartmy.GroupS.userProfile.user.User;
import io.github.bartmy.GroupS.userProfile.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/register.html/register")
class RegistrationServlet {

    private UserService service;
    private RegistrationService registrationService;

    RegistrationServlet(UserService service){
        this.service = service;
    }

    @GetMapping(value = "/api", params = {"username", "password", "email"})
    String register(@RequestParam String username, @RequestParam String password, @RequestParam String email){
        log.info("Registration request got");
        return "register ok!";
    }

    @PostMapping
    ResponseEntity<User> saveUser(@RequestBody User user){
        log.info("Got post register request ");
        return ResponseEntity.ok(service.save(user));
    }
}

