package com.towhid.practicePharmacy2.restController;

import com.towhid.practicePharmacy2.entity.SalesMedicine;
import com.towhid.practicePharmacy2.service.SalesMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salesmedicine")
@CrossOrigin("*")
public class SalesMedicineRestController {

    @Autowired
    private SalesMedicineService salesMedicineService;

    @GetMapping("/")
    public ResponseEntity<List<SalesMedicine>> getAllsalesMedicine(){
        List<SalesMedicine>students=salesMedicineService.getAllMedicine();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<String> saveSalesMedicine(@RequestBody SalesMedicine s){
        salesMedicineService.saveSalesMedicine(s);
        return new ResponseEntity<>("Student Created",HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteSalesMedicine(@PathVariable int id){
        salesMedicineService.deleteBySalesMedicineId(id);
        return new ResponseEntity<>("Student Deleted",HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String>  updateSalesMedicine(@RequestBody SalesMedicine s){
        salesMedicineService.saveSalesMedicine(s);
        return new ResponseEntity<>("Student Updated",HttpStatus.OK);
    }


}
