<%-- 
    Document   : index
    Created on : Nov 8, 2019, 10:08:12 PM
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
        <h1>Hello World!</h1>
        <a href="<c:url value='/listofusers' />">see users</a>
        <br/>
        <a href="<c:url value='/newuser' />">register</a>
        <br/>
        <a href="<c:url value='/joinchat'>"  Join our chat!</a>
        
    </body>
</html>
