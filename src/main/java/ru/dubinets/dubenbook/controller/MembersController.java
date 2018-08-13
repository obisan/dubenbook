package ru.dubinets.dubenbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dubinets.dubenbook.service.ProfileService;
import ru.dubinets.dubenbook.service.UserService;

@Controller
public class MembersController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/members"}, method = RequestMethod.GET)
    public String members(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("user", userService.findUserByEmail(auth.getName()));
        model.addAttribute("profiles", profileService.findAll());

        return "members";
    }
}
