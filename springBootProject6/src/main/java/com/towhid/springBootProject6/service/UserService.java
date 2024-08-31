package com.towhid.springBootProject6.service;

import com.towhid.springBootProject6.entity.User;
import com.towhid.springBootProject6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    public void saveUser(User u) {
        String toEmail=u.getEmail();
        String subject="Registration Confirmation";
        String body=String.format("Thanks %s,\n Stay with us and your \n User Name is %s.",u.getName(),u.getEmail());
        emailService.sendSimpleEmail(toEmail,subject,body);
        userRepository.save(u);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }

    public User findById(int id){
        return userRepository.findById(id).get();
    }

    public void updateUser(User u){
        userRepository.save(u);
    }


}
