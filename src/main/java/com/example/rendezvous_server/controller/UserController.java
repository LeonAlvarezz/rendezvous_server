package com.example.rendezvous_server.controller;

import com.example.rendezvous_server.model.User;
import com.example.rendezvous_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("user/get")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping("user/save")
    public User saveUser(@RequestBody User user)
    {
        return userService.saveUser(user);
    }

    @PutMapping("user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user)
    {
        userService.updateUser(id, user);
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id)
    {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("user/login")
    public ResponseEntity<User> authenticateUser(@RequestBody User user)
    {
        List<String> userEmail = userService.checkUserEmail(user.getEmail());

        if(userEmail.isEmpty() || user.getEmail() == null)
        {

            return new ResponseEntity("Account Doesn't Exist", HttpStatus.NOT_FOUND);
        }

        String userPassword = userService.checkUserPassword(user.getUser_password());
        if(userPassword == null)
        {
            return new ResponseEntity("Incorrect Password", HttpStatus.BAD_REQUEST);
        } else if (!userPassword.equals(user.getUser_password()))
        {
            return new ResponseEntity("Incorrect Password", HttpStatus.NO_CONTENT);
        } else
        {
            User users = userService.getUserInfo(user.getEmail());
            return new ResponseEntity<User>(users, HttpStatus.OK) ;
        }

    }
}
