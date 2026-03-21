package com.sam.socialmediaapp.controllers;

import com.sam.socialmediaapp.models.Comment;
import com.sam.socialmediaapp.models.User;
import com.sam.socialmediaapp.service.CommentService;
import com.sam.socialmediaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;


    @PostMapping("/api/comments/post/{postid}")
    public Comment createComment(@RequestBody Comment comment, @RequestHeader("Authorization")  String jwt, @PathVariable Integer postid) throws Exception {
        User user = userService.findUserByJWT(jwt);
        Comment ceratedComment = commentService.createComment(comment, postid, user.getId());

        return ceratedComment;
    }

    @PutMapping("/api/comments/like/{commentid}")
    public Comment likeComment(@RequestHeader("Authorization")  String jwt, @PathVariable Integer commentid) throws Exception {
        User user = userService.findUserByJWT(jwt);
        Comment likedComment = commentService.likeComment(user.getId(), commentid);
        return likedComment;
    }
}
