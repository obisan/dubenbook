package ru.dubinets.dubenbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dubinets.dubenbook.service.ProfileService;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = {"/profile/{username}"}, method = RequestMethod.GET)
    public String profile(@PathVariable String username, Model model) {

        model.addAttribute("profile", profileService.findByUsername(username));

        return "profile";
    }

}
