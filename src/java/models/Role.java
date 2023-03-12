package models;

import java.io.Serializable;

/**
 * @author 882199
 */
public class Role implements Serializable{
    int roleId;
    String roleName;
    public Role(){
    }
    public Role(int roleId, String roleName){
        this.roleId = roleId;
        this.roleName = roleName;
    }
    public int getRoleId(){
        return this.roleId;
    }
    public String getRoleName(){
        return this.roleName;
    }
}
