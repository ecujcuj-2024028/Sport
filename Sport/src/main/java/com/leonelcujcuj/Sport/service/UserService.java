package com.leonelcujcuj.Sport.service;

import com.leonelcujcuj.Sport.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserByid(Integer id);
    User saveUser(User user);
    User updateUser(Integer id, User user);
    void deleteUser(Integer id);

}
