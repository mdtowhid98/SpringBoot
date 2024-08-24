package com.towhid.springBootProject7.service;

import com.towhid.springBootProject7.Repository.FacultyRepository;
import com.towhid.springBootProject7.entity.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;



    public void saveFaculty(Faculty f){
        facultyRepository.save(f);
    }

    public List<Faculty>getAllFaculty(){
        return facultyRepository.findAll();
    }

    public void deleteFacultyById(int id){
        facultyRepository.deleteById(id);
    }

    public void findByid(int id){
        facultyRepository.findById(id).get();
    }
    public void updateFaculty(Faculty f,int id){
        facultyRepository.save(f);
    }
}
