package io.github.bartmy.GroupS.userProfile.groups;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
interface GroupRepository  extends JpaRepository<Group, Integer> {

    List<Group> findByGroupName(String groupName);
    List<Group> findByOwner(String owner);
}
