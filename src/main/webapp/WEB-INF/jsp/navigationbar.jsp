<%-- 
    Document   : navigationbar
    Created on : Nov 28, 2019, 9:49:53 PM
    Author     : antonis
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

       <section>
<nav id="nav" style='
    
    display: flex;
    justify-content: center;
    background-color: rgba(253, 253, 253, 0.78);
    width: 80vw;
    height: 10vh;
    display: flex;
    align-items: right;
    justify-content: center;
    color: white;'>
    <a href="/accountsettings" >${user}</a>
    <a href="<c:url value='/joinhermespublicchat'/>" >Join our Chat</a>
    <a href="<c:url value='/joinchat'/>" >Create your Channel</a>
    <a href="<c:url value='/premium'/>" >Become Premium User</a>
    <a href="<c:url value='/admin' />">Admin Dashboard</a>
    <a href="<c:url value='/logout' />">logout</a>

</nav>
</section>
    