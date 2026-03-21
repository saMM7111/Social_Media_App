package com.sam.socialmediaapp.service;

import com.sam.socialmediaapp.models.Post;

import java.util.List;

public interface PostService {

    Post createNewPost(Post post, Integer userid) throws Exception;

    String deletePost(Integer postid, Integer userdid) throws Exception;

    List<Post> findPostByUserId(Integer userid);

    Post findPostById(Integer postid) throws Exception;

    List<Post> findAllPost();

    Post savePost(Integer postid, Integer userid) throws Exception;

    Post likePost(Integer postid, Integer userid) throws Exception;

}
