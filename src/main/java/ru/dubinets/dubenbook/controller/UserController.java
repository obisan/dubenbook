package ru.dubinets.dubenbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dubinets.dubenbook.model.User;
import ru.dubinets.dubenbook.service.UserService;
import ru.dubinets.dubenbook.validator.UserValidator;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute("userForm", new User());

        return "signup";
    }

    @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
    public String signup(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if(bindingResult.hasErrors()) {
            return "signup";
        } else {
            userService.saveUser(userForm);
            model.addAttribute("msg", "User has been registered successfully!");
            model.addAttribute("user", new User());
            return "redirect:/login";
        }
    }
}
