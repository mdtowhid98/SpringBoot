package com.towhid.springBootProject5.restController;

import com.towhid.springBootProject5.entity.Faculty;
import com.towhid.springBootProject5.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
public class FacultyRestController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/")
    public List<Faculty>getAllFaculty(){
        return facultyService.getAllFaculty();
    }
    @PostMapping("/save")
   public void saveFaculty(@RequestBody Faculty f){
        facultyService.saveFaculty(f);
   }

  @DeleteMapping("/delete/{id}")
   public void deleteFaculty(@PathVariable("id")int id){
        facultyService.deleteFacultyByid(id);
   }

   @PutMapping("/update/{id}")
    public void updateFaculty(@RequestBody Faculty f){
        facultyService.updateFaculty(f);
   }







}
