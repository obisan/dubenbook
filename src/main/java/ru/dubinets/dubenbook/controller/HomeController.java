package ru.dubinets.dubenbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.dubinets.dubenbook.model.User;
import ru.dubinets.dubenbook.service.UserService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String home(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        model.addAttribute("username", user.getUsername());

        return "home";
    }

    @RequestMapping(value = {"/members"}, method = RequestMethod.GET)
    public ModelAndView members() {
        ModelAndView model = new ModelAndView();

        List<User> users = userService.findAll();

        model.addObject("users", users);
        model.setViewName("home/members");

        return model;
    }

    @RequestMapping(value = {"/access_denied"}, method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("errors/access_denied");
        return model;
    }

}
