package com.towhid.pharmacyManagement.service;

import com.towhid.pharmacyManagement.entity.Medicine;
import com.towhid.pharmacyManagement.entity.MedicineGeneric;
import com.towhid.pharmacyManagement.repository.MedicineGenericRepository;
import com.towhid.pharmacyManagement.repository.MedicineRepository;
import com.towhid.pharmacyManagement.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private MedicineGenericRepository medicineCategoryRepository;

    @Value("src/main/resources/static/images")
    private String uploadDir;

//    public void saveMedicine(Medicine m) {
//        MedicineGeneric medicineCategory = medicineCategoryRepository.findById(m.getCategory().getId())
//                .orElseThrow(
//                        () -> new RuntimeException("User not found " + m.getCategory().getId())
//                );
//        m.setCategory(medicineCategory);
//        medicineRepository.save(m);
//    }


    public ApiResponse saveMedicine(Medicine m, MultipartFile imageFile) throws IOException {
        ApiResponse apiResponse = new ApiResponse();
        try {
            MedicineGeneric medicineGeneric = medicineCategoryRepository.findById(m.getGeneric().getId())
                    .orElseThrow(() -> new RuntimeException("Medicine with this id not found"));

            if (imageFile != null && !imageFile.isEmpty()) {
                String imageFileName = saveImage(imageFile, m);
                m.setImage(imageFileName);
            }

            medicineRepository.save(m);
            apiResponse.setSuccessful(true);
            apiResponse.setMessage("Medicine saved successfully");
            return apiResponse;
        } catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            return apiResponse;
        }
    }

    public ApiResponse getAllMedicine() {
        ApiResponse apiResponse = new ApiResponse();
        try {
            List<Medicine> medicines = medicineRepository.findAll();

            Map<String, Object> map = new HashMap<>();
            map.put("medicines", medicines);

            apiResponse.setData(map);
            apiResponse.setSuccessful(true);
            apiResponse.setMessage("All medicines found");
            return apiResponse;
        } catch (Exception e) {
            apiResponse.setMessage(e.getMessage());
            return apiResponse;
        }
    }

    public void deleteMedicineById(long id) {
        medicineRepository.deleteById(id);
    }

    public Medicine findByid(long id) {
        return medicineRepository.findById(id).get();
    }

//    public List<Faculty>findByName(String name){
//        return facultyRepository.findByName(name);
//    };

    public void updateMedicine(Medicine m, long id) {
        medicineRepository.save(m);
    }


    public String saveImage(MultipartFile file, Medicine m) throws IOException {
        Path uploadPath = Paths.get(uploadDir + "/medicine");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String originalFilename = file.getOriginalFilename();
        String fileExtension = originalFilename != null ?
                originalFilename.substring(originalFilename.lastIndexOf('.')) : "";

        String filename = m.getName() + "_" + UUID.randomUUID() + fileExtension;
        Path filePath = uploadPath.resolve(filename);

        Files.copy(file.getInputStream(), filePath);


        return filename;
    }


}
