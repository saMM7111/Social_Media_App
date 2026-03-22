package com.sam.socialmediaapp.service;

import com.sam.socialmediaapp.models.Chat;
import com.sam.socialmediaapp.models.Message;
import com.sam.socialmediaapp.models.User;

import java.util.List;

public interface MessageService {

    public Message createMessage(User user, Integer chatid, Message req) throws Exception;

    public List<Message> findChatsMessages(Integer chatid) throws Exception;
}
