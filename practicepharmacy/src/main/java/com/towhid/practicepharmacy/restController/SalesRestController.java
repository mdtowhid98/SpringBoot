package com.towhid.practicepharmacy.restController;

import com.towhid.practicepharmacy.entity.Sales;
import com.towhid.practicepharmacy.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@CrossOrigin("*")
public class SalesRestController {

    @Autowired
    private SalesService salesService;

    @GetMapping("/")
    public List<Sales> getAllSales(){
        return salesService.getAllSales();
    }

    @PostMapping("/save")
    public void saveSales(@RequestBody Sales d){
        salesService.saveSales(d);
    }



}
