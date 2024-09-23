package com.towhid.pharmacyManagement.restController;

import com.towhid.pharmacyManagement.entity.Customer;
import com.towhid.pharmacyManagement.entity.Pharmacist;
import com.towhid.pharmacyManagement.service.CustomerService;
import com.towhid.pharmacyManagement.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pharmacist")
@CrossOrigin("*")
public class PharmacistRestController {

    @Autowired
    private PharmacistService pharmacistService;

    @GetMapping("/")
    public List<Pharmacist> getAllPharmacist() {
        return pharmacistService.getAllPharmacist();
    }

    @PostMapping("/save")
    public ResponseEntity<Pharmacist> savePharmacist(@RequestBody Pharmacist p) {
        pharmacistService.savePharmacist(p);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePharmacist(@PathVariable long id) {
        pharmacistService.deletePharmacistById(id);
    }

    @PutMapping("/update/{id}")
    public void updatePharmacist(@RequestBody Pharmacist p) {
        pharmacistService.savePharmacist(p);
    }

}
