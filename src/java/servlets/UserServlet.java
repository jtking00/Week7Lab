package servlets;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import services.*;
import models.*;

/**
 * @author 882199
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RoleService rService = new RoleService();
        UserService uService = new UserService();
        String action = request.getParameter("action");
        
        if(action != null){
            switch(action){
                case "edit" : {
                    try {
                        String email = request.getParameter("email");
                        User user = uService.getUser(email);
                        request.setAttribute("curUser", user);
                        request.setAttribute("curAction", "edit");
                    } catch(Exception e) {
                        
                    }
                    break;
                }
                case "delete" : {
                    try{
                        String email = request.getParameter("email");
                        uService.deleteUser(email);
                    } catch(Exception e) {
                        
                    }
                    break;
                }
            }
        }
        try{
            ArrayList<User> users = uService.getUsers();
            request.setAttribute("users", users);
        } catch(Exception e) {
            
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RoleService rService = new RoleService();
        UserService uService = new UserService();
        String action = request.getParameter("action");
        
        String newEmail = request.getParameter("newEmail");
        String newFirstName = request.getParameter("newFName");
        String newLastName = request.getParameter("newLName");
        String newPass = request.getParameter("newPass");
        String newRole = request.getParameter("newRole");
        if(newEmail == null || newEmail.equals("")|| newFirstName == null || newFirstName.equals("") || newLastName == null || newLastName.equals("") || newPass == null || newPass.equals("")){
            request.setAttribute("errorMsg", "All Fields are required");
        }
        if(action != null){
            switch(action){
                case "add" : {
                    try {
                        ArrayList<User> users = uService.getUsers();
                        for(int i = 0; i < users.size(); i++){
                            if(newEmail.equals(users.get(i).getEmail())){
                                request.setAttribute("erroryMsg", "That email is already in use");
                            }
                        }
                        int newRoleId = Integer.parseInt(newRole);
                        Role role = rService.getRole(newRoleId);;
                        uService.insertUser(newEmail, newFirstName, newLastName, newPass, role);
                    } catch(Exception e) {
                        
                    }
                    break;
                }
                case "update" : {
                    try{
                        
                    } catch(Exception e) {
                        
                    }
                    break;
                }
            }
        }
        
        try{
            ArrayList<User> users = uService.getUsers();
            request.setAttribute("users", users);
        } catch(Exception e) {
            
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }
}
