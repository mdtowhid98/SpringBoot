package com.towhid.springBootProject7.restController;

import com.towhid.springBootProject7.Repository.ProductRepository;
import com.towhid.springBootProject7.entity.Category;
import com.towhid.springBootProject7.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")

public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public List<Category> getallFaculty() {
        return categoryService.getAllFaculty();
    }

    @PostMapping("/save")
    public void saveFaculty(@RequestBody Category f) {
//        Department newDep = departmentRepository.findById(f.getDepartment().getId()).get();
//        f.setDepartment(newDep);
        categoryService.saveFaculty(f);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFaculty(@PathVariable int id) {
        categoryService.deleteFacultyById(id);
    }

    @PutMapping("/update/{id}")
    public void updateFaculty(@RequestBody Category f) {
        categoryService.saveFaculty(f);
    }


}
