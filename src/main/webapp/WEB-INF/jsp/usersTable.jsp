<%-- 
    Document   : usersTable
    Created on : Oct 15, 2019, 6:28:39 PM
    Author     : antonis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>



    </head>
    <body>

        <table>
            <thead>
                <tr>
                    <th>first name</th>
                    <th>last name</th>
                    <th>email</th>
                    <th>username</th>
                    <th>edit</th>
                    <th>delete</th>
                </tr>
            </thead>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.userfirstname}" /></td>
                    <td><c:out value="${user.userlastname}" /></td>
                    <td><c:out value="${user.useremail}" /></td>
                    <td><c:out value="${user.username}" /></td>
                    <td>
                    <td><a href="<c:url value='/edit-${user.userid}-user' />">edit</a></td>
                    <td><a href="<c:url value='/delete-${user.userid}-user' />">delete</a></td>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
