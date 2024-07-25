package com.example.springapi.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;   
import javax.persistence.Id;


import org.springframework.stereotype.Service;

import com.example.springapi.demo.model.User;

@Service
@Entity
public class UserService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String edad;
    private String email;
    // Getters y setters

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1,"Ida", 32, "ida@mail.com");
        User user2 = new User(2,"Hans", 26, "hans@mail.com");
        User user3 = new User(3,"Lars", 45, "lars@mail.com");
        User user4 = new User(4,"Ben", 32, "ben@mail.com");
        User user5 = new User(5,"Eva", 59, "eva@mail.com");

        userList.addAll(Arrays.asList(user1,user2,user3,user4,user5));
    }

    public Optional<User> getUser(Integer id) {
        Optional<User> optional = Optional.empty();
        for (User user: userList) {
            if(id == user.getId()){
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }

    public List<User> getUsers() {
        return this.userList;
    }

    public List<String> getNames() {
        List<String> users = new ArrayList<String>();

        for (User user: userList) {
            if(user != null) {
                users.add(user.getName());
            }
        }
        return users;
    }

    public List<Number> getIds() {
        List<Number> users = new ArrayList<Number>();

        for (User user: userList) {
            if(user != null) {
                users.add(user.getId());
            }
        }
        return users;
    }

    public User userAdd(User newUser) {
        userList.addAll(Arrays.asList(newUser));
        return newUser;
    }
}