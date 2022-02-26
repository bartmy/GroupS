package io.github.bartmy.GroupS.userProfile.user;

import io.github.bartmy.GroupS.groupProfile.groups.Group;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")
    @Column(name = "user_id")
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "display_name")
    private String displayName = null;

    @Column(name = "email")
    private String email = null;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_to_groups",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private Set<Group> groups = new HashSet<>();

    /**
     * Hibernate (JPA) needs it.
     */
    @SuppressWarnings("unused")
    User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.displayName = username;
        this.email = email;
    }
//
//    public User(String username, String password){
//        this.username = username;
//        this.password = password;
//        this.displayName = readUserData(username, "displayName");
//        this.email = readUserData(username, "email");
//        setID(username);
//    }
//    public User(String username){
//        this.username = username;
//        this.password = readUserData(username, "password");
//        this.displayName = readUserData(username, "displayName");
//        this.email = readUserData(username, "email");
//        setID(username);
//    }
//
//
//    public void printMyData(){
//        System.out.println("username: " + getUsername() + "\n" +
//                "password: " + getPassword() + "\n" +
//                "displayName: " + getDisplayName() + "\n" +
//                "email: " + getEmail() + "\n" +
//                "");
//    }
//
//    private String readUserData(String username, String whatToGet){
//        return readData("users", whatToGet, "username", username);
//    }
//    /**
//     created due to method readData work only for Strings
//     */
//    private void setID(String username){
//        String id = readUserData(username, "id");
//        this.id = Integer.parseInt(id);
//    }
//
//    /**
//     used only to register user
//     */
//
//    public User(Integer thisValueDoesNothing){
//    }
//    public void registerUser(){
//        readUsername();
//        readPassword();
//    }
//    private void readUsername(){
//        System.out.print("Username: ");
//        this.username = App.readString();
//    }
//    private void readPassword(){
//        System.out.print("Password: ");
//        this.password = App.readString();
//    }
//    private void readEmail(){
//        System.out.print("Email: ");
//        this.email = App.readString();
//        updateData("users", "email", this.email, "username", this.username);
//    }
//    public void emailValidation(String username){
//        if ((readUserData(username, "email")) == null){
//            System.out.println("you do not have email, please update it");
//            readEmail();
//        }
//    }
}
