package com.stackroute.springboot.service;

import com.stackroute.springboot.domain.User;
import com.stackroute.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplements implements UserService {

    private UserRepository userRepository;

    //    @Autowired
    public UserServiceImplements(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User getUserById(int id) {
        User retrieveUser = userRepository.findById(id).get();
        return retrieveUser;
    }

    @Override
    public List<User> deleteUserById(int id) {
        userRepository.deleteById(id);
        return userRepository.findAll();
    }
}
