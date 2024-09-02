package com.towhid.springBootProject6.repository;

import com.towhid.springBootProject6.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Integer> {

    
//    public List<Faculty>findByName(String name);
}
