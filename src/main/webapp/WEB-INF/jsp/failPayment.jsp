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
    
     <header id="header">

        <div class="inner">

            <nav id="nav">

                <a href="<c:url value='/accountsettings'/>" ><h3>${user}</h3></a>
                 <a href="<c:url value='/' />">Home Page</a>
                 <a href="<c:url value='/joinhermespublicchat'/>" >Join our Chat</a>

                <a href="<c:url value='/joinchat'/>" >Create your Channel</a>
                
                
                
               
                 
                <a href="<c:url value='/premium'/>" >Become Premium User</a>
                 <a href="<c:url value='/admin' />">Admin Dashboard</a>
                
                <a href="<c:url value='/logout' />">Logout</a>

            </nav>

            <a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>

        </div>

    </header>
    
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
            <p>${resultMessage}</p></div>
        <button class="button-box"><a href="<c:url value='/' />"><h1 class="green">Got it!</h1></a></button>
    </div>
</div>

<!--        Go back to <a href="c:url value='/listofusers' />">List of All Users</a>-->

</body>
</html>

