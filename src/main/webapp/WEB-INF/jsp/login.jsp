<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Log in with your account</title>
    <link href="<c:url value="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"/>" rel="stylesheet"
          id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <style>
        <%@ include file="../css/login.css"%>
    </style>
</head>
<body>
<div class="container">
    <div class="d-flex justify-content-center h-100">
        <div class="card">
            <div class="card-header">
                <h3>Sign In</h3>
            </div>
            <div class="card-body">
                <form method="POST" action="${contextPath}/login" class="form-signin">

                    <div class="input-group form-group ${error != null ? 'has-error' : ''}">

                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true">
                        <br>
<!--                        <span class="errorMessge">${errorMessge}</span>-->
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input name="password" type="password" class="form-control" placeholder="Password">
                        <br>
                        <span class="errorMessge">${errorMessge}</span>
                    </div>
<!--                    <div class="row align-items-center remember">
                        <input type="checkbox">Remember Me
                    </div>-->
                    <br>

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="form-group">
                        <input type="submit" value="Login" class="btn float-right login_btn">
                    </div>
                </form>
            </div>
            <div class="card-footer">
                <div class="d-flex justify-content-center links">
                    Don't have an account?<a href="<c:url value='/newuser' />">Sign Up</a>
                </div>
<!--                <div class="d-flex justify-content-center links">
                    <a href="#">Forgot your password?</a>
                </div>-->
            </div>
        </div>
    </div>
</div>
</body>
</html>