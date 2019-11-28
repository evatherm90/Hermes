<%-- 
    Document   : success
    Created on : Nov 8, 2019, 11:25:07 PM
    Author     : antonis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        <%@ include file="../css/success.css"%>
    </style>
</head>
<body>
<div id="container">
    <div id="success-box">
        <div class="dot"></div>
        <div class="dot two"></div>
        <div class="face">
            <div class="eye"></div>
            <div class="eye right"></div>
            <div class="mouth sad"></div>
        </div>
        <div class="shadow scale"></div>
        <div class="message"><h1 class="alertfail">Failure!</h1>
            <p>${failure}</p></div>
        <button class="button-box"><a href="<c:url value='/editUserprofile' />"><h1 class="green">Try again!</h1></a></button>
    </div>
</div>

<!--        Go back to <a href="c:url value='/listofusers' />">List of All Users</a>-->

</body>
</html>

