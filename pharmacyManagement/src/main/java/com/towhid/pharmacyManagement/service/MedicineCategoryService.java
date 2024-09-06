package com.towhid.pharmacyManagement.service;

import com.towhid.pharmacyManagement.entity.Medicine;
import com.towhid.pharmacyManagement.entity.MedicineCategory;
import com.towhid.pharmacyManagement.repository.MedicineCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineCategoryService {

    @Autowired
    private MedicineCategoryRepository medicineCategoryRepository;


    public void saveMedicineCategory(MedicineCategory mc) {
        medicineCategoryRepository.save(mc);
    }

    public List<MedicineCategory> getAllMedicineCategory() {
        return medicineCategoryRepository.findAll();
    }

    public void deleteMedicineCategoryById(long id) {
        medicineCategoryRepository.deleteById(id);
    }

    public MedicineCategory findByid(long id) {
        return medicineCategoryRepository.findById(id).get();
    }

//    public List<Faculty>findByName(String name){
//        return facultyRepository.findByName(name);
//    };

    public void updateMedicineCategory(MedicineCategory mc, long id) {
        medicineCategoryRepository.save(mc);
    }


}
