package com.aminul.propertyapplication.service;

import com.aminul.propertyapplication.entity.Residence;
import com.aminul.propertyapplication.repository.ResidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class ResidenceService {

    @Autowired
    private ResidenceRepository residenceRepository;

    @Value("src/main/resources/static/images")
    private String uploadDir;

    public List<Residence> getALlResidenc(){

        return residenceRepository.findAll();

    }

    public void saveResidence(Residence residence, MultipartFile imageFile) throws IOException {

//        Location location = locationRepository.findById(hotel.getLocation().getId())
//                .orElseThrow(() -> new RuntimeException("Location with this id not found"));

        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFileName = saveImage(imageFile, residence);
            residence.setImage(imageFileName);
        }

        residenceRepository.save(residence);
    }

    public  void deleteResidenc(int id){
        residenceRepository.deleteById(id);
    }

    public  Residence findById(int id){
        return   residenceRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Residence Not Found by this Id"));
    }

    public String saveImage(MultipartFile file, Residence r) throws IOException {
        Path uploadPath = Paths.get(uploadDir + "/residence");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String filename = r.getName() + "_" + UUID.randomUUID().toString();
        Path filePath = uploadPath.resolve(filename);

        Files.copy(file.getInputStream(), filePath);


        return filename;
    }




}
