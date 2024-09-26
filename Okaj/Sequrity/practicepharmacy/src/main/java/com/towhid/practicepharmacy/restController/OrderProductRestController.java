package com.towhid.practicepharmacy.restController;

import com.towhid.practicepharmacy.entity.OrderProduct;
import com.towhid.practicepharmacy.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderproduct")
@CrossOrigin(origins = "http://localhost:4200/")

public class OrderProductRestController {

    @Autowired
    private OrderProductService orderProductService;

    @GetMapping("/")
    public List<OrderProduct> getAllOrder() {
        return orderProductService.getAllOrder();
    }

    @PostMapping("/save")
    public ResponseEntity<OrderProduct> createSale(@RequestBody OrderProduct orderProduct) {
        OrderProduct savedOrders = orderProductService.saveOrder(orderProduct);
        return ResponseEntity.ok(savedOrders);
    }

}
