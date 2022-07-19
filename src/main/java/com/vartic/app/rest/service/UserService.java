package com.vartic.app.rest.service;

import com.vartic.app.rest.entity.User;
import com.vartic.app.rest.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public Integer saveUser(User user) {
        return repository.save(user).getUserID();
    }


    public List<User> getAllUsers() {
        return (List<User>) repository.findAll();
    }


    public User getUserById(Integer userId) {
        return repository.findById(userId).get();
    }


    public void deleteUser(Integer userId) {
        repository.deleteById(userId);
    }


}
