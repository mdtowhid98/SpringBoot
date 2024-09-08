package com.aminul.propertyapplication.restController;

import com.aminul.propertyapplication.entity.Residence;
import com.aminul.propertyapplication.service.ResidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/recidence")
@CrossOrigin("*")
public class ResidenceRestController {



    @Autowired
    private ResidenceService residenceService;

    @GetMapping("/")
    public ResponseEntity<List<Residence>> getAllResidence() {
        List<Residence> recidence = residenceService.getALlResidenc();
        return ResponseEntity.ok(recidence);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveResidence(
            @RequestPart(value = "residence") Residence residence,
            @RequestParam(value = "image", required = true) MultipartFile file
    ) throws IOException {
        residenceService.saveResidence(residence, file);

        return new ResponseEntity<>("Location added succesfully with image", HttpStatus.OK);

    }

}
