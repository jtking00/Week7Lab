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
        <table border="1">
            <tr>
                <th>Email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Role</th>
                <th>Edit User</th>
                <th>Delete User</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.role.roleName}</td>
                    <td>
                        <c:url value="/users" var="editUser">
                            <c:param name="email" value="${user.email}"/>
                            <c:param name="action" value="edit"/>
                        </c:url>
                        <a href=${editUser}>Edit</a>
                    </td>
                    <td>
                        <c:url value="/users" var="deleteUser">
                            <c:param name="email" value="${user.email}"/>
                            <c:param name="action" value="delete"/>
                        </c:url>
                        <a href=${deleteUser}>Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${curUser eq null}">
            <h2>Add User</h2>
            <form method="post" action="users">
                Email: <input type="text" name="newEmail"><br>
                First name: <input type="text" name="newFName"><br>
                Last name: <input type="text" name="newLName"><br>
                Password: <input type="password" name="newPass"><br>
                Role: <select name="newRole">
                    <option value="1">system admin</option>
                    <option value="2">regular user</option>
                </select>
                <input type="submit" value="Add user">
                <input type="hidden" name="action" value="add">
            </form>
        </c:if>
            
        <c:if test="${curAction eq 'edit'}">
            <h2>Edit User</h2>
            <form method="post" action="users">
                Email: ${curUser.email}<input type="hidden" name="newEmail" value="${curUser.email}"><br>
                First name: <input type="text" name="newFName" value="${curUser.firstName}"><br>
                Last name: <input type="text" name="newLName" value="${curUser.lastName}"><br>
                Password: <input type="password" name="newPass"><br>
                Role: <select name="newRole">
                    <c:if test="${curUser.role.roleId == 1}">
                        <option value="1" selected>system admin</option>
                        <option value="2">regular user</option>
                    </c:if>
                    <c:if test="${curUser.role.roleId == 2}">
                        <option value="1">system admin</option>
                        <option value="2" selected>regular user</option>
                    </c:if>
                </select>
                <input type="submit" value="Update">
                <input type="hidden" name="action" value="update">
                <a href="/"><input type="submit" value="Cancel"></a>
            </form>
        </c:if>
            <p>
                ${errorMsg}
            </p>
    </body>
</html>
