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

<!--            <a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>-->

        </div>

    </header>
    
<div id="container">
    <div id="success-box">
        <div class="dot"></div>
        <div class="dot two"></div>
            
        <span style="color:white;"><br><h1>Premium services</h1><br>
            To update to PREMIUM 100 points will be taken out of your balance.
                </span>
            
            
<!--        <button class="button-box"><a href="<c:url value='/balance' />">My balance</a></button>-->
        <p>Are you sure you want to</p> <button class="button-box"><a href="<c:url value='/payment' />"><h1 class="green">continue</h1></a></button>
    </div>
</div>

<!--        Go back to <a href="c:url value='/listofusers' />">List of All Users</a>-->

</body>
</html>

