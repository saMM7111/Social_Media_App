package com.sam.socialmediaapp.service;

import com.sam.socialmediaapp.Repository.ReelsRepository;
import com.sam.socialmediaapp.models.Reels;
import com.sam.socialmediaapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReelsServiceImplementation implements ReelsService {
    @Autowired
    private ReelsRepository reelsRepository;

    @Autowired
    private UserService userService;


    @Override
    public Reels createReels(Reels reels, User user) {
        Reels createReel = new Reels();
        createReel.setTitle(reels.getTitle());
        createReel.setUser(user);
        createReel.setVideo(reels.getVideo());

        return reelsRepository.save(createReel);
    }

    @Override
    public List<Reels> findAllReels() {
        return reelsRepository.findAll();
    }

    @Override
    public List<Reels> findUserReels(Integer userid) throws Exception {
        if(userid==null){
            throw new Exception("Userid doesn't exist");
        }
        return reelsRepository.findByUserId(userid);
    }
}
