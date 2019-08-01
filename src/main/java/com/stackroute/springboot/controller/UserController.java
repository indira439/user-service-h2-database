package com.stackroute.springboot.controller;


import com.stackroute.springboot.domain.User;
import com.stackroute.springboot.service.UserService;
import com.stackroute.springboot.service.UserServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class UserController {

   private UserService userService;

   @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
            User savedUser = userService.saveUser(user);
            return new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
       User retrieveUser = userService.getUserById(id);
       return new ResponseEntity<User>(retrieveUser,HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") int id) {
        List<User> usersList = userService.deleteUserById(id);
        return new ResponseEntity<>(usersList,HttpStatus.OK);
    }

}
