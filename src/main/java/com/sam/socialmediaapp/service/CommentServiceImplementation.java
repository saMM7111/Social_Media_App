package com.sam.socialmediaapp.service;

import com.sam.socialmediaapp.Repository.CommentRepository;
import com.sam.socialmediaapp.Repository.PostRepository;
import com.sam.socialmediaapp.models.Comment;
import com.sam.socialmediaapp.models.Post;
import com.sam.socialmediaapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.Exceptions;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentServiceImplementation implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment createComment(Comment comment, Integer postid, Integer userid) throws Exception {
        User user = userService.findUserById(userid);
        Post post = postService.findPostById(postid);

        comment.setUser(user);
        comment.setContent(comment.getContent());
        comment.setCreatedAt(LocalDateTime.now());

        Comment savedComment = commentRepository.save(comment);
        post.getComments().add(savedComment);
        postRepository.save(post);
        return savedComment;
    }

    @Override
    public Comment likeComment(Integer userId, Integer commentId) throws Exception {
       Comment comment = findCommentById(commentId);
       User user = userService.findUserById(userId);

       if(!comment.getLiked().contains(user)){
            comment.getLiked().add(user);
       }else{
           comment.getLiked().remove(user);
       }
        return commentRepository.save(comment);
    }

    @Override
    public Comment findCommentById(Integer commentId) throws Exception {
        Optional<Comment> opt = commentRepository.findById(commentId);
        if(opt.isEmpty()){
            throw new Exception("Comment not Exist");
        }
        return opt.get();
    }
}
