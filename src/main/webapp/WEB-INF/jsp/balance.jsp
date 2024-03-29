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
        <p>Your balance is ${balance}</p>
        <div class="shadow scale"></div>
        <button class="button-box"><a href="<c:url value='/balance' />"></a></button>
        Are you sure you want to <button class="button-box"><a href="<c:url value='/payment' />"><h1 class="green">continue</h1></a></button>
    </div>
    <button class="button-box"><a href="<c:url value='/' />">exit</a></button>
  
</div>

<!--        Go back to <a href="c:url value='/listofusers' />">List of All Users</a>-->

</body>
</html>

