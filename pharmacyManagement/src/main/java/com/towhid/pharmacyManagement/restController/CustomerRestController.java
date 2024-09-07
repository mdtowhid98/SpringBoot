package com.towhid.pharmacyManagement.restController;

import com.towhid.pharmacyManagement.entity.Customer;
import com.towhid.pharmacyManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer c) {
        customerService.saveCustomer(c);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomerById(id);
    }

    @PutMapping("/update/{id}")
    public void updateCustomer(@RequestBody Customer c) {
        customerService.saveCustomer(c);
    }

}
