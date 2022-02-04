package io.github.bartmy.GroupS.landingPage.login;

import io.github.bartmy.GroupS.additionals.hello.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
class LoginServlet {

    private LoginService loginService;
    private HelloService helloService;

    LoginServlet(LoginService loginService, HelloService helloService) {
        this.loginService = loginService;
        this.helloService = helloService;
    }

    @GetMapping(value = "/api", params = {"username", "password", "lang"})
    String login(@RequestParam String username, @RequestParam String password, @RequestParam("lang") Integer langId){
        log.info("Login request got");
        if (loginService.loginValidation(username, password)){
            return "login ok!";
//            return "login ok! " + helloService.prepareGreeting(username, langId);
        }else {
            return loginService.loginFailed();
        }
    }
}

