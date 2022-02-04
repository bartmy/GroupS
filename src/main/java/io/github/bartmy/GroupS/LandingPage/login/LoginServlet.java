package io.github.bartmy.GroupS.LandingPage.login;

import io.github.bartmy.GroupS.hello.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
class LoginServlet {

    private LoginService service;

    LoginServlet(LoginService service){
        this.service = service;
    }

    @GetMapping(value = "/login", params = {"username", "password"})
    void login(@RequestParam String username, @RequestParam String password){
        log.info("Got request ");
        service.loginValidation(username, password);
    }
}

