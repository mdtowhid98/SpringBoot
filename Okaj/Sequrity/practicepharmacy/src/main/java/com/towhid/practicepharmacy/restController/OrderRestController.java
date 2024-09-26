package com.towhid.practicepharmacy.restController;

import com.towhid.practicepharmacy.entity.Order;
import com.towhid.practicepharmacy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:4200/")

public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public List<Order> getAllSalesOrder() {

        return orderService.getAllSalesOrder();
    }

    @PostMapping("/save")
    public ResponseEntity<String> createSalesOrder(@RequestBody Order salesOrder) {
        try {
            orderService.saveOrder(salesOrder);
            return new ResponseEntity<>("Sales order created successfully.", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
