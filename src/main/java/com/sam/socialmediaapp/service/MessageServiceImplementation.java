package com.sam.socialmediaapp.service;

import com.sam.socialmediaapp.Repository.ChatRepository;
import com.sam.socialmediaapp.Repository.MessageRepository;
import com.sam.socialmediaapp.models.Chat;
import com.sam.socialmediaapp.models.Message;
import com.sam.socialmediaapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class MessageServiceImplementation implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatRepository chatRepository;


    @Override
    public Message createMessage(User user, Integer chatid, Message req) throws Exception {
        Message message = new Message();

        Chat chat = chatService.findChatById(chatid);

        message.setChat(chat);
        message.setContent(req.getContent());
        message.setImage(req.getImage());
        message.setUser(user);
        message.setTimeStamp(LocalDateTime.now());
        Message savedMessages = messageRepository.save(message);
        chat.getMessages().add(savedMessages);
        chatRepository.save(chat);
        return savedMessages;
    }

    @Override
    public List<Message> findChatsMessages(Integer chatid) throws Exception {
        Chat chat =  chatService.findChatById(chatid);
        return messageRepository.findByChatId(chatid);
    }
}
