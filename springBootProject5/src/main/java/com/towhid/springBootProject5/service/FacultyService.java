package com.towhid.springBootProject5.service;

import com.towhid.springBootProject5.entity.Department;
import com.towhid.springBootProject5.entity.Faculty;
import com.towhid.springBootProject5.repository.DepartmentRepository;
import com.towhid.springBootProject5.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public void saveFaculty(Faculty f){
        Department newDep=departmentRepository.findById(f.getDepartment().getId()).get();

        f.setDepartment(newDep);
        facultyRepository.save(f);
    }

    public List<Faculty>getAllFaculty(){
        return facultyRepository.findAll();
    }

    public void deleteFacultyByid(int id){
        facultyRepository.deleteById(id);

    }

    public Faculty findByid(int id){
        return facultyRepository.findById(id).get();
    }

    public void updateFaculty(Faculty f){
        facultyRepository.save(f);
    }


}
