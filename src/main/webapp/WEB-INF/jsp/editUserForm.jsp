<%-- 
    Document   : RegisterForm
    Created on : Oct 19, 2019, 2:50:16 PM
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
    </style>
</head>
<body>
<div class="container">
    <div class="d-flex justify-content-center h-100">
        <div class="card">
            <div class="card-header">
                <h3>Edit User</h3>
            </div>
            <div class="card-body">
                <spring:form method="POST" modelAttribute="user">
                    <%--                     action="${pageContext.request.contextPath}/register">--%>
                    <div class="input-group form-group">

                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>

                        <spring:input path="userfirstname" name="firstname" type="text" class="form-control"
                                      placeholder="First Name" autofocus="true"/>
                        <spring:errors path="userfirstname" cssClass="error"/>
                    </div>

                    <div class="input-group form-group">

                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <spring:input path="userlastname" name="lastname" type="text" class="form-control"
                                      placeholder="Last Name" autofocus="true"/>
                        <spring:errors path="userlastname" cssClass="error"/>
                    </div>

                    <div class="input-group form-group">

                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-envelope"></i></span>
                        </div>
                        <spring:input path="useremail" name="e-mail" type="text" class="form-control"
                                      placeholder="e-mail" autofocus="true"/>
                        <spring:errors path="useremail" cssClass="error"/>

                    </div>

                    <div class="input-group form-group">

                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>

                        <spring:input path="username" name="username" type="text" class="form-control"
                                      placeholder="Username" autofocus="true"/>
                        <spring:errors path="username" cssClass="error"/>
                    </div>

                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <spring:input path="userpassword" name="password" type="password" class="form-control"
                                      placeholder="Password"/>
                        <spring:errors path="userpassword" cssClass="error"/>

                    </div>

                    <div class="form-group">
                        <input type="submit" value="Update" class="btn float-right login_btn">
                    </div>

                </spring:form>
            </div>
            <div class="card-footer">
                <div class="d-flex justify-content-center links">
                   <a href="${contextPath}/listofusers">Cancel</a>
                </div>
<!--                <div class="d-flex justify-content-center links">
                    <a href="#">Forgot your Account?</a>
                </div>-->
            </div>
        </div>
    </div>
</div>
</body>
</html>
