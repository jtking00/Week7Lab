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
    }
}
