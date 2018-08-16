package ru.dubinets.dubenbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dubinets.dubenbook.model.Message;
import ru.dubinets.dubenbook.model.Profile;
import ru.dubinets.dubenbook.service.FriendshipService;
import ru.dubinets.dubenbook.service.MessageService;
import ru.dubinets.dubenbook.service.ProfileService;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private FriendshipService friendshipService;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = {"/messages"}, method = RequestMethod.GET)
    public String chat(Model model) {

        model.addAttribute("friends", friendshipService.getAllFriends(profileService.getMe()));
        model.addAttribute("messages", messageService.findByProfile1(profileService.getMe()));

        return "messages";
    }

    @RequestMapping(value = {"/messages/{username}"}, method = RequestMethod.GET)
    public String chat(@PathVariable String username, Model model) {

        Profile me                  = profileService.getMe();
        Profile mate                = profileService.findByUsername(username);
        List<Message> messages      = messageService.findByProfile1AndProfile2OrderByDatetime(me, mate);

        model.addAttribute("me",        me);
        model.addAttribute("mate",      mate);
        model.addAttribute("messages",  messages);

        return "chat/private_chat";
    }

    @RequestMapping(value = {"/messages/send"}, method = RequestMethod.POST)
    public String send(@ModelAttribute("messageForm") Message message, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "chat/private_chat";
        } else {
            messageService.saveChat(message);
        }

        return "chat/private_chat";
    }

}
