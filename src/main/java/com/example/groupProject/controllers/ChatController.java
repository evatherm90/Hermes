package com.example.groupProject.controllers;

import com.example.groupProject.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    
//    private SimpMessagingTemplate template;
//
//  @Autowired
//  public ChatController(SimpMessagingTemplate template) {
//    this.template = template;
//  }
//
//  @MessageMapping("/room/greeting/{room}")
//  public ChatMessage greet(@DestinationVariable String room, HelloMessage message) throws Exception {
//    Greeting greeting = new Greeting("Hello, " + message.getName() + "!");
//    this.template.convertAndSend("/topic/room/"+room, greeting);  
//  }


   
    @MessageMapping("/chat.sendMessage/{channelName}")
    @SendTo("/topic/{channelName}")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage,@DestinationVariable String channelName){
        return chatMessage;
    }
    
    
    @SendTo("/user/queue/{sendTo}")
    public ChatMessage sendPrivateMessage(@Payload ChatMessage chatMessage,@DestinationVariable String sendTo){
    simpMessagingTemplate.convertAndSendToUser(sendTo, "/user/queue/", chatMessage);
    return chatMessage;
    }   
//    user - the user that should receive the message.
//    destination - the destination to send the message to.
//    payload - the payload to send
    

    @MessageMapping("/chat.addUser/{channelName}")
    @SendTo("/topic/{channelName}")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor, @DestinationVariable String channelName){
        System.out.println("in chatcontroller channelname");
        System.out.println(channelName);
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
    
    
    
//    @MessageMapping("/chat.sendMessage")
//    @SendTo("/topic/public")
//    public ChatMessage sendMessage(@Payload ChatMessage chatMessage){
//        return chatMessage;
//    }
//
//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){
//        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//        return chatMessage;
//    }
    
}
