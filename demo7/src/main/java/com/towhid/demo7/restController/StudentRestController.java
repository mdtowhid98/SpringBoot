package com.towhid.demo7.restController;

import com.towhid.demo7.entity.Student;
import com.towhid.demo7.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentRestController {
    @Autowired
private StudentService studentService;

    @GetMapping("/")
    public List<Student>getAllStudents(){
        return studentService.getAllstu();
    }

    @PostMapping("/save")
    public void saveStu(@RequestBody Student s){
        studentService.saveStu(s);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStu(@PathVariable int id){
        studentService.deleteByid(id);
    }

    @PutMapping("/update/{id}")
    public void updateStu(@RequestBody Student s){
        studentService.saveStu(s);
    }



}
