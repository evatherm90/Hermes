<%-- 
    Document   : index
    Created on : Nov 8, 2019, 10:08:12 PM
    Author     : antonis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <style>

            <%@ include file="../indexAssets/css/main.css"%>

        </style>

        <title>JSP Page</title>

        

    </head>

    <body>

    <!-- Header -->

    <header id="header">

        <div class="inner">

            <nav id="nav">

                <a href="<c:url value='/admin' />">Admin Dashboard</a>

                <a href="<c:url value='/joinchat'/>" >Join our chat</a>

                <a href="<c:url value='/payment'/>" >Become Premium User</a>

                <a href="<c:url value='/logout' />">logout</a>

            </nav>

            <a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>

        </div>

    </header>

    <!-- Banner -->

    <section id="banner">

        <h1>Welcome to Hermes</h1>

    </section>

    <!-- One -->

    <section id="one" class="wrapper">

        <div class="inner">

            <header class="align-center">

                <h2>About Us</h2>

                <p>Information about the Developers Team</p>

            </header>

            <div class="flex flex-3">

                <article>

                    <header>

                        <h3>Apostolos<br/>Lampiris</h3>

                    </header>

                    <p>Morbi interdum mollis sapien. Sed ac risus. Phasellus lacinia, magna a ullamcorper laoreet, lectus arcu.</p>

                </article>

                <article>

                    <header>

                        <h3>Eva<br/>Thermou</h3>

                    </header>

                    <p>Morbi interdum mollis sapien. Sed ac risus. Phasellus lacinia, magna a ullamcorper laoreet, lectus arcu.</p>

                </article>

                <article>

                    <header>

                        <h3>Dimitris<br/>Tosiadis</h3>

                    </header>

                    <p>Morbi interdum mollis sapien. Sed ac risus. Phasellus lacinia, magna a ullamcorper laoreet, lectus arcu.</p>

                </article>

            </div>

        </div>

    </section>

    <!-- Two -->

    <section id="two" class="wrapper style1 special">

        <div class="inner">

            <header>

                <h2>Hermes<br>Developers</h2>

            </header>

            <div class="flex flex-4">

                <div class="box person">

                    <div class="image round">

                        <img src="../images/Akis.JPG" alt="Person 1" />

                    </div>

                    <h3>Apostolos Lampiris</h3>

                    <p>Database / Front-End</p>

                </div>

                <div class="box person">

                    <div class="image round">

                        <img src="<c:url value='/images/Eva.jpg'/>" alt="Person 2" />

                    </div>

                    <h3>Eva Thermou</h3>

                    <p>Back-End</p>

                </div>

                <div class="box person">

                    <div class="image round">

                        <img src="../images/pic05.jpg" alt="Person 3" />

                    </div>

                    <h3>Dimitris Tosiadis</h3>

                    <p>Front-End / Cordinator</p>

                </div>

            </div>

        </div>

    </section>

    <!-- Three -->

    <section id="three" class="wrapper special">

        <div class="inner">

            <header class="align-center">

                <h2>Hermes Chat Application</h2>

                <p>Speak with your friends when you are far away!!</p>

            </header>

            <div class="flex">

                <article>

                    <div class="image fit">

                        <img src="../images/laptop.jpg" alt="Pic 01" />

                    </div>

                    <header>

                        <h3>About Hermes</h3>

                    </header>

                    <p>Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor lorem ipsum.</p>

                </article>

            </div>

        </div>

    </section>

    <!-- Footer -->

    <footer id="footer">

        <div class="inner">

            <div class="flex">

                <div class="copyright">

                    &copy; Untitled. Design by Hermes Developers Team. Images: <a href="https://unsplash.com">Unsplash</a>.

                </div>

                <ul class="icons">

                    <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>

                    <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>

                    <li><a href="#" class="icon fa-linkedin"><span class="label">linkedIn</span></a></li>

                    <li><a href="#" class="icon fa-pinterest-p"><span class="label">Pinterest</span></a></li>

                    <li><a href="#" class="icon fa-vimeo"><span class="label">Vimeo</span></a></li>

                </ul>

            </div>

        </div>

    </footer>

    <!-- Scripts -->

    <script src="../indexAssets/js/jquery.min.js"></script>

    <script src="../indexAssets/js/skel.min.js"></script>

    <script src="../indexAssets/js/util.js"></script>

    <script src="../indexAssets/js/main.js"></script>

    </body>

</html>