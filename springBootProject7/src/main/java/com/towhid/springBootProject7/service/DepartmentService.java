package com.towhid.springBootProject7.service;

import com.towhid.springBootProject7.Repository.DepartmentRepository;
import com.towhid.springBootProject7.Repository.FacultyRepository;
import com.towhid.springBootProject7.entity.Department;
import com.towhid.springBootProject7.entity.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
   private DepartmentRepository departmentRepository;
    @Autowired
    private FacultyRepository facultyRepository;

    public void saveDep(Department d){
        Faculty faculty=facultyRepository.findById(d.getFaculty().getId())
                        .orElseThrow(
                                ()->new RuntimeException("User not found"+d.getFaculty().getId())
                        );
        d.setFaculty(faculty);
        departmentRepository.save(d);
    }

    public List<Department>getAllDep(){
        return departmentRepository.findAll();
    }

    public void deletedepById(int id){
        departmentRepository.deleteById(id);
    }

    public Department findByid(int id){
        return  departmentRepository.findById(id).get();
    }

    public void updateDep(Department d,int id){
        departmentRepository.save(d);
    }



}
