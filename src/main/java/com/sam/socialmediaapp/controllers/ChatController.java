package com.sam.socialmediaapp.controllers;

import com.sam.socialmediaapp.Request.CreateChatRequest;
import com.sam.socialmediaapp.models.Chat;
import com.sam.socialmediaapp.models.User;
import com.sam.socialmediaapp.service.ChatService;
import com.sam.socialmediaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {
    @Autowired
    ChatService chatService;
    @Autowired
    UserService userService;


    @PostMapping("/api/chats")
    public Chat createChat(@RequestHeader("Authorization") String jwt, @RequestBody CreateChatRequest req) throws Exception {
        User reqUser = userService.findUserByJWT(jwt);
        User user2 = userService.findUserById(req.getUserid());
        Chat chat = chatService.createChat(reqUser, user2);
        return chat;
    }

    @GetMapping("/api/users/chats")
    public List<Chat> findUsersChat(@RequestHeader("Authorization")  String jwt) {
        User user = userService.findUserByJWT(jwt);
        List<Chat> chats = chatService.findUserChat(user.getId());
        return chats;
    }
}
