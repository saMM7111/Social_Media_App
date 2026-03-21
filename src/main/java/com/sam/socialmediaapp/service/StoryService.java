package com.sam.socialmediaapp.service;

import com.sam.socialmediaapp.models.Story;
import com.sam.socialmediaapp.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoryService {

    public Story createStory(Story story, User user);

    public List<Story> findStoryByUserId(Integer userid);
}
