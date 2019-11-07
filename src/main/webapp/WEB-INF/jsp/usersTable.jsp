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


        <script src="js/modal.js"></script>
    </head>
    <body>
        
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>first name</th>
                    <th>last name</th>
                    <th>email</th>
                    <th>username</th>
                    <th>edit</th>
                </tr>
            </thead>
            <c:forEach items="${result}" var="user">
                <tr>
                    <td><c:out value="${user.userid}" /></td>
                    <td><c:out value="${user.userfirstname}" /></td>
                    <td><c:out value="${user.userlastname}" /></td>
                    <td><c:out value="${user.useremail}" /></td>
                    <td><c:out value="${user.username}" /></td>
                    <td>
                        <button type="button" class="btn btn-info" id="editbtn" userid="${user.userid}">edit</button>
                    </td>
                </tr>
            </c:forEach>
        </table>



        <div id="modaledituser${user.userid}" class="modal fade">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title">Edit Book <span id="bookisbn"></span>
                        </h1>
                    </div>
                    <div class="modal-body">
                        <form  method="POST" action="">
                            <div class="form-group">
                                <label class="control-label">first name</label>
                                <div>
                                    <input type="text" class="form-control input-lg" name="userfirstname" value="" id="userfirstname"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label">last name</label>
                                <input type="text" class="form-control" name="lastname">
                                </select>
                            </div>
                            <div class="form-group">
                                <div>
                                    <button type="submit" class="btn btn-success">SAVE</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->


<!-- <table>
        <tr>
            <td>NAME</td><td>Joining Date</td><td>Salary</td><td>SSN</td><td></td>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
            <td>${employee.name}</td>
            <td>${employee.joiningDate}</td>
            <td>${employee.salary}</td>
            <td><a href="<c:url value='/edit-${employee.ssn}-employee' />">${employee.ssn}</a></td>
            <td><a href="<c:url value='/delete-${employee.ssn}-employee' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>-->

    </body>
</html>
