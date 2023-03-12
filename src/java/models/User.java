package models;

import java.io.Serializable;

/**
 * @author 882199
 */
public class User implements Serializable{
    String email;
    String fName;
    String lName;
    String password;
    Role role;
    public User(){
    }
    public User(String email, String fName, String lName, String password, Role role){
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.role = role;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getFName(){
        return this.fName;
    }
    public void setFName(String fName){
        this.fName = fName;
    }
    public String getLName(){
        return this.lName;
    }
    public void setLName(String lName){
        this.lName = lName;
    }
    public String getPass(){
        return this.password;
    }
    public void setPass(String password){
        this.password = password;
    }
    public Role getRole(){
        return this.role;
    }
    public void setRole(Role role){
        this.role = role;
    }
}
