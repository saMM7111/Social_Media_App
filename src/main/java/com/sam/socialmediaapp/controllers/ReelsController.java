package com.sam.socialmediaapp.controllers;
import com.sam.socialmediaapp.models.Reels;
import com.sam.socialmediaapp.models.User;
import com.sam.socialmediaapp.service.ReelsService;
import com.sam.socialmediaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReelsController {
    @Autowired
    private ReelsService reelsService;
    @Autowired
    private UserService userService;

    @PostMapping("/api/reels")
    public Reels createReels(@RequestBody Reels reels, @RequestHeader("Authorization") String jwt) throws Exception{
        User user = userService.findUserByJWT(jwt);
        Reels createdReels = reelsService.createReels(reels, user);
        return createdReels;
    }

    @GetMapping("/api/reels")
    public List<Reels> findAllReels() throws Exception{
        return reelsService.findAllReels();
    }

    @GetMapping("/api/reels/user/{userid}")
    public List<Reels> findUsersReels(@PathVariable Integer userid) throws Exception{
        return reelsService.findUserReels(userid);
    }
}
