<%-- 
    Document   : users
    Created on : 28-Feb-2023, 9:45:09 AM
    Author     : 882199
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h1>Manage Users</h1>
            
        <h2>Add User</h2>
        <form method="post" action="">
            Email: <input type="text" name="newEmail">
            First name: <input type="text" name="newFName">
            Last name: <input type="text" name="newLName">
            Password: <input type="password" name="newPass">
            Role: <input type="" name="newRole">
            <input type="submit" name="newUser" value="Add user">
        </form>
    </body>
</html>
