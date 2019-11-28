//'use strict';
//
//var usernamePage = document.querySelector('#username-page');
//var chatPage = document.querySelector('#chat-page');
//var usernameForm = document.querySelector('#usernameForm');
//var messageForm = document.querySelector('#messageForm');
//var messageInput = document.querySelector('#message');
//var messageArea = document.querySelector('#messageArea');
//var connectingElement = document.querySelector('.connecting');
//
//var stompClient = null;
//var username = null;
//var sendTo = null;
//var colors = [
//    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
//    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
//];
//
//function connect(event) {
//    event.preventDefault();
//    console.log("connect");
//    username = document.querySelector('#name').value.trim();
//    sendTo = document.querySelector('#sendTo').value.trim();
//    console.log(sendTo);
//    if(username) {
//        usernamePage.classList.add('hidden');
//        chatPage.classList.remove('hidden');
//
//        var socket = new SockJS('/groupProject/ws');
//        stompClient = Stomp.over(socket);
//
//        stompClient.connect({}, onConnected, onError);
//    }
//    
//}
//
//
//function onConnected() {
// sendTo = document.querySelector('#sendTo').value.trim();
// document.getElementById("sendTo").innerHTML = "Send a message to "+sendTo; 
//     console.log("Connected");
//    // Subscribe to the Public Topic
//    stompClient.subscribe("/user/queue", onMessageReceived);
//
//    // Tell your username to the server
//    
//    //stompClient.send("/app/chat.addUser/"+channelName,
////        stompClient.send("/user/"+sendTo+"/queue/private",
////        {},
////        JSON.stringify({sender: username, type: 'JOIN'})
////    );
////
////    connectingElement.classList.add('hidden');
////    connectingElement.textContent = 'Connected!';
////    connectingElement.style.color = 'red';
//    
//   
//}
//
//
//function onError(error) {
//    
//    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!'+error;
//    connectingElement.style.color = 'red';
//}
//
//
//function sendMessage(event) {
//    var messageContent = messageInput.value.trim();
//    sendTo = document.querySelector('#sendTo').value.trim();
//    if(messageContent && stompClient) {
//        var chatMessage = {
//            sender: username,
//            content: messageInput.value,
//            type: 'CHAT'
//        };
//
//        stompClient.send("/user/queue/"+sendTo, {}, JSON.stringify(chatMessage));
//        messageInput.value = '';
//    }
//    event.preventDefault();
//    console.log("send to app");
//}
//
//
//function onMessageReceived(payload) {
//    
//    var message = JSON.parse(payload.body);
//    console.log(message);
//    var messageElement = document.createElement('li');
//
//    if(message.type === 'JOIN') {
//        messageElement.classList.add('event-message');
//        message.content = message.sender + ' is online!';
//    } else if (message.type === 'LEAVE') {
//        messageElement.classList.add('event-message');
//        message.content = message.sender + ' left!';
//    } else {
//        messageElement.classList.add('chat-message');
//
//        var avatarElement = document.createElement('i');
//        var avatarText = document.createTextNode(message.sender[0]);
//        avatarElement.appendChild(avatarText);
//        avatarElement.style['background-color'] = getAvatarColor(message.sender);
//
//        messageElement.appendChild(avatarElement);
//
//        var usernameElement = document.createElement('span');
//        var usernameText = document.createTextNode(message.sender);
//        usernameElement.appendChild(usernameText);
//        messageElement.appendChild(usernameElement);
//    }
//
//    var textElement = document.createElement('p');
//    var messageText = document.createTextNode(message.content);
//    textElement.appendChild(messageText);
//
//    messageElement.appendChild(textElement);
//
//    messageArea.appendChild(messageElement);
//    messageArea.scrollTop = messageArea.scrollHeight;
//}
//
//
//function getAvatarColor(messageSender) {
//    var hash = 0;
//    for (var i = 0; i < messageSender.length; i++) {
//        hash = 31 * hash + messageSender.charCodeAt(i);
//    }
//
//    var index = Math.abs(hash % colors.length);
//    return colors[index];
//}
//
//usernameForm.addEventListener('submit', connect, true);
//messageForm.addEventListener('submit', sendMessage, true);
//
let stompClient = null;


const connect = () => {

    let socket = new SockJS("/chat");

    stompClient = Stomp.over(socket);

    stompClient.connect(

        {}, function (frame) {

            console.log('Connected: ' + frame);

            stompClient.subscribe("/user/queue/errors", function (message) {

            });

            stompClient.subscribe("/user/queue/private", function (message) {

                console.log(message.body);

                const data = JSON.parse(message.body);

               

            });

        }

    );

}

//sent to -> from principal

const sendPrivateMessage = (sendTo, data) => {

    stompClient.send("/user/" + sendTo + "/queue/private", {}, JSON.stringify(data));

    return (data);

}


const disconnect = () => {

    if (stompClient != null) {

        stompClient.disconnect();

    }

    console.log("Disconnected");

}