package com.towhid.springBootProject7.service;

import com.towhid.springBootProject7.Repository.DepartmentRepository;
import com.towhid.springBootProject7.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
   private DepartmentRepository departmentRepository;

    public void saveDep(Department d){
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
