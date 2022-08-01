package com.vartic.app.rest.controller;

import com.vartic.app.rest.entity.User;
import com.vartic.app.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userDetails")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        Integer id = service.saveUser(user);
        return new ResponseEntity<User>( user , HttpStatus.OK);
    }

    @GetMapping("/getUsersList")
    public ResponseEntity<List<User>> getAllUserDetails() {
        List<User> allUsers = service.getAllUsers();
        return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId) {
        User userById = service.getUserById(userId);
        return new ResponseEntity<User>(userById, HttpStatus.OK);
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Integer userId, User user) {
        User userData = service.getUserById(userId);
        userData.setFirstName(user.getFirstName());
        userData.setLastName(user.getLastName());
        userData.setEmail(user.getEmail());
        userData.setPassword(user.getPassword());
        userData.setSubscription(user.getSubscription());
        Integer id = service.saveUser(userData);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Integer userId) {
        service.deleteUser(userId);
        return new ResponseEntity<String>("User with id :'" + userId + "' has been deleted.", HttpStatus.OK);
    }
}
