package com.towhid.pharmacyManagement.restController;

import com.towhid.pharmacyManagement.entity.Medicine;
import com.towhid.pharmacyManagement.repository.MedicineRepository;
import com.towhid.pharmacyManagement.service.MedicineService;
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

    @GetMapping("/m/searchmedicine")
    public ResponseEntity<List<Medicine>> findMedicineByGenericName(@RequestParam(value = "genericName") String genericName) {
        List<Medicine> products = medicineService.findMedicineByGenericName(genericName);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedicine(@PathVariable long id) {

        medicineService.deleteMedicineById(id);
    }

//    @PutMapping("/update/{id}")
//    public void updateMedicine(@RequestBody Medicine m) {
//        medicineService.saveMedicine(m);
//    }
@GetMapping("/{id}")
public ResponseEntity<Medicine> getMedicineById(@PathVariable int id) {
    Medicine medicine = medicineService.getMedicineById(id);
    return ResponseEntity.ok(medicine);
}

    @PutMapping("/updatemedicine/{id}")
    public ResponseEntity<String> updateMedicine(
            @PathVariable long id,
            @RequestPart("medicine") Medicine medicine,
            @RequestParam(value = "image", required = false) MultipartFile file
    ) throws IOException {
        try {
            medicineService.updateMedicine(id, medicine, file);
            return ResponseEntity.ok("Medicine updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicine not found with this ID");
        }
    }


}
