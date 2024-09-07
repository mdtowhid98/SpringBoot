package com.towhid.pharmacyManagement.service;

import com.towhid.pharmacyManagement.entity.Medicine;
import com.towhid.pharmacyManagement.entity.MedicineGeneric;
import com.towhid.pharmacyManagement.repository.MedicineGenericRepository;
import com.towhid.pharmacyManagement.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private MedicineGenericRepository medicineCategoryRepository;


    public void saveMedicine(Medicine m) {
        MedicineGeneric medicineCategory = medicineCategoryRepository.findById(m.getCategory().getId())
                .orElseThrow(
                        () -> new RuntimeException("User not found " + m.getCategory().getId())
                );
        m.setCategory(medicineCategory);
        medicineRepository.save(m);
    }

    public List<Medicine> getAllMedicine() {
        return medicineRepository.findAll();
    }

    public void deleteMedicineById(long id) {
        medicineRepository.deleteById(id);
    }

    public Medicine findByid(long id) {
        return medicineRepository.findById(id).get();
    }

//    public List<Faculty>findByName(String name){
//        return facultyRepository.findByName(name);
//    };

    public void updateMedicine(Medicine m, long id) {
        medicineRepository.save(m);
    }


}
