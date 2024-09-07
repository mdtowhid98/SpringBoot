package com.towhid.pharmacyManagement.service;

import com.towhid.pharmacyManagement.entity.MedicineGeneric;
import com.towhid.pharmacyManagement.repository.MedicineGenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineGenericService {

    @Autowired
    private MedicineGenericRepository medicineCategoryRepository;


    public void saveMedicineCategory(MedicineGeneric mc) {
        medicineCategoryRepository.save(mc);
    }

    public List<MedicineGeneric> getAllMedicineCategory() {
        return medicineCategoryRepository.findAll();
    }

    public void deleteMedicineCategoryById(long id) {
        medicineCategoryRepository.deleteById(id);
    }

    public MedicineGeneric findByid(long id) {
        return medicineCategoryRepository.findById(id).get();
    }

//    public List<Faculty>findByName(String name){
//        return facultyRepository.findByName(name);
//    };

    public void updateMedicineCategory(MedicineGeneric mc, long id) {
        medicineCategoryRepository.save(mc);
    }


}
