//package com.towhid.pharmacyManagement.restController;
//
//import com.towhid.pharmacyManagement.entity.OrderItem;
//import com.towhid.pharmacyManagement.entity.SalesOrder;
//import com.towhid.pharmacyManagement.service.OrderItemService;
//import com.towhid.pharmacyManagement.service.SalesOrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/orderitem")
//@CrossOrigin("*")
//
//public class OrderItemRestController {
//
//    @Autowired
//    private OrderItemService orderItemService;
//
//    @GetMapping("/")
//    public List<OrderItem> getAllOrderItem() {
//        return orderItemService.getAllOrderItem();
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<OrderItem> saveOrderItem(@RequestBody OrderItem oi) {
//        orderItemService.saveOrderItem(oi);
//        return new ResponseEntity<>(oi, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteOrderItem(@PathVariable long id) {
//        orderItemService.deleteOrderItemById(id);
//    }
//
//    @PutMapping("/update/{id}")
//    public void updateOrderItem(@RequestBody OrderItem oi) {
//        orderItemService.saveOrderItem(oi);
//    }
//
//
//}
