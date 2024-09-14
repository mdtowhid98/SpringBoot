//package com.towhid.pharmacyManagement.service;
//
//import com.towhid.pharmacyManagement.entity.*;
//import com.towhid.pharmacyManagement.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class OrderItemService {
//
//    @Autowired
//    private OrderItemRepository orderItemRepository;
//
//    @Autowired
//    private MedicineRepository medicineRepository;
//
//    @Autowired
//    private SalesOrderRepository salesOrderRepository;
//
//
//    public void saveOrderItem(OrderItem oi) {
//        Medicine medicine = medicineRepository.findById(oi.getMedicine().getId())
//                .orElseThrow(
//                        () -> new RuntimeException("Medicine not found " + oi.getMedicine().getId())
//                );
//        oi.setMedicine(medicine);
//
//        SalesOrder salesOrder = salesOrderRepository.findById(oi.getSalesOrder().getId())
//                .orElseThrow(
//                        () -> new RuntimeException("SalesOrder not found " + oi.getSalesOrder().getId())
//                );
//        oi.setSalesOrder(salesOrder);
//
//
//        orderItemRepository.save(oi);
//    }
//
//    public List<OrderItem> getAllOrderItem() {
//        return orderItemRepository.findAll();
//    }
//
//    public void deleteOrderItemById(long id) {
//        orderItemRepository.deleteById(id);
//    }
//
//    public OrderItem findByid(long id) {
//        return orderItemRepository.findById(id).get();
//    }
//
////    public List<Faculty>findByName(String name){
////        return facultyRepository.findByName(name);
////    };
//
//    public void updateOrderItem(OrderItem oi, long id) {
//        orderItemRepository.save(oi);
//    }
//
//
//}
