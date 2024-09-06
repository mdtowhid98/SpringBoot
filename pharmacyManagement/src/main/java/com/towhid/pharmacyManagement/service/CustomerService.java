package com.towhid.pharmacyManagement.service;

import com.towhid.pharmacyManagement.entity.Customer;
import com.towhid.pharmacyManagement.entity.MedicineCategory;
import com.towhid.pharmacyManagement.repository.CustomerRepository;
import com.towhid.pharmacyManagement.repository.MedicineCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public void saveCustomer(Customer c) {
        customerRepository.save(c);
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public void deleteCustomerById(long id) {
        customerRepository.deleteById(id);
    }

    public Customer findByid(long id) {
        return customerRepository.findById(id).get();
    }

//    public List<Faculty>findByName(String name){
//        return facultyRepository.findByName(name);
//    };

    public void updateCustomer(Customer c, long id) {
        customerRepository.save(c);
    }
}
