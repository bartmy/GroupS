package io.github.bartmy.GroupS.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
class UserService {
    private UserRepository repository;

    UserService(UserRepository repository){
        this.repository = repository;
    }

    List<UserDTO> findAll(){
        return repository
                .findAll()
                .stream()
                .map(UserDTO::new)
                .collect(toList());
    }
//    List<UserDTO> findByUsername(String username){
//        return repository
//                .findByUsername(username)
//                .stream()
//                .map(UserDTO::new)
//                .collect(toList());
//    }
}
