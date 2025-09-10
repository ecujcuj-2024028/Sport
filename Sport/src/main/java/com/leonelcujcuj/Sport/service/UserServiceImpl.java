package com.leonelcujcuj.Sport.service;

import com.leonelcujcuj.Sport.model.User;
import com.leonelcujcuj.Sport.repository.UserRepositoriy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepositoriy userRepositoriy;

    public UserServiceImpl(UserRepositoriy userRepositoriy) {
        this.userRepositoriy = userRepositoriy;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepositoriy.findAll();
    }

    @Override
    public User getUserByid(Integer id) {
        return userRepositoriy.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        if (userRepositoriy.findByFirstName(user.getFirstName()).isPresent()) {
            throw new IllegalArgumentException("El nombre ya existe");
        }
        if (userRepositoriy.findByLastName(user.getLastName()).isPresent()) {
            throw new IllegalArgumentException("El apellido ya existe");
        }
        if (userRepositoriy.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email ya existe");
        }
        return userRepositoriy.save(user);
    }


    @Override
    public User updateUser(Integer id, User user) {
        User existinUser = userRepositoriy.findById(id).orElse(null);
            if (existinUser!=null){
                existinUser.setFirstName(user.getFirstName());
                existinUser.setLastName(user.getLastName());
                existinUser.setEmail(user.getEmail());
                return userRepositoriy.save(existinUser);
            }
        return null;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepositoriy.deleteById(id);
    }
}
