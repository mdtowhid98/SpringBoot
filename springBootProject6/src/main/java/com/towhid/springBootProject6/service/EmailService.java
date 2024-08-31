package com.towhid.springBootProject6.service;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    private JavaMailSender javaMailSender;

    public void sendSimpleEmail(String to,String subject,String text){
        SimpleMailMessage massage=new SimpleMailMessage();

        massage.setTo(to);
        massage.setSubject(subject);
        massage.setText(text);
//        massage.setFrom("your-email@towhid.com");

        javaMailSender.send(massage);

    }

}
