package ru.dubinets.dubenbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dubinets.dubenbook.model.Profile;
import ru.dubinets.dubenbook.service.FriendshipService;
import ru.dubinets.dubenbook.service.ProfileService;
import ru.dubinets.dubenbook.service.UserService;

@Controller
public class FriendshipController {

    @Autowired
    private FriendshipService friendshipService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/friends"}, method = RequestMethod.GET)
    public String add_friend(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Profile me      = profileService.findByEmail(auth.getName());

        model.addAttribute("user", me.getUser());
        model.addAttribute("friends", friendshipService.getAllFriends(me));

        return "friends";
    }

    @RequestMapping(value = {"/friend/invite/{username}"}, method = RequestMethod.GET)
    public String add_friend(@PathVariable String username, Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Profile me      = profileService.findByEmail(auth.getName());
        Profile user    = profileService.findByUsername(username);

        model.addAttribute("user", userService.findUserByEmail(auth.getName()));

        friendshipService.addFriend(me, user);

        return "members";
    }
}
