package com.towhid.pharmacyManagement.restController;

import com.towhid.pharmacyManagement.entity.MedicineGeneric;
import com.towhid.pharmacyManagement.service.MedicineGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicinegeneric")
@CrossOrigin("*")

public class MedicineGenericRestController {

    @Autowired
    private MedicineGenericService medicineCategoryService;

    @GetMapping("/")
    public List<MedicineGeneric> getAllMedicineCategory() {
        return medicineCategoryService.getAllMedicineCategory();
    }

    @PostMapping("/save")
    public ResponseEntity<MedicineGeneric> saveMedicineCategory(@RequestBody MedicineGeneric mc) {
        medicineCategoryService.saveMedicineCategory(mc);
        return new ResponseEntity<>(mc, HttpStatus.CREATED);
    }

//    @DeleteMapping("/delete/{id}")
//    public void deleteMedicineCategory(@PathVariable long id) {
//        medicineCategoryService.deleteMedicineCategoryById(id);
//    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedicineCategory(@PathVariable long id) {
        medicineCategoryService.deleteMedicineCategoryById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <MedicineGeneric>pdateMedicineCtegory(@RequestBody MedicineGeneric mc,@PathVariable long id) {
       MedicineGeneric generic= medicineCategoryService.updateMedicineCategory(mc,id);
      return new ResponseEntity<>(generic, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public  MedicineGeneric getMedicineById(@PathVariable("id") long id) {

        return  medicineCategoryService.findByid(id);

    }



}
