package com.towhid.springBootProject5.restController;

import com.towhid.springBootProject5.entity.Student;
import com.towhid.springBootProject5.repository.StudentRepository;
import com.towhid.springBootProject5.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentRestController {

    @Autowired
   private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public List<Student>getAllStudent(){
        return studentService.getAllStu();
    }

    @PostMapping("/save")
    public void saveStu(@RequestBody Student s){

       studentService.saveStu(s);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id){

        studentService.deleteById(id);

    }

//    @PutMapping("/update/{id}")
//    public void updateStudent(@RequestBody Student s,@PathVariable int id){
//
//        studentService.saveStu(s,id);
//
//    }
    @PutMapping("/update/{id}")
    public void updateStudent(@RequestBody Student s){
        studentService.saveStu(s);
    }




}
