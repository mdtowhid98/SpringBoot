package com.towhid.hotelmanagement2.service;

import com.towhid.hotelmanagement2.entity.Hotel;
import com.towhid.hotelmanagement2.entity.Location;
import com.towhid.hotelmanagement2.repository.LocationRepository;
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
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Value("src/main/resources/static/images")
    private String uploadDir;

    public List<Location> getALlLocation(){

        return locationRepository.findAll();

    }

    public void saveLocation(Location location, MultipartFile imageFile) throws IOException {

//        Location location = locationRepository.findById(hotel.getLocation().getId())
//                .orElseThrow(() -> new RuntimeException("Location with this id not found"));

        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFileName = saveImage(imageFile, location);
            location.setImage(imageFileName);
        }

        locationRepository.save(location);
    }

    public  void deleteLocation(int id){
        locationRepository.deleteById(id);
    }

    public  Location findById(int id){
        return   locationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Location Not Found by this Id"));
    }

    public String saveImage(MultipartFile file, Location l) throws IOException {
        Path uploadPath = Paths.get(uploadDir + "/location");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String filename = l.getName() + "_" + UUID.randomUUID().toString();
        Path filePath = uploadPath.resolve(filename);

        Files.copy(file.getInputStream(), filePath);


        return filename;
    }


}
