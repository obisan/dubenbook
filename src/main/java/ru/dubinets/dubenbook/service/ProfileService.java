package ru.dubinets.dubenbook.service;

import ru.dubinets.dubenbook.model.Profile;
import ru.dubinets.dubenbook.model.User;

public interface ProfileService {

    Profile     findByUser(User user);
    Profile     findByUsername(String username);

    void        saveProfile(Profile profile);

}
