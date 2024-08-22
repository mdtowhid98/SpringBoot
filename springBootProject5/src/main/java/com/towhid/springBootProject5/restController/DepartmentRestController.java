package com.towhid.springBootProject5.restController;

import com.towhid.springBootProject5.entity.Department;
import com.towhid.springBootProject5.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dep")
public class DepartmentRestController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department>getAllDep(){
        return departmentService.getAllDep();
    }

    @PostMapping("/save")
    public void saveDep(@RequestBody Department d){
        departmentService.saveDep(d);
    }

    public DepartmentService getDepartmentService(){
        return departmentService;
    }

    @DeleteMapping("/delete")
    public void deleteDepById(int id){
        departmentService.deletedepById(id);
    }
@PutMapping("/update")
    public void updateDep(Department d){
        departmentService.updateDep(d);
    }





}
