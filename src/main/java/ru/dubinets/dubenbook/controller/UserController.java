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

@Controller
public class UserController {

    @Autowired
    private UserService userService;

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
        User userExists = userService.findUserByEmail(userForm.getEmail());
        User usernameExists = userService.findUserByUserName(userForm.getUsername());

        if(userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
        }

        if(usernameExists != null) {
            bindingResult.rejectValue("username", "error.user", "This username already used!");
        }

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
