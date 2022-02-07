package io.github.bartmy.GroupS.landingPage;

import io.github.bartmy.GroupS.groups.GroupRepository;
import io.github.bartmy.GroupS.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
class LandingPageService {
    private UserRepository userRepository;
    private GroupRepository groupRepository;

    LandingPageService(UserRepository userRepository, GroupRepository groupRepository){
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    String getNumberOfUsers(){
        log.info("number of users " + userRepository.findAll().size());
        return userRepository.findAll().size() + " users have been created";
    }
    String getNumberOfGroups(){
        log.info("number of groups " + groupRepository.findAll().size());
        return groupRepository.findAll().size() + " groups have been created";
    }

}