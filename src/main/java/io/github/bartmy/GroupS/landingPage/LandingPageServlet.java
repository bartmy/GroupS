package io.github.bartmy.GroupS.landingPage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
class LandingPageServlet {

    private LandingPageService service;

    LandingPageServlet(LandingPageService service) {
        this.service = service;
    }

    @GetMapping("/usersnum")
    ResponseEntity<String> numberOfUsers(){
        log.info("Got lp users request");
        return ResponseEntity.ok(service.getNumberOfUsers());
    }
    @GetMapping("/groupsnum")
    ResponseEntity<String> numberOfGroups(){
        log.info("Got lp groups request");
        return ResponseEntity.ok(service.getNumberOfGroups());
    }
}

