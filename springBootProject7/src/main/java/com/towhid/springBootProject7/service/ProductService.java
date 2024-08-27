package com.towhid.springBootProject7.service;

import com.towhid.springBootProject7.Repository.ProductRepository;
import com.towhid.springBootProject7.Repository.CategoryRepository;
import com.towhid.springBootProject7.entity.Products;
import com.towhid.springBootProject7.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
   private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public void saveDep(Products d){
        Category category = categoryRepository.findById(d.getCategory().getId())
                        .orElseThrow(
                                ()->new RuntimeException("User not found"+d.getCategory().getId())
                        );
        d.setCategory(category);
        productRepository.save(d);
    }

    public List<Products>getAllDep(){
        return productRepository.findAll();
    }

    public void deletedepById(int id){
        productRepository.deleteById(id);
    }

    public Products findByid(int id){
        return  productRepository.findById(id).get();
    }

    public void updateDep(Products d, int id){
        productRepository.save(d);
    }



}
