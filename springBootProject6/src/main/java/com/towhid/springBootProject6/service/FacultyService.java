package com.towhid.springBootProject6.service;

import com.towhid.springBootProject6.entity.Faculty;
import com.towhid.springBootProject6.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public void saveFaculty(Faculty f) {
        facultyRepository.save(f);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public void deleteFacultyById(int id) {
        facultyRepository.deleteById(id);
    }

    public Faculty findByid(int id) {
        return facultyRepository.findById(id).get();
    }

    public void updateFaculty(Faculty f, int id) {
        facultyRepository.save(f);
    }

}
