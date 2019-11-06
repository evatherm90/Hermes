<%-- 
    Document   : LoginForm
    Created on : Oct 19, 2019, 2:50:39 PM
    Author     : antonis
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
         <spring:form method="POST" modelAttribute="myuser"
                     action="${pageContext.request.contextPath}/login">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input path="username"/></td>
                    <td><errors path="username" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input path="userpassword"/></td>
                    <td><errors path="userpassword" cssClass="error"/></td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" value="Login User"></td>
                </tr>
            </table>
            <span>Forgot <a href="#">password?</a></span>
         </spring:form>
    </body>
</html>
