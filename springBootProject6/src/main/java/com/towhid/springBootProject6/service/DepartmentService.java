package com.towhid.springBootProject6.service;

import com.towhid.springBootProject6.entity.Department;
import com.towhid.springBootProject6.repository.DepartmentRepository;
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

    public void deleteDepByid(int id){
        departmentRepository.deleteById(id);
    }
    public Department findById(int id){
        return departmentRepository.findById(id).get();
    }
    public void updateDep(Department d){
       departmentRepository.save(d);
    }
}
