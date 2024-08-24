package com.towhid.springBootProject6.service;

import com.towhid.springBootProject6.entity.Student;
import com.towhid.springBootProject6.repository.StudentRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepositoty studentRepositoty;


    public void saveStu(Student s){
        studentRepositoty.save(s);

    }
    public List<Student>getAllStu(){
        return studentRepositoty.findAll();
    }

    public void deleteByStuId(int id){
        studentRepositoty.deleteById(id);
    }
    public Student findById(int id){
        return studentRepositoty.findById(id).get();
    }
    public void updateStu(Student s, int id){
        studentRepositoty.save(s);
    }
}
