package io.github.bartmy.GroupS.landingPage.login;

import io.github.bartmy.GroupS.userProfile.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
class LoginServlet {

    private LoginService loginService;

    LoginServlet(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping(value = "/login", params = {"username", "password", "lang"})
    ResponseEntity<String> login(@RequestParam String username, @RequestParam String password, @RequestParam("lang") Integer langId){
        log.info("Login request got");
        loginService.login(username, password, langId);
//        return ResponseEntity.ok(loginService.login(username, password, langId));
        log.info("Login request passed");
        return ResponseEntity.ok("login ok!");
    }
//
//    @GetMapping(value = "/", params = {"username", "password", "lang"})
//    void login(@RequestParam String username, @RequestParam String password, @RequestParam("lang") Integer langId){
//        log.info("Login request got");
//        loginService.login(username, password, langId);
//    }
}

