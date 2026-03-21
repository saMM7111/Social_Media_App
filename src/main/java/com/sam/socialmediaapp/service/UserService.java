package com.sam.socialmediaapp.service;

import com.sam.socialmediaapp.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User registerUser(User user);

    public User findUserById(Integer userid) throws Exception;

    public User findByEmail(String email);

    public User followUser(Integer userid1, Integer userid2) throws Exception;

    public User updateUser(User user, Integer userid) throws Exception;

    public List<User> searchUser(String query);

    public User findUserByJWT(String jwt);

}
