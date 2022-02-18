package io.github.bartmy.GroupS.groupProfile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/site/group/group.html/api")
class GroupProfileServlet {

    private GroupProfileService service;

    GroupProfileServlet(GroupProfileService service) {
        this.service = service;
    }

    @GetMapping()
    String profileStart(){
        log.info("Profile request got");
        return service.printMenu();
    }
    @GetMapping(value = "/{userId}")
    String profileStart(@PathVariable Integer groupId){
        log.info("Profile request got");
        return service.printGroupData(groupId);
    }
}

