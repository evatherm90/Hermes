<%-- 
    Document   : RegisterForm
    Created on : Oct 19, 2019, 2:50:16 PM
    Author     : antonis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register yea</title>
    </head>
    <body>
        <spring:form method="POST" modelAttribute="myuser"
                     action="${pageContext.request.contextPath}/register">
            <table>
                
                <tr>
                    <td>First name:</td>
                    <td><spring:input path="userfirstname"/></td>
                    <td><spring:errors path="userfirstname" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Last name:</td>
                    <td><spring:input path="userlastname"/></td>
                    <td><spring:errors path="userlastname" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><spring:input path="useremail"/></td>
                    <td><spring:errors path="useremail" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Username:</td>
                    <td><spring:input path="username"/></td>
                    <td><spring:errors path="username" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><spring:input path="userpassword"/></td>
                    <td><spring:errors path="userpassword" cssClass="error"/></td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" value="Save User"></td>
                </tr>
            </table>

        </spring:form>
    </body>
</html>
