<%-- 
    Document   : admin
    Created on : Nov 21, 2019, 11:56:23 PM
    Author     : antonis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${user}!</h1>
        <a href="<c:url value='/listofusers' />">see users</a>
    </body>
</html>
