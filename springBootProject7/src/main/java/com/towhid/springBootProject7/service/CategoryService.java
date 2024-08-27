package com.towhid.springBootProject7.service;

import com.towhid.springBootProject7.Repository.CategoryRepository;
import com.towhid.springBootProject7.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;



    public void saveFaculty(Category f){
        categoryRepository.save(f);
    }

    public List<Category>getAllFaculty(){
        return categoryRepository.findAll();
    }

    public void deleteFacultyById(int id){
        categoryRepository.deleteById(id);
    }

    public void findByid(int id){
        categoryRepository.findById(id).get();
    }
    public void updateFaculty(Category f, int id){
        categoryRepository.save(f);
    }
}
