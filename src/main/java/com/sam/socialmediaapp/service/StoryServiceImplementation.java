package com.sam.socialmediaapp.service;

import com.sam.socialmediaapp.Repository.StoryRepository;
import com.sam.socialmediaapp.models.Story;
import com.sam.socialmediaapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class StoryServiceImplementation implements StoryService{
    @Autowired
    private StoryRepository storyRepository;
    @Autowired
    private UserService userService;

    @Override
    public Story createStory(Story story, User user) {
        Story createdStory = new Story();
        createdStory.setCaption(story.getCaption());
        createdStory.setImage(story.getImage());
        createdStory.setUser(user);
        createdStory.setTimestamp(LocalDateTime.now());
        return storyRepository.save(createdStory);
    }

    @Override
    public List<Story> findStoryByUserId(Integer userid) {
        return storyRepository.findByUserId(userid);
    }
}
