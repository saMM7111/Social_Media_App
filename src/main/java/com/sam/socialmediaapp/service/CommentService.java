package com.sam.socialmediaapp.service;

import com.sam.socialmediaapp.models.Comment;

public interface CommentService {

    public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception;

    public Comment likeComment(Integer userId, Integer commentId) throws Exception;

    public Comment findCommentById(Integer commentId) throws Exception;


}
