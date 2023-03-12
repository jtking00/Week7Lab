package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.User;
import models.Role;
import services.RoleService;
/**
 * @author 882199
 */
public class UserDB {
    
    public ArrayList<User> getUsers() throws Exception{
        ArrayList<User> users = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM user";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String email = rs.getString(1);
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String pass = rs.getString(4);
                int roleId = rs.getInt(5);
                RoleService rService = new RoleService();
                Role curRole = rService.getRole(roleId);
                User user = new User(email,fName,lName,pass,curRole);
                users.add(user);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return users;
    }
    
    public User getUser(String email) throws Exception{
        User user = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM user WHERE email=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if(rs.next()){
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String pass = rs.getString(4);
                int roleId = rs.getInt(5);
                RoleService rService = new RoleService();
                Role curRole = rService.getRole(roleId);
                user = new User(email,fName,lName,pass,curRole);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return user;
    }
    
    public void insertUser(User user) throws Exception{
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        String sql = "INSERT INTO user (email,first_name,last_name,password,role) VALUES (?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFName());
            ps.setString(3, user.getLName());
            ps.setString(4, user.getPass());
            ps.setInt(5, user.getUserRoleID());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    public void updateUser(User user) throws Exception{
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        String sql = "UPDATE user SET first_name=?, last_name=?, password=?, role=? WHERE email=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getFName());
            ps.setString(2, user.getLName());
            ps.setString(3, user.getPass());
            ps.setInt(4, user.getUserRoleID());
            ps.setString(5, user.getEmail());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    public void deleteUser(User user) throws Exception{
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        String sql = "DELETE FROM user WHERE email=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
}
