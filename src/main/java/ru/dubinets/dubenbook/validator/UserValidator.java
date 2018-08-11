package ru.dubinets.dubenbook.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.dubinets.dubenbook.model.User;
import ru.dubinets.dubenbook.service.UserService;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "validation.empty.or.whitespaces");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "validation.empty.or.whitespaces");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validation.empty.or.whitespaces");

        if(userService.findUserByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "validation.email.exists");
        }

        if(userService.findUserByUserName(user.getUsername()) != null) {
            errors.rejectValue("username", "validation.username.exists");
        }

    }
}
