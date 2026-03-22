package com.sam.socialmediaapp.controllers;

import com.sam.socialmediaapp.Expections.UserException;
import com.sam.socialmediaapp.Repository.UserRepository;
import com.sam.socialmediaapp.models.User;
import com.sam.socialmediaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;



    @GetMapping("/api/users")
    public List<User> getUsers() {

        List<User> users = userRepository.findAll();
        return users;
    }

    @GetMapping("/api/users/{userid}")
    public User getUserById(@PathVariable("userid") Integer id) throws UserException {
        return userService.findUserById(id);
    }


    @PutMapping("/api/users")
    public User updateUser(@RequestBody User user, @RequestHeader("Authorization") String jwt) throws UserException {
        User reqUser = userService.findUserByJWT(jwt);
        User updateUser = userService.updateUser(user, reqUser.getId());
        return updateUser;
    }

    @PutMapping("/api/users/follow/{userid2}")
    public User followUser(@RequestHeader("Authorization") String jwt, @PathVariable Integer userid2) throws UserException {
        User reqUserid = userService.findUserByJWT(jwt);
        return userService.followUser(reqUserid.getId(), userid2);
    }

    @GetMapping("/api/users/search")
    public List<User> searchUser(@RequestParam("query") String query) {
        return userRepository.searchUser(query);
    }

    @GetMapping("/api/users/profile")
    public User getUserByEmail(@RequestHeader("Authorization") String jwt) {
        User user = userService.findUserByJWT(jwt);
        user.setPassword(null);// because you don't want ot send password in postman.
        return user;
    }
}
