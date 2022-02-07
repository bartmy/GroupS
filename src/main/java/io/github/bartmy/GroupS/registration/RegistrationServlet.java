package io.github.bartmy.GroupS.registration;

import io.github.bartmy.GroupS.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/site/register/register.html/api")
class RegistrationServlet {

    private RegistrationService registrationService;

    RegistrationServlet(RegistrationService service){
        this.registrationService = service;
    }

    @GetMapping(value = "/register", params = {"username", "password", "email"})
    ResponseEntity<String>  register(@RequestParam String username, @RequestParam String password, @RequestParam String email){
        log.info("Registration request got");
        return ResponseEntity.ok("register ok!");
    }

    @PostMapping()
    ResponseEntity<User> saveUser(@RequestBody User user){
        log.info("Got post register request ");
        return ResponseEntity.ok(registrationService.createNewUser(user));
    }
}

