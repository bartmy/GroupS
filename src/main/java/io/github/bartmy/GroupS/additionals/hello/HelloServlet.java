package io.github.bartmy.GroupS.additionals.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
class HelloServlet {

    private HelloService service;

    HelloServlet(HelloService service){
        this.service = service;
    }

    @GetMapping("/api")
    String welcome(){
        return welcome(null,null);
    }
    @GetMapping(value = "/api", params = {"lang"})
    String welcome(@RequestParam("lang") Integer langId){
        return welcome(langId,null);
    }
    @GetMapping(value = "/api", params = {"name"})
    String welcome(@RequestParam String name){
        return welcome(null,name);
    }

    @GetMapping(value = "/api", params = {"lang", "username"})
    String welcome(@RequestParam("lang") Integer langId, @RequestParam String username){
        log.info("Got hello request ");
        return service.prepareGreeting(username, langId);
    }
}

