<%-- 
    Document   : accessDenied.jsp
    Created on : Nov 21, 2019, 11:45:29 PM
    Author     : antonis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="xlink" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@ include file="../css/accessDenied.css"%>
    </style>
    <title>Title</title>
</head>
<body>
<svg xmlns="http://www.w3.org/2000/svg" id="robot-error" viewBox="0 0 260 118.9">
    <defs>
        <clippath id="white-clip">
            <circle id="white-eye" fill="#cacaca" cx="130" cy="65" r="20"></circle>
        </clippath>
        <text id="text-s" class="error-text" y="106"> 403</text>
    </defs>
    <path class="alarm" fill="#e62326" d="M120.9 19.6V9.1c0-5 4.1-9.1 9.1-9.1h0c5 0 9.1 4.1 9.1 9.1v10.6"></path>
    <use xlink:href="#text-s" x="-0.5px" y="-1px" fill="black"></use>
    <use xlink:href="#text-s" fill="#2b2b2b"></use>
    <g id="robot">
        <g id="eye-wrap">
            <use xlink:href="#white-eye"></use>
            <circle id="eyef" class="eye" clip-path="url(#white-clip)" fill="#000" stroke="#2aa7cc" stroke-width="2"
                    stroke-miterlimit="10" cx="130" cy="65" r="11"></circle>
            <ellipse id="white-eye" fill="#2b2b2b" cx="130" cy="40" rx="18" ry="12"></ellipse>
        </g>
        <circle class="lightblue" cx="105" cy="32" r="2.5" id="tornillo"></circle>
        <use xlink:href="#tornillo" x="50"></use>
        <use xlink:href="#tornillo" x="50" y="60"></use>
        <use xlink:href="#tornillo" y="60"></use>
    </g>
</svg>
<h1>You are not allowed to enter here</h1>
<h2>Go <a  href="<c:url value='/' />">Home!</a></h2>
<script>
    <%@ include file="../js/accessDenied.js"%>
</script>
</body>
</html>

