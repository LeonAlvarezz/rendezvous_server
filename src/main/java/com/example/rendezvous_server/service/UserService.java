package com.example.rendezvous_server.service;

import com.example.rendezvous_server.model.User;
import com.example.rendezvous_server.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public User saveUser(User user)
    {
        return userRepo.save(user);
    }

    public List<User> getAllUser()
    {
        List<User> userList = new ArrayList<>();
        Streamable.of(userRepo.findAll()).forEach(userList::add);
        return userList;
    }

    public User updateUser(int id, User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setUser_name(user.getUser_name());
        updatedUser.setUser_password(user.getUser_password());
        updatedUser.setMode(user.getMode());
        return userRepo.save(updatedUser);
    }

    public User getUserById(int id) {
        return userRepo.findById(id).get();
    }
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    public List<String> checkUserEmail(String email)
    {
        return userRepo.checkUserEmail(email);
    }

    public String checkUserPassword(String password)
    {
        return userRepo.checkUserPassword(password);
    }
    public User getUserInfo(String email)
    {
        return userRepo.getUserInfoByEmail(email);
    }
}
