package io.github.bartmy.GroupS.groupProfile.groups;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class GroupDTO {
    private Integer id;
    private String groupName;

    public GroupDTO(Group group){
        this.id = group.getGroupId();
        this.groupName = group.getGroupName();
    }

}
