package ru.dubinets.dubenbook.service;

import ru.dubinets.dubenbook.model.Profile;
import ru.dubinets.dubenbook.model.User;

import java.util.List;

public interface ProfileService {

    Profile         getMe();

    Profile         findByUser(User user);
    Profile         findByUsername(String username);
    Profile         findByEmail(String email);
    List<Profile>   findAll();

    void            saveProfile(Profile profile);

}
