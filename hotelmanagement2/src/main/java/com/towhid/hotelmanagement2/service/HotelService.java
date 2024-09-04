package com.towhid.hotelmanagement2.service;

import com.towhid.hotelmanagement2.entity.Hotel;
import com.towhid.hotelmanagement2.entity.Location;
import com.towhid.hotelmanagement2.repository.HotelRepository;
import com.towhid.hotelmanagement2.repository.LocationRepository;
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
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Value("src/main/resources/static/images")
    private String uploadDir;

    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    public void saveHotel(Hotel hotel, MultipartFile imageFile) throws IOException {

        Location location = locationRepository.findById(hotel.getLocation().getId())
                .orElseThrow(() -> new RuntimeException("Location with this id not found"));

        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFileName = saveImage(imageFile, hotel);
            hotel.setImage(imageFileName);
        }

        hotelRepository.save(hotel);
    }


    public void deleteHotelById(int id) {
        hotelRepository.deleteById(id);
    }

    public Hotel findHotelById(int id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel With This Id Not Found"));
    }

    @Transactional
    public void updateHotel(int id, Hotel updateHotel, MultipartFile imageFile) throws IOException {
        Hotel existingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel With This Id Not Found"));

        existingHotel.setName(updateHotel.getName());
        existingHotel.setAddress(updateHotel.getAddress());
        existingHotel.setRating(updateHotel.getRating());
        existingHotel.setMinPrice(updateHotel.getMinPrice());
        existingHotel.setMaxPrice(updateHotel.getMaxPrice());

        Location location = locationRepository.findById(updateHotel.getLocation().getId())
                .orElseThrow(() -> new RuntimeException("Location with this id not found"));
        existingHotel.setLocation(location);

        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = saveImage(imageFile, existingHotel);
            existingHotel.setImage(imageFilename);
        }
        hotelRepository.save(existingHotel);

    }

    public List<Hotel>findHotelsByLocationName(String locationName){
        return hotelRepository.finndHotelByLocationName(locationName);
    }

    public String saveImage(MultipartFile file, Hotel h) throws IOException {
        Path uploadPath = Paths.get(uploadDir + "/hotel");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String filename = h.getName() + "_" + UUID.randomUUID().toString();
        Path filePath = uploadPath.resolve(filename);

        Files.copy(file.getInputStream(), filePath);


        return filename;
    }


}
