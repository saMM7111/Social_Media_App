package com.sam.socialmediaapp.controllers;

import ch.qos.logback.core.read.ListAppender;
import com.sam.socialmediaapp.models.Post;
import com.sam.socialmediaapp.models.User;
import com.sam.socialmediaapp.resopnse.ApiResponse;
import com.sam.socialmediaapp.service.PostService;
import com.sam.socialmediaapp.service.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @PostMapping("/api/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post,@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJWT(jwt);
        Post createdPost = postService.createNewPost(post,user.getId());
        return new ResponseEntity<>(createdPost, HttpStatus.OK);
    }

    @DeleteMapping("/api/posts/{postid}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postid, @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJWT(jwt);
        String message = postService.deletePost(postid,user.getId());
        ApiResponse res =  new ApiResponse(message,true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("posts/{postid}")
    public ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postid) throws Exception {
        Post post = postService.findPostById(postid);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("posts/users/{userid}")
    public ResponseEntity<List<Post>> findUserPosts(@PathVariable Integer userid) throws Exception {
        List<Post> posts = postService.findPostByUserId(userid);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


    @GetMapping("/posts")
    public ResponseEntity<List<Post>> findAllPosts() throws Exception {
        List<Post> posts = postService.findAllPost();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PutMapping("/posts/save/{postid}")
    public ResponseEntity<Post> savedPostdHandler(@PathVariable Integer postid, @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJWT(jwt);
        Post post = postService.savePost(postid,user.getId());
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/posts/like/{postid}")
    public ResponseEntity<Post> likePostdHandler(@PathVariable Integer postid, @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJWT(jwt);
        Post post = postService.likePost(postid,user.getId());
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
