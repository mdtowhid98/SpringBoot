package com.towhid.pharmacyManagement.service;

import com.towhid.pharmacyManagement.entity.SalesMedicine;
import com.towhid.pharmacyManagement.repository.MedicineRepository;
import com.towhid.pharmacyManagement.repository.SalesMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesMedicineService {


@Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private SalesMedicineRepository salesMedicineRepository;


    public List<SalesMedicine> getAllSales() {

        return salesMedicineRepository.findAll();
    }

//    public void saveSales(Sales s) {
//        Product product = productRepository.findById(s.getProduct().getId())
//                .orElseThrow(
//                        () -> new RuntimeException("Product not found " + s.getProduct().getId())
//                );
//        s.setProduct(product);
//        salesRepository.save(s);
//    }

    public SalesMedicine saveSales(SalesMedicine sales) {
        return salesMedicineRepository.save(sales);
    }


}