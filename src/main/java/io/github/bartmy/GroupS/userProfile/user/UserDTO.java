package io.github.bartmy.GroupS.userProfile.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class UserDTO {
    private Integer id;
    private String username;

    public UserDTO(User user){
        this.id = user.getId();
        this.username = user.getUsername();
    }

}
