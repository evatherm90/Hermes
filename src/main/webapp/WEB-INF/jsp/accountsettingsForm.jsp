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
                        <h3>${user}</h3>
                    </div>
                    <div class="card-body">
                        <spring:form method="POST" modelAttribute="userprofile">
                            <%--                     action="${pageContext.request.contextPath}/register">--%>
                            <div class="input-group form-group">

                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>

                                <spring:input path="username" name="username" type="text" placeholder="Username" class="form-control"
                                              value='${user}'  autofocus="true"/>
                                <spring:errors path="username" cssClass="error"/>
                            </div>


                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <spring:input path="job" name="job" type="job" class="form-control"
                                              placeholder="Job"/>
                                <spring:errors path="job" cssClass="error"/>

                            </div>



                            <div class="input-group form-group">

                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>

                                <spring:input path="status" name="status" type="text" class="form-control"
                                              placeholder="Status" autofocus="true"/>
                                <spring:errors path="status" cssClass="error"/>
                            </div>

                            <!--                            <div class="input-group form-group">
                            
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text"><i class="fas fa-envelope"></i></span>
                                                            </div>
                                                            <input path="useremail" name="e-mail" type="text" class="form-control"
                                                                   placeholder="e-mail" autofocus="true"/>
                                                            <errors path="useremail" cssClass="error"/>
                            
                                                        </div>-->

                            <div class="form-group">
                                <input type="submit" value="Update" class="btn float-right login_btn">
                            </div>
                        </spring:form>
                    </div>
                    <div class="card-footer">
                        <div class="d-flex justify-content-center links">
                            Changed your mind?<a href="${contextPath}/accountsettings">Cancel</a>
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
