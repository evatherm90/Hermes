<%-- 
    Document   : chatindex
    Created on : Nov 15, 2019, 9:18:10 PM
    Author     : antonis
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
        <title>Spring Boot WebSocket Chat Application | CalliCoder</title>
        <link rel="stylesheet" href="main.css" />
    </head>
    <body>
        <noscript>
        <h2>Sorry! Your browser doesn't support Javascript</h2>
        </noscript>

        <div id="username-page">
            <div class="username-page-container">
                <h1 class="title">${user}</h1>
                <form id="usernameForm" name="usernameForm">
                    <div class="form-group">
                        <!--                <input type="text" id="name" placeholder="Username" autocomplete="off" class="form-control" />-->
                        <input type="hidden" id="name" value='${user}'/>
                        <input type="text" id="channelName" placeholder="Channel Name" />
                    </div>
                    <div class="form-group">
                        <button type="submit" class="accent username-submit">Start Chatting</button>
                    </div>
                </form>
            </div>
        </div>

        <div id="chat-page" class="hidden">
            <div class="chat-container">
                <div class="chat-header">
                    <h2 id="channame">Channel</h2>
                </div>
                <div class="connecting">
                    Connecting...
                </div>
                <ul id="messageArea">

                </ul>
                <form id="messageForm" name="messageForm" nameForm="messageForm">
                    <div class="form-group">
                        <div class="input-group clearfix">
                            <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>
                            <button type="submit" class="primary">Send</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
        <script src="main.js"></script>
    </body>
</html>