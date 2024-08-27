package com.towhid.springBootProject7.restController;

import com.towhid.springBootProject7.entity.Sales;
import com.towhid.springBootProject7.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController



@RequestMapping("/api/sales")
public class SalesRestController {

    @Autowired
    private SalesService salesService;

    @GetMapping("/")
    public ResponseEntity<List<Sales>> getAllStu() {
        List<Sales> sales = salesService.getAllStu();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<String> saveStu(@RequestBody Sales s){

        salesService.saveStu(s);
        return new ResponseEntity<>("Sales Created",HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStu(@PathVariable int id){

        salesService.deleteStuById(id);
        return new ResponseEntity<>("Sales Deleted",HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStu(@RequestBody Sales s){

        salesService.saveStu(s);
        return new ResponseEntity<>("Sales Updated",HttpStatus.OK);
    }

}
