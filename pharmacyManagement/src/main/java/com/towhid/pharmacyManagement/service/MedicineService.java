package com.towhid.pharmacyManagement.service;

import com.towhid.pharmacyManagement.entity.Medicine;
import com.towhid.pharmacyManagement.entity.MedicineGeneric;
import com.towhid.pharmacyManagement.repository.MedicineGenericRepository;
import com.towhid.pharmacyManagement.repository.MedicineRepository;
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


    public void saveMedicine(Medicine m, MultipartFile imageFile) throws IOException {

        MedicineGeneric medicineGeneric = medicineCategoryRepository.findById(m.getGeneric().getId())
                .orElseThrow(() -> new RuntimeException("Medicine with this id not found"));

        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFileName = saveImage(imageFile, m);
            m.setImage(imageFileName);
        }

        medicineRepository.save(m);
    }

    public List<Medicine> getAllMedicine() {
        return medicineRepository.findAll();
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

        String filename = m.getName() + "_" + UUID.randomUUID().toString();
        Path filePath = uploadPath.resolve(filename);

        Files.copy(file.getInputStream(), filePath);


        return filename;
    }


}
