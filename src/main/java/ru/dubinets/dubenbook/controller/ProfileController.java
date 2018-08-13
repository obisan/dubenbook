package ru.dubinets.dubenbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dubinets.dubenbook.model.Profile;
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

    @RequestMapping(value = {"/profile/edit/{username}"}, method = RequestMethod.GET)
    public String edit_view(@PathVariable String username, Model model) {

        model.addAttribute("profile", profileService.findByUsername(username));

        return "edit/profile";
    }

    @RequestMapping(value = {"/profile/edit"}, method = RequestMethod.POST)
    public String edit(@ModelAttribute("profile")Profile profile, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "/profile/edit/" + profile.getUser().getUsername();
        } else {
            profileService.saveProfile(profile);

            return "redirect:/profile/" + profile.getUser().getUsername();
        }
    }

}
