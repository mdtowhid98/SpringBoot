package com.towhid.practicePharmacy2.restController;

import com.towhid.practicePharmacy2.entity.Medicine;
import com.towhid.practicePharmacy2.entity.SalesOrder;
import com.towhid.practicePharmacy2.service.MedicineService;
import com.towhid.practicePharmacy2.service.SalesOrderService;
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
