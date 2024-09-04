package com.towhid.hotelmanagement2.restController;

import com.towhid.hotelmanagement2.entity.Room;
import com.towhid.hotelmanagement2.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/room")
public class RoomRestController {

   @Autowired
   private RoomService roomService;

    @PostMapping("/save")
    public ResponseEntity<String> saveRoom(
            @RequestPart(value = "room") Room room,
            @RequestParam(value = "image", required = true) MultipartFile file
    ) throws IOException {

        roomService.saveRoom(room,file);

        return new ResponseEntity<>("Room added successfully with image.", HttpStatus.OK);

    }


}
