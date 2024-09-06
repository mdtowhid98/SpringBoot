package com.towhid.pharmacyManagement.restController;

import com.towhid.pharmacyManagement.entity.Medicine;
import com.towhid.pharmacyManagement.entity.MedicineCategory;
import com.towhid.pharmacyManagement.service.MedicineCategoryService;
import com.towhid.pharmacyManagement.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicinecategory")
@CrossOrigin("*")

public class MedicineCategoryRestController {

    @Autowired
    private MedicineCategoryService medicineCategoryService;

    @GetMapping("/")
    public List<MedicineCategory> getAllMedicineCategory() {
        return medicineCategoryService.getAllMedicineCategory();
    }

    @PostMapping("/save")
    public ResponseEntity<MedicineCategory> saveMedicineCategory(@RequestBody MedicineCategory mc) {
        medicineCategoryService.saveMedicineCategory(mc);
        return new ResponseEntity<>(mc, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedicineCategory(@PathVariable long id) {
        medicineCategoryService.deleteMedicineCategoryById(id);
    }

    @PutMapping("/update/{id}")
    public void updateMedicineCtegory(@RequestBody MedicineCategory mc) {
        medicineCategoryService.saveMedicineCategory(mc);
    }


}
