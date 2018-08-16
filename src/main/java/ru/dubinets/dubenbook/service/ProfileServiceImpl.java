package ru.dubinets.dubenbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.dubinets.dubenbook.model.Friendship;
import ru.dubinets.dubenbook.model.Profile;
import ru.dubinets.dubenbook.model.User;
import ru.dubinets.dubenbook.repository.FriendshipRepository;
import ru.dubinets.dubenbook.repository.ProfileRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private FriendshipRepository friendshipRepository;

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
    public Profile findByEmail(String email) {
        return profileRepository.findByUser(userService.findUserByEmail(email));
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getMe() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();;
        return profileRepository.findByUser(userService.findUserByEmail(auth.getName()));
    }

    @Override
    public void saveProfile(Profile profile) {
        User user = userService.findUserByUserName(profile.getUser().getUsername());
        user.setEmail(profile.getUser().getEmail());

        Profile profileOld = profileRepository.findByUser(user);

        profile.setId(profileOld.getId());
        profile.setUser(user);

        profileRepository.save(profile);
    }
}
