package com.towhid.pharmacyManagement.service;

import com.towhid.pharmacyManagement.entity.Customer;
import com.towhid.pharmacyManagement.entity.Pharmacist;
import com.towhid.pharmacyManagement.repository.CustomerRepository;
import com.towhid.pharmacyManagement.repository.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacistService {

    @Autowired
    private PharmacistRepository pharmacistRepository;


    public void savePharmacist(Pharmacist p) {

        pharmacistRepository.save(p);
    }

    public List<Pharmacist> getAllPharmacist() {

        return pharmacistRepository.findAll();
    }

    public void deletePharmacistById(long id) {

        pharmacistRepository.deleteById(id);
    }

    public Pharmacist findByid(long id) {

        return pharmacistRepository.findById(id).get();
    }

//    public List<Faculty>findByName(String name){
//        return facultyRepository.findByName(name);
//    };

    public Pharmacist updatePharmacist(Pharmacist p, long id) {

        return pharmacistRepository.save(p);
    }

}
