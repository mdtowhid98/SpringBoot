package com.towhid.springBootProject6.restController;

import com.towhid.springBootProject6.entity.Student;
import com.towhid.springBootProject6.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public ResponseEntity <List<Student>> getAllStu(){
       List<Student>students=studentService.getAllStu();
       return new ResponseEntity<>(students,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<String> saveStu(@RequestBody Student s){
        studentService.saveStu(s);
        return new ResponseEntity<>("Student Created",HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteStu(@PathVariable int id){
        studentService.deleteByStuId(id);
        return new ResponseEntity<>("Student Deleted",HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String>  updateStu(@RequestBody Student s){
        studentService.saveStu(s);
        return new ResponseEntity<>("Student Updated",HttpStatus.OK);
    }
}
