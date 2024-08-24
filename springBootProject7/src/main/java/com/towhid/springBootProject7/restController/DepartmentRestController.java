package com.towhid.springBootProject7.restController;

import com.towhid.springBootProject7.entity.Department;
import com.towhid.springBootProject7.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentRestController {

   @Autowired
   private DepartmentService departmentService;
   @GetMapping("/")
   public List<Department>getAlldep(){
       return departmentService.getAllDep();
   }
   @PostMapping("/save")
   public void saveDep(@RequestBody Department d){
       departmentService.saveDep(d);
   }
   @DeleteMapping("/delete/{id}")
   public void deleteDep(@PathVariable int id){
       departmentService.deletedepById(id);
   }

   @PutMapping("/update/{id}")
   public void updateDep(@RequestBody Department d){

       departmentService.saveDep(d);
   }


}
