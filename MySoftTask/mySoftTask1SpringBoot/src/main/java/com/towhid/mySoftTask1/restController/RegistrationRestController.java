package com.towhid.mySoftTask1.restController;

import com.towhid.mySoftTask1.entity.Registration;
import com.towhid.mySoftTask1.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reg")
@CrossOrigin("*")

public class RegistrationRestController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/")
    public List<Registration> getAllRegistration() {

        return registrationService.getRegistration();
    }

    @PostMapping("/save")
    public ResponseEntity<Registration> saveRegistration(@RequestBody Registration r) {
        registrationService.saveRegistration(r);
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRegistration(@PathVariable int id) {

        registrationService.deleteRegistrationById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <Registration>updateRegistration(@RequestBody Registration r,@PathVariable int id) {
        Registration registration= registrationService.updateRegistration(r,id);
        return new ResponseEntity<>(registration, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  Registration getRegistrationById(@PathVariable("id") int id) {

        return  registrationService.findByid(id);

    }

}
