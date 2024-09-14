package com.towhid.practicePharmacy2.restController;

import com.towhid.practicePharmacy2.entity.Medicine;
import com.towhid.practicePharmacy2.repository.MedicineRepository;
import com.towhid.practicePharmacy2.service.MedicineService;
import com.towhid.pharmacyManagement.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/medicine")
@CrossOrigin("*")
public class MedicineRestController {


    @Autowired
    private MedicineService medicineService;

    @GetMapping("/")
    public ApiResponse getAllMedicine() {
        return medicineService.getAllMedicine();
    }

    @PostMapping("/save")
    public ApiResponse saveMedicin(
            @RequestPart(value = "medicine") Medicine medicine,
            @RequestParam(value = "image", required = true) MultipartFile file
    ) throws IOException {
        ApiResponse apiResponse = medicineService.saveMedicine(medicine, file);
        return apiResponse;

    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedicine(@PathVariable long id) {
        medicineService.deleteMedicineById(id);
    }

//    @PutMapping("/update/{id}")
//    public void updateMedicine(@RequestBody Medicine m) {
//        medicineService.saveMedicine(m);
//    }


}
