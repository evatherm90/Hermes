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
                
                 <a href="<c:url value='/joinhermespublicchat'/>" >Join our Chat</a>

                <a href="<c:url value='/joinchat'/>" >Create your Channel</a>
                
                <a href="<c:url value='/messageafriend'/>" >Message a friend</a>
                
                 <a href="<c:url value='/accountsettings'/>" >${user}</a>
                 
                <a href="<c:url value='/premium'/>" >Become Premium User</a>
                
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

                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed vulputate mi sit amet. Urna id volutpat lacus laoreet non curabitur gravida arcu. Rutrum tellus pellentesque eu tincidunt tortor. Eget duis at tellus at. Luctus venenatis lectus magna fringilla urna porttitor rhoncus dolor. Eu nisl nunc mi ipsum faucibus vitae aliquet. Id ornare arcu odio ut sem nulla pharetra diam. Non sodales neque sodales ut etiam sit amet. At augue eget arcu dictum. Etiam sit amet nisl purus in mollis nunc sed id. Dignissim cras tincidunt lobortis feugiat vivamus at augue eget arcu. Hac habitasse platea dictumst vestibulum rhoncus est pellentesque elit ullamcorper. In nulla posuere sollicitudin aliquam ultrices sagittis. Commodo elit at imperdiet dui accumsan sit. Enim ut sem viverra aliquet eget.

Molestie at elementum eu facilisis. Porttitor massa id neque aliquam vestibulum. Platea dictumst quisque sagittis purus sit amet volutpat consequat mauris. Ut morbi tincidunt augue interdum velit euismod in pellentesque. Imperdiet nulla malesuada pellentesque elit. Dui sapien eget mi proin sed libero. Pretium quam vulputate dignissim suspendisse in est ante. Sit amet porttitor eget dolor morbi. Gravida dictum fusce ut placerat orci nulla. Pharetra pharetra massa massa ultricies mi. Iaculis at erat pellentesque adipiscing commodo elit at imperdiet dui. Nec nam aliquam sem et tortor consequat id porta. Viverra ipsum nunc aliquet bibendum enim facilisis gravida neque. Quam pellentesque nec nam aliquam sem et tortor.

In cursus turpis massa tincidunt dui ut ornare. </p>
                    <p>Mauris pharetra et ultrices neque ornare. Integer quis auctor elit sed vulputate mi sit amet. Est velit egestas dui id ornare. Eget aliquet nibh praesent tristique magna sit amet purus. Enim ut sem viverra aliquet eget. Id nibh tortor id aliquet. Mauris nunc congue nisi vitae suscipit tellus. Cras ornare arcu dui vivamus arcu felis bibendum. Dui nunc mattis enim ut. Odio facilisis mauris sit amet massa vitae tortor. Mattis aliquam faucibus purus in.

Mauris in aliquam sem fringilla ut. At lectus urna duis convallis convallis. Nulla aliquet enim tortor at auctor urna. Adipiscing tristique risus nec feugiat. Nullam vehicula ipsum a arcu cursus vitae congue. Faucibus interdum posuere lorem ipsum dolor sit amet. A lacus vestibulum sed arcu non odio euismod lacinia. In egestas erat imperdiet sed euismod. Consequat ac felis donec et. Leo in vitae turpis massa sed.

Nunc id cursus metus aliquam. Orci ac auctor augue mauris augue neque gravida. Sit amet est placerat in egestas. Quam elementum pulvinar etiam non quam lacus. Elementum pulvinar etiam non quam lacus suspendisse faucibus interdum posuere. Eget mauris pharetra et ultrices neque ornare aenean euismod elementum. Neque ornare aenean euismod elementum nisi quis. Venenatis tellus in metus vulputate eu. Ut tellus elementum sagittis vitae et leo duis ut diam. Orci a scelerisque purus semper eget duis at tellus at. Felis eget velit aliquet sagittis id consectetur purus ut faucibus. Cursus eget nunc scelerisque viverra mauris in aliquam. Egestas quis ipsum suspendisse ultrices. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor lorem ipsum.</p>

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