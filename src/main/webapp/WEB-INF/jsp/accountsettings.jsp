<%-- 
    Document   : accountsettings
    Created on : Nov 28, 2019, 3:57:48 AM<td><a href="<c:out value='/privatechat-${userr.username}' />" />${userr.username}</a></td>
    Author     : antonis
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register your new Account</title>
        <link href="<c:url value="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"/>" rel="stylesheet"
              id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <!--Bootsrap 4 CDN-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <!--Fontawesome CDN-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
              integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <!--Custom styles-->
        <style>
            <%@ include file="../css/registerForm.css"%>
            #nav {
                display: inline-flex;
            }
        </style>
    </head>
    <body>
        
        <header id="header">

        <div class="inner">

            <nav id="nav">

                <a href="<c:url value='/accountsettings'/>" ><h3>${user.username}   </h3></a>
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

        
        <div class="card" id="accountsettings" >
            <div class="card-header">
                <h3>${user.username} account settings</h3>
            </div>
             <div class="card-body">
            <ul style="color:white;">
                <li>My username: ${userprofile.username}</li>
                <li>My job: ${userprofile.job} </li>
                <li>My status: ${userprofile.status} </li>
                <li>My membership: ${role} </li>
                <li>My balance: ${user.wallet} points</li>
                <li>My email: ${user.useremail}</li>
                <!--<li>My channels: </li>-->
            </ul>
            <div class="form-group">
                <a href="<c:url value='/editUserprofile' />" class="btn float-right login_btn">Edit</a>
            </div>
            
            <table>
            <thead>
                <tr>
                    <th style="color:white;">My Contacts:</th>    
                </tr>
            </thead>
            <c:forEach items="${userrs}" var="userr">
                <tr style="color:white;">
                    <td><a href="<c:url value='/privatechat-${userr.username}'/>" >Message ${userr.username} </a></td>
                    
                </tr>
            </c:forEach>
        </table>
           
             </div>
        </div>
            
    </body>
</html>
