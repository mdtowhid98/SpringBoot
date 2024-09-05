package com.towhid.hotelmanagement2.service;

import com.towhid.hotelmanagement2.entity.Hotel;
import com.towhid.hotelmanagement2.entity.Room;
import com.towhid.hotelmanagement2.repository.HotelRepository;
import com.towhid.hotelmanagement2.repository.RoomRepository;
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
public class RoomService {


    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HotelRepository hotelRepository;

    @Value("src/main/resources/static/images")
    private String uploadDir;


    public List<Room> getALlRooms() {

        return roomRepository.findAll();

    }


    @Transactional
    public void saveRoom(Room room, MultipartFile imageFile) throws IOException {

        Hotel hotel = hotelRepository.findById(room.getHotel().getId())
                .orElseThrow(() -> new RuntimeException("Hotel With this Id not Found"));

        System.out.println("Hotel "+hotel.toString());

        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = saveImage(imageFile, room);
            room.setImage(imageFilename); // Set the image filename in the user entity
        }

        room.setHotel(hotel);


        roomRepository.save(room);

    }

    public void deleteRoom(int id) {
        roomRepository.deleteById(id);
    }

    public Room findById(int id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room Not Foound by this Id"));
    }

    public List<Room> findRoomByHotelName(String hotelName) {

        return roomRepository.findRoomByHotelName(hotelName);

    }

    public List<Room> findRoomByHotelId(int hotelid) {

        return roomRepository.findRoomByHotelId(hotelid);

    }






    private String saveImage(MultipartFile file, Room r) throws IOException {
        Path uploadPath = Paths.get(uploadDir + "/room");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }


        // Generate a unique filename
        String filename = r.getRoomType() + "_" + UUID.randomUUID().toString();
        Path filePath = uploadPath.resolve(filename);

        // Save the file
        Files.copy(file.getInputStream(), filePath);

        return filename; // Return the filename for storing in the database
    }






}
