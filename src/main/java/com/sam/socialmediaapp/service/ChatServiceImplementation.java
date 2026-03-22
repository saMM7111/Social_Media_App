package com.sam.socialmediaapp.service;

import com.sam.socialmediaapp.Repository.ChatRepository;
import com.sam.socialmediaapp.models.Chat;
import com.sam.socialmediaapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImplementation implements ChatService {

    @Autowired
    private ChatRepository chatRepository;



    @Override
    public Chat createChat(User reqUser, User user2) {
        Chat isExist = chatRepository.findChatByUsersId(user2, reqUser);
        if(isExist != null){
            return isExist;
        }
        Chat chat = new Chat();
        chat.getUsers().add(user2);
        chat.getUsers().add(reqUser);
        chat.setTimestamp(LocalDateTime.now());
        return chatRepository.save(chat);
    }

    @Override
    public Chat findChatById(Integer chatid) throws Exception {
        Optional<Chat> opt = chatRepository.findById(chatid);
        if(!opt.isPresent()){
            throw new Exception("Chat doesn't exist with id " + chatid);
        }
        return opt.get();
    }

    @Override
    public List<Chat> findUserChat(Integer userid) {
        return chatRepository.findByUsersId(userid);
    }
}
