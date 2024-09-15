package com.towhid.pharmacyManagement.restController;

import com.towhid.pharmacyManagement.entity.SalesMedicine;
import com.towhid.pharmacyManagement.service.SalesMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salesmedicine")
@CrossOrigin("*")
public class SalesMedicineRestController {


    @Autowired
    SalesMedicineService salesMedicineService;

    @GetMapping("/")
    public List<SalesMedicine> getAllSales(){
        return salesMedicineService.getAllSales();
    }

    @PostMapping("/save")
    public void saveSales(@RequestBody SalesMedicine d){
        salesMedicineService.saveSales(d);
    }

}
