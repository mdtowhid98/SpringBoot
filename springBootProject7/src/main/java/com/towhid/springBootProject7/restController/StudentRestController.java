package com.towhid.springBootProject7.restController;

import com.towhid.springBootProject7.entity.Student;
import com.towhid.springBootProject7.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public List<Student> getAllStu() {
        return studentService.getAllStu();
    }
    @PostMapping("/save")
    public void saveStu(@RequestBody Student s){
        studentService.saveStu(s);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStu(@PathVariable int id){
       studentService.deleteStuById(id);
    }
    @PutMapping("/update/{id}")
    public void updateStu(@RequestBody Student s){
        studentService.saveStu(s);
    }

}
