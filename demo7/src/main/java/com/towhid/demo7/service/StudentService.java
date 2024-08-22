package com.towhid.demo7.service;

import com.towhid.demo7.entity.Student;
import com.towhid.demo7.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void saveStu(Student s) {
        studentRepository.save(s);
    }

    public List<Student> getAllstu() {
        return studentRepository.findAll();
    }

    public void deleteByid(int id) {
        studentRepository.deleteById(id);
    }

    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }

    public void updateStudent(Student s) {
        studentRepository.save(s);
    }
}
