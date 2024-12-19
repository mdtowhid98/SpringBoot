package com.towhid.mySoftTask1.service;

import com.towhid.mySoftTask1.entity.Registration;
import com.towhid.mySoftTask1.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public void saveRegistration(Registration r) {

        registrationRepository.save(r);
    }

    public List<Registration> getRegistration() {

        return registrationRepository.findAll();
    }

    public void deleteRegistrationById(int id) {

        registrationRepository.deleteById(id);
    }

    public Registration findByid(int id) {
        return registrationRepository.findById(id).get();
    }



    public Registration updateRegistration(Registration r, int id) {

        return registrationRepository.save(r);
    }

}
