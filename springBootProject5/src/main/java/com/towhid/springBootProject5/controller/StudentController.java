package com.towhid.springBootProject5.controller;

import com.towhid.springBootProject5.entity.Student;
import com.towhid.springBootProject5.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/savestudentform")
    public String saveStudent(Model m) {
        m.addAttribute("student", new Student());
        m.addAttribute("title", "Add New Student");
        return "savestudentform";
    }
}
