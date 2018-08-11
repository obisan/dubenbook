package ru.dubinets.dubenbook.service;

import ru.dubinets.dubenbook.model.User;

import java.util.List;

public interface UserService {

    User        findUserByEmail(String email);
    User        findUserByUserName(String username);
    List<User>  findAll();

    void        saveUser(User user);

}
