package com.sam.socialmediaapp.service;

import com.sam.socialmediaapp.Repository.ReelsRepository;
import com.sam.socialmediaapp.models.Reels;
import com.sam.socialmediaapp.models.User;

import java.util.List;

public interface ReelsService{

    public Reels createReels(Reels reels, User user);

    public List<Reels> findAllReels();

    public List<Reels> findUserReels(Integer userid) throws Exception;
}
