package com.towhid.springBootProject6.service;

import com.towhid.springBootProject6.entity.User;
import com.towhid.springBootProject6.repository.UserRepository;
import jakarta.mail.MessagingException;
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
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Value("${image.upload.dir}")
    private String uploadDir;

    @Transactional
    public void saveUser(User user, MultipartFile imageFile) throws MessagingException, IOException {
        // Save the image if it exists
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = saveImage(imageFile);
            user.setImage(imageFilename); // Set the image filename in the user entity
        }

        // Save the user
        userRepository.save(user);

        // Send registration email
        String toEmail = user.getEmail();
        String subject = "Registration Confirmation";
        String body = String.format("Thanks %s, \n Stay with us and your \n User Name is %s.", user.getName(), user.getEmail());
        emailService.sendSimpleEmail(toEmail, subject, body);
    }

    private String saveImage(MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Generate a unique filename
        String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(filename);

        // Save the file
        Files.copy(file.getInputStream(), filePath);

        return filename; // Return the filename for storing in the database
    }
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }

    public User findById(int id){
        return userRepository.findById(id).get();
    }

    public void updateUser(User u){
        userRepository.save(u);
    }


}
