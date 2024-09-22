package com.towhid.practicepharmacy.restController;

import com.towhid.practicepharmacy.entity.Sales;
import com.towhid.practicepharmacy.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Sales> createSale(@RequestBody Sales sales) {
        Sales savedSales = salesService.saveSales(sales);
        return ResponseEntity.ok(savedSales);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id) {

        salesService.deleteSalesById(id);
    }


}
