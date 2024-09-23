package com.towhid.pharmacyManagement.restController;

import com.towhid.pharmacyManagement.entity.Medicine;
import com.towhid.pharmacyManagement.entity.SalesOrder;
import com.towhid.pharmacyManagement.service.MedicineService;
import com.towhid.pharmacyManagement.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salesorder")
@CrossOrigin("*")

public class SalesOrderRestController {

    @Autowired
    private SalesOrderService salesOrderService;

    @GetMapping("/")
    public List<SalesOrder> getAllSalesOrder() {
        return salesOrderService.getAllSalesOrder();
    }

    @PostMapping("/save")
    public ResponseEntity<SalesOrder> saveSalesOrder(@RequestBody SalesOrder so) {
        salesOrderService.saveSalesOrder(so);
        return new ResponseEntity<>(so, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSalesOrder(@PathVariable long id) {
        salesOrderService.deleteSalesOrderById(id);
    }

    @PutMapping("/update/{id}")
    public void updateSalesOrder(@RequestBody SalesOrder so) {
        salesOrderService.saveSalesOrder(so);
    }
}
