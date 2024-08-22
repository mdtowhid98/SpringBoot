package com.towhid.springBootProject5.service;

import com.towhid.springBootProject5.entity.Department;
import com.towhid.springBootProject5.repository.DepartmentRepository;
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
    public Department findById(int id){
        return departmentRepository.findById(id).get();
    }

    public void updateDep(Department d){
        departmentRepository.save(d);
    }

}
