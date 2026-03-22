package com.sam.socialmediaapp.service;

import com.sam.socialmediaapp.Expections.UserException;
import com.sam.socialmediaapp.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User registerUser(User user);

    public User findUserById(Integer userid) throws UserException;

    public User findByEmail(String email);

    public User followUser(Integer userid1, Integer userid2) throws UserException;

    public User updateUser(User user, Integer userid) throws UserException;

    public List<User> searchUser(String query);

    public User findUserByJWT(String jwt);

}
