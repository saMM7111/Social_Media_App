package com.sam.socialmediaapp.controllers;

import com.sam.socialmediaapp.models.Message;
import com.sam.socialmediaapp.models.User;
import com.sam.socialmediaapp.service.ChatService;
import com.sam.socialmediaapp.service.MessageService;
import com.sam.socialmediaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;
    @Autowired
    private ChatService chatService;


    @PostMapping("/api/messages/chat/{chatid}")
    public Message createMessage(@RequestBody Message req, @RequestHeader("Authorization") String jwt, @PathVariable Integer chatid) throws Exception {
        User user = userService.findUserByJWT(jwt);
        Message message = messageService.createMessage(user, chatid, req);
        return message;
    }

    @GetMapping("/api/messages/chat/{chatid}")
    public List<Message> findChatsMessages(@RequestHeader("Authorization") String jwt, @PathVariable Integer chatid) throws Exception {
        User user = userService.findUserByJWT(jwt);
        List<Message> messages = messageService.findChatsMessages(chatid);
        return messages;
    }
}
