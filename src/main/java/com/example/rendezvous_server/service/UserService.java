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

    public User getUserById(int id) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

}
