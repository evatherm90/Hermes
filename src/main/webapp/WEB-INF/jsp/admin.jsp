<%-- 
    Document   : admin
    Created on : Nov 21, 2019, 11:56:23 PM
    Author     : antonis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                                                                                                                         <style>
        <%@ include file="../css/admin.css"%>
    </style>
    <title>JSP Page</title>
</head>
<body>
    
<h1>Hello ${user}!</h1>
<h3><a href="<c:url value='/listofusers' />">Manage All Users</a></h3>
<h4><a href="<c:url value='/' />">Return Home</a></h4>
   
<div class="container">
    <div class="coffee-header">
        <div class="coffee-header__buttons coffee-header__button-one"></div>
        <div class="coffee-header__buttons coffee-header__button-two"></div>
        <div class="coffee-header__display"></div>
        <div class="coffee-header__details"></div>
    </div>
    <div class="coffee-medium">
        <div class="coffe-medium__exit"></div>
        <div class="coffee-medium__arm"></div>
        <div class="coffee-medium__liquid"></div>
        <div class="coffee-medium__smoke coffee-medium__smoke-one"></div>
        <div class="coffee-medium__smoke coffee-medium__smoke-two"></div>
        <div class="coffee-medium__smoke coffee-medium__smoke-three"></div>
        <div class="coffee-medium__smoke coffee-medium__smoke-for"></div>
        <div class="coffee-medium__cup"></div>
    </div>
    <div class="coffee-footer"></div>
</div>

</body>
</html>
