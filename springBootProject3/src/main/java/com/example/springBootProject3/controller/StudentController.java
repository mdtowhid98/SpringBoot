package com.example.springBootProject3.controller;

import com.example.springBootProject3.entity.Student;
import com.example.springBootProject3.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StudentController {
    private StudentService studentService;

   @RequestMapping("/savestudentform")

    public String saveStudent(Model m){
        m.addAttribute("student",new Student());
        m.addAttribute("title","Add new Student");
        return "savestudentform";
    }
}
