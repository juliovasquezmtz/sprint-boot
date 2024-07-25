package com.example.springapi.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapi.demo.model.User;
import com.example.springapi.demo.service.UserService;

@CrossOrigin ( origins = "http://localhost:4200/" ) //8087
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id){
        Optional<User> user = userService.getUser(id);
        return (User) user.orElse(null);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/users/names")
    public List<String> getNames(){
        return userService.getNames();
    }
    @GetMapping("/users/ids")
    public List<Number> getIds(){
        return userService.getIds();
    }
    @PostMapping(value="/user/add", consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User newUser ) {
        return userService.userAdd(newUser);
    }
}