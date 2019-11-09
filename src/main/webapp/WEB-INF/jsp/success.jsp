<%-- 
    Document   : success
    Created on : Nov 8, 2019, 11:25:07 PM
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
        message : ${success}
        <br/>
        <br/>
        Go back to <a href="<c:url value='/listofusers' />">List of All Users</a>

    </body>
</html>
