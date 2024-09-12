package com.towhid.practicepharmacy.restController;

import com.towhid.practicepharmacy.entity.Category;
import com.towhid.practicepharmacy.entity.Product;
import com.towhid.practicepharmacy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin("*")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

//    @Autowired
//    private DepartmentRepository departmentRepository;

    @GetMapping("/")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @PostMapping("/save")
    public void saveCategoryy(@RequestBody Category f) {

//        Department newDep=departmentRepository.findById(f.getDepartment().getId()).get();
//        f.setDepartment(newDep);
        categoryService.saveCategory(f);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
    }

    @PutMapping("/update/{id}")
    public void updateCategory(@RequestBody Category f) {
        categoryService.saveCategory(f);
    }




}
