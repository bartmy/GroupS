package io.github.bartmy.GroupS.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class UserDTO {
    private Integer userId;
    private String username;

    public UserDTO(User user){
        this.userId = user.getUserId();
        this.username = user.getUsername();
    }

}
