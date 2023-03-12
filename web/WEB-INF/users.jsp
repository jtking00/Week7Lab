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
        <table>
            <tr>
                <th>Email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Role</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${users}" var="user">
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.fName}"/></td>
                <td><c:out value="${user.lName}"/></td>
                <td><c:out value="${user.role.roleName}"/></td>
                <td></td>
                <td></td>
            </c:forEach>
        </table>
        <h2>Add User</h2>
        <form method="post" action="">
            Email: <input type="text" name="newEmail">
            First name: <input type="text" name="newFName">
            Last name: <input type="text" name="newLName">
            Password: <input type="password" name="newPass">
            Role: <select name="newRole">
                    <option value="1">system admin</option>
                    <option value="2">regular user</option>
                </select>
            <input type="submit" value="Add user">
            <input type="hidden" name="action" value="add">
        </form>
    </body>
</html>
