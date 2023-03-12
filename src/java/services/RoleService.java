package services;

import dataaccess.RoleDB;
import models.Role;
/**
 * @author 882199
 */
public class RoleService {
    public Role getRole(int id) throws Exception {
        RoleDB roleDB = new RoleDB();
        Role curRole = roleDB.getRole(id);
        return curRole;
    }
}
