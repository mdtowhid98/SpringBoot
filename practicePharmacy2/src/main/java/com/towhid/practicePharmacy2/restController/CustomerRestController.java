package com.towhid.practicePharmacy2.restController;

import com.towhid.practicePharmacy2.entity.Customer;
import com.towhid.practicePharmacy2.entity.Medicine;
import com.towhid.practicePharmacy2.service.CustomerService;
import com.towhid.pharmacyManagement.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ApiResponse getAllCustomer() {
        return customerService.getAllCustomer();
    }

//    @PostMapping("/save")
//    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer c) {
//        customerService.saveCustomer(c);
//        return new ResponseEntity<>(c, HttpStatus.CREATED);
//    }

    @PostMapping("/save")
    public ApiResponse saveCustomer(@RequestBody Customer c) throws IOException {
        ApiResponse apiResponse = customerService.saveCustomer(c);
        return apiResponse;
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomerById(id);
    }

//    @PutMapping("/update/{id}")
//    public void updateCustomer(@RequestBody Customer c) {
//        customerService.saveCustomer(c);
//    }

}
