package com.example.pp_3122.service;

import com.example.pp_3122.model.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public void deleteUserById(Long userId);

    public User changeUser(User user);

    public List<User> findAll();

    public User findUserById (Long id);
}
