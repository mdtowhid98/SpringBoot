package com.towhid.springBootProject6.restController;

import com.towhid.springBootProject6.entity.Department;
import com.towhid.springBootProject6.entity.Faculty;
import com.towhid.springBootProject6.repository.DepartmentRepository;
import com.towhid.springBootProject6.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
@CrossOrigin("*")
public class FacultyRestController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/")
    public List<Faculty> getAllFaculty() {
        return facultyService.getAllFaculty();
    }

    @PostMapping("/save")
    public void saveFaculty(@RequestBody Faculty f) {

//        Department newDep=departmentRepository.findById(f.getDepartment().getId()).get();
//        f.setDepartment(newDep);
        facultyService.saveFaculty(f);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFaculty(@PathVariable int id) {
        facultyService.deleteFacultyById(id);
    }

    @PutMapping("/update/{id}")
    public void updateFaculty(@RequestBody Faculty f) {
        facultyService.saveFaculty(f);
    }


}
