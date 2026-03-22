package com.sam.socialmediaapp.service;

import com.sam.socialmediaapp.models.Chat;
import com.sam.socialmediaapp.models.User;

import java.util.List;

public interface ChatService {

    public Chat createChat(User reqUser, User user2);

    public Chat findChatById(Integer chatid) throws Exception;

    public List<Chat> findUserChat(Integer userid);
}
