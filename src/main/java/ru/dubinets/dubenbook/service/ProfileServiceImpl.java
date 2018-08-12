package ru.dubinets.dubenbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dubinets.dubenbook.model.Profile;
import ru.dubinets.dubenbook.model.User;
import ru.dubinets.dubenbook.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserService userService;

    @Override
    public Profile findByUser(User user) {
        return profileRepository.findByUser(user);
    }

    @Override
    public Profile findByUsername(String username) {
        return profileRepository.findByUser(userService.findUserByUserName(username));
    }

    @Override
    public void saveProfile(Profile profile) {
        profileRepository.save(profile);
    }
}
