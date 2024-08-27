package com.towhid.springBootProject7.service;

import com.towhid.springBootProject7.Repository.ProductRepository;
import com.towhid.springBootProject7.Repository.SalesRepository;
import com.towhid.springBootProject7.entity.Products;
import com.towhid.springBootProject7.entity.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private ProductRepository productRepository;

    public void saveStu(Sales s){
        Products products = productRepository.findById(s.getProducts().getId())
                        .orElseThrow(
                                ()-> new RuntimeException("User not found"+s.getProducts().getId())
                        );
        salesRepository.save(s);
    }

    public List<Sales>getAllStu(){
        return salesRepository.findAll();
    }

    public void deleteStuById(int id){
        salesRepository.deleteById(id);
    }

    public Sales findById(int id){
        return salesRepository.findById(id).get();
    }

    public void updateStu(Sales s, int id){
        salesRepository.save(s);
    }
}
