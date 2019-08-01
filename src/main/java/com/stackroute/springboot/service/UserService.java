package com.stackroute.springboot.service;

import com.stackroute.springboot.domain.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public User getUserById(int id);

    public List<User> deleteUserById(int id);


}
