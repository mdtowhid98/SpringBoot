package com.towhid.springBootProject7.service;

import com.towhid.springBootProject7.Repository.DepartmentRepository;
import com.towhid.springBootProject7.Repository.StudentRepository;
import com.towhid.springBootProject7.entity.Department;
import com.towhid.springBootProject7.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public void saveStu(Student s){
        Department department=departmentRepository.findById(s.getDepartment().getId())
                        .orElseThrow(
                                ()-> new RuntimeException("User not found"+s.getDepartment().getId())
                        );
        studentRepository.save(s);
    }

    public List<Student>getAllStu(){
        return studentRepository.findAll();
    }

    public void deleteStuById(int id){
        studentRepository.deleteById(id);
    }

    public Student findById(int id){
        return studentRepository.findById(id).get();
    }

    public void updateStu(Student s,int id){
        studentRepository.save(s);
    }
}
