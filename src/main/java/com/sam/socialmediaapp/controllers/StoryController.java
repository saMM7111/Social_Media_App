package com.sam.socialmediaapp.controllers;

import com.sam.socialmediaapp.models.Story;
import com.sam.socialmediaapp.models.User;
import com.sam.socialmediaapp.service.StoryService;
import com.sam.socialmediaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoryController {
    @Autowired
    private StoryService storyService;
    @Autowired
    private UserService userService;

    @PostMapping("/api/story")
    public Story createStory(@RequestBody Story story, @RequestHeader("Authorization") String jwt) {
        User user = userService.findUserByJWT(jwt);
        return storyService.createStory(story, user);
    }

    @GetMapping("/api/story/user/{userid}")
    public List<Story> findUserStory(@PathVariable Integer userid, @RequestHeader("Authorization") String jwt) {
        User user = userService.findUserByJWT(jwt);
        return storyService.findStoryByUserId(user.getId());
    }
}
