package com.towhid.practicepharmacy.service;

import com.towhid.practicepharmacy.entity.Product;
import com.towhid.practicepharmacy.entity.Sales;
import com.towhid.practicepharmacy.repository.CategoryRepository;
import com.towhid.practicepharmacy.repository.ProductRepository;
import com.towhid.practicepharmacy.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalesRepository salesRepository;


    public List<Sales> getAllSales() {

        return salesRepository.findAll();
    }

//    public void saveSales(Sales s) {
//        Product product = productRepository.findById(s.getProduct().getId())
//                .orElseThrow(
//                        () -> new RuntimeException("Product not found " + s.getProduct().getId())
//                );
//        s.setProduct(product);
//        salesRepository.save(s);
//    }

    public Sales saveSales(Sales sales) {
        return salesRepository.save(sales);
    }


}
