package com.towhid.pharmacyManagement.service;

import com.towhid.pharmacyManagement.entity.Customer;
import com.towhid.pharmacyManagement.entity.Medicine;
import com.towhid.pharmacyManagement.entity.MedicineGeneric;
import com.towhid.pharmacyManagement.repository.CustomerRepository;
import com.towhid.pharmacyManagement.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


//    public void saveCustomer(Customer c) {
//
//        customerRepository.save(c);
//    }

    public ApiResponse saveCustomer(Customer c) throws IOException {
        ApiResponse apiResponse = new ApiResponse();
        try {
//            MedicineGeneric medicineGeneric = medicineCategoryRepository.findById(m.getGeneric().getId())
//                    .orElseThrow(() -> new RuntimeException("Medicine with this id not found"));

//            if (imageFile != null && !imageFile.isEmpty()) {
//                String imageFileName = saveImage(imageFile, m);
//                m.setImage(imageFileName);
//            }

            customerRepository.save(c);
            apiResponse.setSuccessful(true);
            apiResponse.setMessage("Customer saved successfully");
            return apiResponse;
        } catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            return apiResponse;
        }
    }

//    public List<Customer> getAllCustomer() {
//
//        return customerRepository.findAll();
//    }

    public ApiResponse getAllCustomer() {
        ApiResponse apiResponse = new ApiResponse();
        try {
            List<Customer> customers = customerRepository.findAll();

            Map<String, Object> map = new HashMap<>();
            map.put("customers", customers);

            apiResponse.setData(map);
            apiResponse.setSuccessful(true);
            apiResponse.setMessage("All Customers found");
            return apiResponse;
        } catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            return apiResponse;
        }
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
