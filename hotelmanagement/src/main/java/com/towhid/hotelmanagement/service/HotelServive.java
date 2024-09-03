package com.towhid.hotelmanagement.service;

import com.towhid.hotelmanagement.entity.Hotel;
import com.towhid.hotelmanagement.entity.Location;
import com.towhid.hotelmanagement.repository.HotelRepository;
import com.towhid.hotelmanagement.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class HotelServive {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Value("src/main/resources/static/images")
    private  String uploadDir;


    public List<Hotel> getAllHotel(){

        return  hotelRepository.findAll();
    }


    public void saveHotel(Hotel hotel, MultipartFile imageFile) throws IOException {

        Location location=locationRepository.findById(hotel.getLocation().getId())
                .orElseThrow(()-> new RuntimeException("Location With this Id not Found"));


        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = saveImage(imageFile, hotel);
            hotel.setImage(imageFilename); // Set the image filename in the user entity
        }



        hotel.setLocation(location);
        hotelRepository.save(hotel);

    }


    public void deleteHotelById(int id){

        hotelRepository.deleteById(id);

    }

    public Hotel findHotelById(int id){

        return  hotelRepository.findById(id)
                .orElseThrow(
                        ()->new RuntimeException("Hotel Not found With this ID")
                );
    }



    @Transactional
    public void updateHotel(int id, Hotel updatedHotel, MultipartFile imageFile) throws IOException {
        Hotel existingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with this ID"));

        // Update hotel details
        existingHotel.setName(updatedHotel.getName());
        existingHotel.setAddress(updatedHotel.getAddress());
        existingHotel.setRating(updatedHotel.getRating());
        existingHotel.setMinPrice(updatedHotel.getMinPrice());
        existingHotel.setMaxPrice(updatedHotel.getMaxPrice());

        // Update location
        Location location = locationRepository.findById(updatedHotel.getLocation().getId())
                .orElseThrow(() -> new RuntimeException("Location with this ID not found"));
        existingHotel.setLocation(location);

        // Update image if provided
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = saveImage(imageFile, existingHotel);
            existingHotel.setImage(imageFilename);
        }

        hotelRepository.save(existingHotel);
    }


    public List<Hotel> findHotelsByLocationName(String locationName){

        return hotelRepository.findHotelsByLocationName(locationName);
    }



    private String saveImage(MultipartFile file, Hotel h) throws IOException {
        Path uploadPath = Paths.get(uploadDir+"/hotel");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Generate a unique filename
        String filename = h.getName()+"_"+ UUID.randomUUID().toString() ;
        Path filePath = uploadPath.resolve(filename);

        // Save the file
        Files.copy(file.getInputStream(), filePath);

        return filename; // Return the filename for storing in the database
    }



}
