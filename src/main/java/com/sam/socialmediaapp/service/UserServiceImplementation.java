package com.sam.socialmediaapp.service;

import com.sam.socialmediaapp.Repository.UserRepository;
import com.sam.socialmediaapp.config.JwtProvider;
import com.sam.socialmediaapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        return userRepository.save(newUser);
    }

    @Override
    public User findUserById(Integer userid) throws Exception {
        Optional<User> user = userRepository.findById(userid);
        if(user.isPresent()){
            return user.get();
        }

        throw new Exception("user not exist with userid: "+userid);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User followUser(Integer reqUserid, Integer userid2) throws Exception {
        User reqUser = findUserById(reqUserid);
        User user2 = findUserById(userid2);

        user2.getFollowers().add(reqUser.getId());
        reqUser.getFollowers().add(user2.getId());
        userRepository.save(reqUser);
        userRepository.save(user2);
        return reqUser;
    }

    @Override
    public User updateUser(User user,  Integer userid) throws Exception {
        Optional<User> user1 =  userRepository.findById(userid);

        if(user1.isEmpty()){
            throw new Exception("user doesn't exist with userid: "+userid);
        }

        User oldUser = user1.get();

        if(user.getFirstName()!=null){
            oldUser.setFirstName(user.getFirstName());
        }
        if(user.getLastName()!=null){
            oldUser.setLastName(user.getLastName());
        }
        if(user.getEmail()!=null){
            oldUser.setEmail(user.getEmail());
        }
        if(user.getPassword()!=null){
            oldUser.setPassword(user.getPassword());
        }
        if(user.getGender()!=null){
            oldUser.setGender(user.getGender());
        }
        return userRepository.save(oldUser);
    }

    @Override
    public List<User> searchUser(String query) {
        return userRepository.searchUser(query);
    }

    @Override
    public User findUserByJWT(String jwt) {
        String email = JwtProvider.getEmailFromJwtToken(jwt);

        User user = userRepository.findByEmail(email);
        return user;
    }
}
