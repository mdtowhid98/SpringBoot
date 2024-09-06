package com.towhid.pharmacyManagement.service;

import com.towhid.pharmacyManagement.entity.*;
import com.towhid.pharmacyManagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderService {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PharmacistRepository pharmacistRepository;


    public void saveSalesOrder(SalesOrder so) {
        Customer customer = customerRepository.findById(so.getCustomer().getId())
                .orElseThrow(
                        () -> new RuntimeException("Customer not found " + so.getCustomer().getId())
                );
        so.setCustomer(customer);

        Pharmacist pharmacist = pharmacistRepository.findById(so.getPharmacist().getId())
                .orElseThrow(
                        () -> new RuntimeException("Pharmacist not found " + so.getPharmacist().getId())
                );
        so.setPharmacist(pharmacist);


        salesOrderRepository.save(so);
    }

    public List<SalesOrder> getAllSalesOrder() {
        return salesOrderRepository.findAll();
    }

    public void deleteSalesOrderById(long id) {
        salesOrderRepository.deleteById(id);
    }

    public SalesOrder findByid(long id) {
        return salesOrderRepository.findById(id).get();
    }

//    public List<Faculty>findByName(String name){
//        return facultyRepository.findByName(name);
//    };

    public void updateSalesOrder(SalesOrder so, long id) {
        salesOrderRepository.save(so);
    }



}
