<%-- 
    Document   : usersTable
    Created on : Oct 15, 2019, 6:28:39 PM
    Author     : antonis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>


    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
            integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>
    <style>
        <%@ include file="../css/userTable.css"%>
    </style>


</head>
<body>
<div class="container">
    <div class="row card">
        <div class="col-md-12 card-header">
            
             <a href="<c:url value='/' />">Home Page</a>
             
             <h3>List of Users</h3>
        </div>
        <div class="table-responsive card-body">

            <table id="mytable" class="table table-borded table-striped">
                <thead class="color-head">
                <tr>
                    <th>first name</th>
                    <th>last name</th>
                    <th>email</th>
                    <th>username</th>
                    <th>role</th>
                    <th>edit</th>
                    <th>delete</th>
                </tr>
                </thead>
                <c:forEach items="${users}" var="user">
                    <tr class="color-head">
                        <td><c:out value="${user.userfirstname}"/></td>
                        <td><c:out value="${user.userlastname}"/></td>
                        <td><c:out value="${user.useremail}"/></td>
                        <td><c:out value="${user.username}"/></td>
                        <td><c:out value="${user.getRoleCollection().toString()}"/></td>
                        <td ><a id="color-green" href="<c:url value='/edit-${user.userid}-user' />">edit</a></td>
                        <td><a id="color-red" href="<c:url value='/delete-${user.userid}-user' />">delete</a></td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
