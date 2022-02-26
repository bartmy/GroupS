package io.github.bartmy.GroupS.groupProfile.groups;

import io.github.bartmy.GroupS.userProfile.user.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "user_groups")
public class Group {

    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")
    @Column(name = "group_id")
    private int groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "owner")
    private String owner;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "groups")
    private Set<User> users = new HashSet<>();

    /**
     * Hibernate (JPA) needs it.
     */
    @SuppressWarnings("unused")
    Group() {
    }

    public Group(String groupName, String owner) {
        this.groupName = groupName;
        this.owner = owner;
    }
    //
//    protected Group(String groupName){
//        this.groupName = groupName;
//        this.owner = readGroupData(groupName,"owner");
//        getId(groupName);
//    }
//    public Group(Integer groupID){
//        this.id = groupID;
//        this.groupName = readData("user_groups", "groupName", "id", ""+groupID);
//        this.owner = readGroupData(groupName,"owner");
//    }
//    public Group(Integer thisValueDoesNothing, Integer needTwoValues){
//    }
//
//    protected void printGroupMembers(String groupName){
//        Database database = new Database();
//        database.getGroupMembers(groupName);
//    }
//    protected void groupSize(String groupName){
//        Database database = new Database();
//        database.getGroupMembers(groupName);
//    }
//    protected void printGroupDetails(Group group){
//        System.out.println("group name: " + group.getGroupName() +
//                " Group ID: " + group.getId() +
//                " owner: " + group.getOwner());
//    }
//    public void printUsersGroups(String username){
//        Database database = new Database();
//        database.getUserGroups(username);
//    }
//    private String readGroupData(String groupName, String whatToGet){
//        return readData("user_groups", whatToGet, "groupName", groupName);
//    }
//    /**
//     only for creating groups
//     */
//    protected Group(User user){
//        takeGroupName();
//        this.owner = user.getUsername();
//        addGroupToDatabase(getGroupName(), getOwner());
//        getId(getGroupName());
//        linkGroupToUser(user.getId(), this.getId());
//    }
//    public Group(User user, String groupName){
//        this.groupName = groupName;
//        this.owner = user.getUsername();
//        addGroupToDatabase(getGroupName(), getOwner());
//        getId(getGroupName());
//        linkGroupToUser(user.getId(), this.getId());
//    }
//    private void takeGroupName(){
//        System.out.print("Group name: ");
//        this.groupName = App.readString();
//    }
//    private void addGroupToDatabase(String groupName,String owner){
//        Database database = new Database();
//        database.updateStatement(
//                "INSERT INTO user_groups(groupName, owner) " +
//                        "VALUES('" + groupName + "', '" + owner + "');");
//    }
//    private void linkGroupToUser(int userID, int groupID){
//        Database database = new Database();
//        database.updateStatement(
//                "INSERT INTO users_to_groups(userID, groupID) " +
//                        "VALUES (" + userID + "," + groupID + ");");
//    }
//
//    /**
//     created due to method readData work only for Strings
//     */
//    private void getId(String groupName){
//        String id = readGroupData(groupName, "id");
//        this.id = Integer.parseInt(id);
//    }
}
