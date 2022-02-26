package io.github.bartmy.GroupS.groupProfile;

import io.github.bartmy.GroupS.groupProfile.groups.Group;
import io.github.bartmy.GroupS.groupProfile.groups.GroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class GroupProfileService {

    private GroupRepository repository;

    GroupProfileService(GroupRepository repository){
        this.repository = repository;
    }
    Group startMenuForGroupId(Integer groupId){
        return repository.findByGroupId(groupId).get(0);
    }

    String printGroupData(Integer groupId){
        String groupName = repository.findByGroupId(groupId).get(0).getGroupName();
        String owner = repository.findByGroupId(groupId).get(0).getOwner();
        return "groupName " + groupName + " owner: " + owner;
    }
    String printMenu(){
        return """
                what do you want to do?\s
                1. see members\s
                2. add users or pending invites\s
                3. see group data\s
                4. change group info\s
                0. back""";
    }
}
