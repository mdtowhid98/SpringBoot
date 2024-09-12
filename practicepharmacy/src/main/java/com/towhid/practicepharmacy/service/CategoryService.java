package com.towhid.practicepharmacy.service;

import com.towhid.practicepharmacy.entity.Category;
import com.towhid.practicepharmacy.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void saveCategory(Category c) {
        categoryRepository.save(c);
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }

    public Category findByid(int id) {
        return categoryRepository.findById(id).get();
    }

//    public List<Faculty>findByName(String name){
//        return facultyRepository.findByName(name);
//    };

    public void updateFaculty(Category f, int id) {
        categoryRepository.save(f);
    }



}