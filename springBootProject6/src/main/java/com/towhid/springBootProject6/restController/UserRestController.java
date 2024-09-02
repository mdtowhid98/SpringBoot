package com.towhid.springBootProject6.restController;

import com.towhid.springBootProject6.entity.User;
import com.towhid.springBootProject6.service.UserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRestController {


    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public void saveUser(@RequestBody User u) {
        try {
            userService.saveUser(u);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


}
