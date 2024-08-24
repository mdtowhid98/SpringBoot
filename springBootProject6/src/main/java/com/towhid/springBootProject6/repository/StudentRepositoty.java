package com.towhid.springBootProject6.repository;

import com.towhid.springBootProject6.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoty extends JpaRepository<Student,Integer> {

}
